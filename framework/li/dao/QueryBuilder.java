package li.dao;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.sql.DataSource;

import li.model.Bean;
import li.model.Field;
import li.util.Page;
import li.util.Reflect;
import li.util.Verify;

/**
 * Dao的辅助类,用以组装SQL
 * 
 * @author li (limw@w.cn)
 * @version 0.1.8 (2012-05-08)
 */
public class QueryBuilder {
    /**
     * 私有实例变量,表示对象结构的beanMeta
     */
    protected Bean beanMeta;

    /**
     * 私有实例变量,数据源,用以探测数据表结构
     */
    protected DataSource dataSource;

    /**
     * 根据传入的ID,构建一个用于删除单条记录的SQL
     */
    public String deleteById(String id) {
        return "DELETE FROM " + beanMeta.table + " WHERE " + beanMeta.getId().column + "=" + id;
    }

    /**
     * 根据传入的SQL,构建一个用于删除若干条记录的SQL
     * 
     * @param sql 传入的sql语句,可以包含'?'占位符和具名占位符
     * @param args 替换sql中占位符的值,或者对应具名占位符的Map
     * @see li.dao.QueryBuilder#setArgs(String, Object[])
     */
    public String deleteBySql(String sql, Object[] args) {
        if (!Verify.startWith(sql, "DELETE")) {
            sql = "DELETE FROM " + beanMeta.table + " " + sql;
        }
        return setArgs(sql, args);// 处理args
    }

    /**
     * 构造默认的COUNT(*)查询的SQL,查询表中的总记录数
     */
    public String count() {
        return "SELECT COUNT(*) FROM " + beanMeta.table;
    }

    /**
     * 根据传入的SQL,构造一个用于COUNT(*)查询的SQL
     * 
     * @param sql 传入的sql语句,可以包含'?'占位符和具名占位符
     * @param args 替换sql中占位符的值,或者对应具名占位符的Map
     * @see li.dao.QueryBuilder#setArgs(String, Object[])
     */
    public String countBySql(String sql, Object[] args) {
        if (!Verify.startWith(sql, "SELECT")) {
            sql = "SELECT COUNT(*) FROM " + beanMeta.table + " " + sql;
        } else if (!Verify.contain(sql, "COUNT(*)")) {
            sql = "SELECT COUNT(*) FROM " + sql.substring(sql.toUpperCase().indexOf("FROM") + 4, sql.length()).trim();
        }
        if (Verify.contain(sql, "LIMIT")) {
            sql = sql.substring(0, sql.toUpperCase().indexOf("LIMIT"));// 去掉limit部分
        }
        return setArgs(sql, args);// 处理args
    }

    /**
     * 使用传入的ID,构造一个用于查询一条记录的SQL
     */
    public String findById(String id) {
        String sql = "SELECT * FROM " + beanMeta.table + " WHERE " + beanMeta.getId().column + "=" + id;
        return setPage(sql, new Page(1, 1));
    }

    /**
     * 使用传入的SQL和参数,构造一个用于查询一条记录的SQL
     */
    public String find(String sql, Object[] args) {
        if (!Verify.startWith(sql, "SELECT")) {// 添加SELECT * FROM table 部分
            sql = "SELECT * FROM " + beanMeta.table + " " + sql;
        }
        return setPage(setArgs(sql, args), new Page(1, 1));// 先处理别名,再处理page
    }

    /**
     * 使用传入的page,构造一个用于分页查询的SQL
     * 
     * @param page 分页对象
     */
    public String list(Page page) {
        return listBySql(page, "SELECT * FROM " + beanMeta.table, null);
    }

    /**
     * 根据传入的SQL和page,构造一个用于分页查询的SQL
     * 
     * @param page 分页对象
     * @param sql 传入的sql语句,可以包含'?'占位符和具名占位符
     * @param args 替换sql中占位符的值,或者对应具名占位符的Map
     * @see li.dao.QueryBuilder#setPage(String, Page)
     * @see li.dao.QueryBuilder#setArgs(String, Object[])
     */
    public String listBySql(Page page, String sql, Object[] args) {
        if (!Verify.startWith(sql, "SELECT")) {// 添加SELECT * FROM table 部分
            sql = "SELECT * FROM " + beanMeta.table + " " + sql;
        }
        if (null == page) {
            page = new Page();
        }
        return setPage(setArgs(setAlias(sql), args), page);// 先处理别名,再处理args,最后处理page
    }

    /**
     * 根据传入的对象构建一个用于更新一条记录的SQL
     */
    public String update(Object object) {
        String sets = " SET ";
        for (Field field : beanMeta.fields) {
            Object fieldValue = Reflect.get(object, field.name);
            if (!beanMeta.getId().name.equals(field.name)) {// 更新所有属性,fieldValue可能为null
                sets += field.column + "='" + fieldValue + "',";
            }
        }
        Object id = Reflect.get(object, beanMeta.getId().name);
        sets = sets.substring(0, sets.length() - 1);
        return "UPDATE " + beanMeta.table + sets + " WHERE " + beanMeta.getId().column + "=" + id;
    }

    /**
     * 根据传入的对象构建一个用于更新一条记录的SQL,忽略对象中值为null的属性
     */
    public String updateIgnoreNull(Object object) {
        String sets = " SET ";
        for (Field field : beanMeta.fields) {
            Object fieldValue = Reflect.get(object, field.name);
            if (!beanMeta.getId().name.equals(field.name) && null != fieldValue) {// 不更新fieldValue为null的属性
                sets += field.column + "='" + fieldValue + "',";
            }
        }
        Object id = Reflect.get(object, beanMeta.getId().name);
        sets = sets.substring(0, sets.length() - 1);
        return "UPDATE " + beanMeta.table + sets + " WHERE " + beanMeta.getId().column + "=" + id;
    }

    /**
     * 根据传入的SQL,构建一个用于更新若干条记录的SQL
     * 
     * @param sql 传入的sql语句,可以包含'?'占位符和具名占位符
     * @param args 替换sql中占位符的值,或者对应具名占位符的Map
     * @see li.dao.QueryBuilder#setArgs(String, Object[])
     */
    public String updateBySql(String sql, Object[] args) {
        if (Verify.startWith(sql, "SET")) {
            sql = "UPDATE " + beanMeta.table + " " + sql;
        }
        return setArgs(sql, args);// 处理args
    }

    /**
     * 根据传入的对象构建一个插入一条记录的SQL
     */
    public String save(Object object) {
        String columns = " (", values = " VALUES (";
        for (Field field : beanMeta.fields) {
            if (!beanMeta.getId().name.equals(field.name)) {
                Object fieldValue = Reflect.get(object, field.name);
                columns += field.column + ",";
                values += (null == fieldValue ? "NULL" : "'" + fieldValue + "'") + ",";
            }
        }
        columns = columns.substring(0, columns.length() - 1) + ")";
        values = values.substring(0, values.length() - 1) + ")";
        return "INSERT INTO " + beanMeta.table + columns + values;
    }

    /**
     * 如果args不为空的话,SQL会用args逐次替换SQL中的占位符
     * 
     * @param sql 传入的sql语句,可以包含'?'占位符或者具名参数占位符
     * @param args 替换sql中 '?' 或具名参数占位符的值
     * @see li.dao.QueryBuilder#setArgMap(String, Map)
     */
    public String setArgs(String sql, Object[] args) {
        if (null != sql && sql.length() > 0 && null != args && args.length > 0) {// 非空判断
            for (int i = 0; i < args.length; i++) {
                if (args[i] instanceof Map) {
                    sql = setArgMap(sql, (Map) args[i]);// 替换具名参数
                } else {
                    sql = sql.replaceFirst("[?]", "'" + args[i] + "'");// 为参数加上引号后替换问号
                }
            }
        }
        return sql;
    }

    /**
     * 用Map中的值替换SQL中的具名参数
     * 
     * @param sql 传入的sql语句,可以包含':name'占位符
     * @param argMap 替换sql中 ':key' 的键值Map
     */
    public String setArgMap(String sql, Map<?, ?> argMap) {
        if (null != sql && sql.length() > 0 && null != argMap && argMap.size() > 0) {// 非空判断
            for (Entry<?, ?> arg : argMap.entrySet()) {
                sql = sql.replaceFirst(arg.getKey() + "", "'" + arg.getValue() + "'");// 为参数加上引号后替换问号
            }
        }
        return sql;
    }

    /**
     * 为SQL添加分页语句
     */
    public String setPage(String sql, Page page) {
        if (!Verify.contain(sql, "LIMIT")) {// 分页
            return sql + " LIMIT " + page.getFrom() + "," + page.getPageSize();
        }
        return sql;
    }

    /**
     * 处理批量别名,将类似 SELECT t_account.#,t_member.# AS member_# FROM t_account,t_member的SQL转换为标准SQL
     */
    public String setAlias(final String sql) {
        int index = sql.indexOf(".#");
        if (index > 5) {// 如果有替换字符,则开始处理,否则直接返回
            final int end = index + 2;// end为第一个#的位置

            int s1 = sql.substring(0, end).lastIndexOf(" ") + 1;// #之前最后一个空格的位置
            int s2 = sql.substring(0, end).lastIndexOf(",") + 1;// #之前最后一个,的位置
            final int start = s1 > s2 ? s1 : s2;// table.#部分开始位置

            int asIndex = sql.toUpperCase().indexOf(" AS ", end);// end之后第一个AS的位置

            String replacement = "";// 申明替换部分字符串
            int toreplaceEnd = (asIndex > 0 && asIndex - end < 3) ? sql.indexOf("#", asIndex) + 1 : end;// 如果有AS,截取到AS后的第一个#,如果没有AS,截取到end
            String toreplace = sql.substring(start, toreplaceEnd);// 求出被替换部分字符串
            final String table = sql.substring(start, end - 2);// 求得表名
            List<Field> fields = Field.list(dataSource, table);
            for (Field field : fields) {// 构造替换字符串
                if (asIndex > 0 && asIndex - end < 3) {// 如果有AS
                    String fix = toreplace.substring(asIndex - start, toreplace.length() - 1);// 取得AS+别名前缀,如AS member_
                    replacement = replacement + (table + "." + field.column) + (fix + field.column) + ",";// 构造一列加AS
                } else {
                    replacement = replacement + table + "." + field.column + ",";// 构造一列不加AS
                }
            }

            // 替换,去掉最后一个逗号
            String result = sql.replaceFirst(toreplace, replacement.substring(0, replacement.length() - 1));

            return setAlias(result);// 处理下一个
        }
        return sql;// 如果SQL中不包含#,则直接返回
    }
}