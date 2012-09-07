package t;

import javax.sql.DataSource;

import li.ioc.Ioc;
import li.model.Field;

public class T3 {
	public static void main(String[] args) throws Throwable {
		DataSource dataSource = Ioc.get(DataSource.class);
		// String sql1 =
		// "select t_thread.id,t_thread.subject,t_thread.content,t_thread.forum_id,t_thread.member_id,t_thread.status,t_member.id as member_id,t_member.status as member_status,t_member.name as member_name,t_member.account_id as member_account_id from t_thread,t_member where t_thread.forum_id='1' and t_thread.member_id=t_member.id LIMIT 0,20";

		String sql = "select t_thread.#,t_member.# as member_# from t_thread,t_member where t_thread.forum_id='1' and t_thread.member_id=t_member.id LIMIT 0,20";

		System.out.println(replace(dataSource, sql));
	}

	public static String replace(DataSource dataSource, String sql) {
		int end = sql.indexOf("#") + 1;
		int start1 = sql.substring(0, end).lastIndexOf(" ") + 1;
		int start2 = sql.substring(0, end).lastIndexOf(",") + 1;
		int start = start1 > start2 ? start1 : start2;

		String todo;
		if (sql.toUpperCase().indexOf(" AS ") - end < 3) {
			todo = sql.substring(start, sql.replaceFirst("#", "井号").indexOf("#"));
		} else {
			todo = sql.substring(start, end);
		}

		String table = sql.substring(start, end - 2);
		String rep = "";

		for (Field field : Field.list(dataSource, table)) {
			if (sql.toUpperCase().indexOf(" AS ") - end < 3) {
				String fix = todo.substring(todo.toUpperCase().indexOf(" AS "), todo.length() - 1);
				rep += table + "." + field.column + (fix + field.column) + ",";
			} else {
				rep += table + "." + field.column + ",";
			}
		}
		String result = sql.replaceFirst(todo, rep.substring(0, rep.length() - 1));

		if (result.indexOf("#") < 0) {
			return result;
		} else {
			return replace(dataSource, result);
		}
	}
}