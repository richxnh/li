package li.dao;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import li.ioc.Ioc;
import li.model.Bean;
import li.test.BaseTest;

import org.junit.Before;
import org.junit.Test;

import com.cduer.forum.record.Account;

public class QueryBuilderTest extends BaseTest {
	private QueryBuilder QUERY_BUILDER;

	@Before
	public void before() {
		QUERY_BUILDER = new QueryBuilder(Bean.getMeta(Ioc.get(DataSource.class), Account.class));
	}

	@Test
	public void testSetArgs2() {
		String sql = "SELECT * FROM t_account where username=#username";
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("#username", "uuu");
		sql = QUERY_BUILDER.setArgs(sql, args);

		System.out.println(sql);
	}
}
