package li.dao;

import java.util.HashMap;
import java.util.Map;

import li.test.BaseTest;

import org.junit.Test;

public class QueryBuilderTest extends BaseTest {
	private static final QueryBuilder QUERY_BUILDER = new QueryBuilder();

	@Test
	public void testSetArgs2() {
		String sql = "SELECT * FROM t_account where username=#username";
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("#username", "uuu");
		sql = QUERY_BUILDER.setArgs(sql, args);

		System.out.println(sql);
	}
}
