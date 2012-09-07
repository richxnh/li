package li.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.sql.DataSource;

import li.ioc.Ioc;
import li.util.Convert;

public class StoredProcedure {
	static DataSource dataSource = Ioc.get(DataSource.class);
	static QueryBuilder queryBuilder = new QueryBuilder();

	public static void main(String[] args) throws Exception {
		Map<String, Integer> outParamTypes = (Map<String, Integer>) Convert.toMap("");
		Map<?, ?> inParams = Convert.toMap("num1", 1, "num2", 2);
		call("{ ? = call procedure_name(:num1,:num2) }", outParamTypes, inParams);
	}

	/**
	 * 调用存储过程
	 * 
	 * @param sql 调用存储过程的SQL
	 * @param outParamTypes 输出参数列表
	 * @param inParams 输入参数
	 * @return 输出参数
	 * @throws Exception
	 */
	public static Map<?, ?> call(String sql, Map<String, Integer> outParamTypes, Object... inParams) throws Exception {
		sql = getQueryBuilder().setArgs(sql, inParams);// 设置输入参数
		Connection connection = getConnection();
		CallableStatement statement = connection.prepareCall(sql);
		if (null != outParamTypes && outParamTypes.size() > 0) {// 注册输出参数
			for (Entry<String, Integer> entry : outParamTypes.entrySet()) {
				statement.registerOutParameter(entry.getKey(), entry.getValue());
			}
		}
		statement.execute();// 执行存储过程
		Map<String, Object> result = new HashMap<String, Object>();
		for (Entry<String, Integer> entry : outParamTypes.entrySet()) {
			result.put(entry.getKey(), statement.getObject(entry.getKey()));
		}
		statement.close();
		connection.close();
		return result;
	}

	public static Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static QueryBuilder getQueryBuilder() {
		return queryBuilder;
	}
}