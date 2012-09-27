package li.dao;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import javax.sql.DataSource;

import li.ioc.Ioc;
import li.model.Bean;
import li.test.BaseTest;
import li.util.Convert;
import li.util.Page;

import org.junit.Before;
import org.junit.Test;

import demo.model.User;

public class QueryBuilderTest extends BaseTest {
	DataSource dataSource = Ioc.get(DataSource.class);

	QueryBuilder queryBuilder = new QueryBuilder(dataSource, Bean.getMeta(dataSource, User.class));

	User user = new User();

	@Before
	public void before() throws Exception {

		user.setId(1);
		user.setUsername("username-1");
		user.setPassword("password-1");
		user.setEmail("email-1");
	}

	@Test
	public void count() {
		assertEquals("SELECT COUNT(*) FROM t_account", queryBuilder.count());
	}

	@Test
	public void countBySql() {
		assertEquals("SELECT COUNT(*) FROM t_account WHERE id>'1'", queryBuilder.countBySql("WHERE id>?", new Object[] { "1" }));
	}

	@Test
	public void delete() {
		assertEquals("DELETE FROM t_account WHERE id='1'", queryBuilder.deleteBySql("WHERE id=?", new Object[] { "1" }));
	}

	@Test
	public void deleteById() {
		assertEquals("DELETE FROM t_account WHERE id=1", queryBuilder.deleteById("1"));
	}

	@Test
	public void findById() {
		assertEquals("SELECT * FROM t_account WHERE id=123 LIMIT 0,1", queryBuilder.findById("123"));
	}

	@Test
	public void list() {
		assertEquals("SELECT * FROM t_account LIMIT 0,20", queryBuilder.list(page));
	}

	@Test
	public void listBySql() {
		assertEquals("SELECT * FROM t_account WHERE id>'1' LIMIT 0,20", queryBuilder.listBySql(page, "WHERE id>?", new Object[] { "1" }));
	}

	@Test
	public void save() {
		assertEquals("INSERT INTO t_account (username,password,email) VALUES ('username-1','password-1','email-1')", queryBuilder.save(user));
	}

	@Test
	public void setAlias() {
		String expected = "SELECT t_account.id,t_account.username,t_account.password,t_account.email FROM t_account";
		String actual = queryBuilder.setAlias("SELECT t_account.# FROM t_account");
		// assertEquals(expected, actual);
	}

	@Test
	public void setArgMap() {
		String sql = "SELECT * FROM WHERE id=:id OR username LIKE :username";
		Map<Object, Object> map = Convert.toMap(":id", 1, ":username", "%li%");
		assertEquals("SELECT * FROM WHERE id='1' OR username LIKE '%li%'", queryBuilder.setArgMap(sql, map));
	}

	@Test
	public void setArgs() {
		String sql = "SELECT * FROM WHERE id=? OR username LIKE ?";
		Object[] args = { 1, "%li%" };
		assertEquals("SELECT * FROM WHERE id='1' OR username LIKE '%li%'", queryBuilder.setArgs(sql, args));
	}

	@Test
	public void setPage() {
		assertEquals("SELECT * FROM t_account LIMIT 0,20", queryBuilder.setPage("SELECT * FROM t_account", page));
	}

	@Test
	public void testSetAlias() {
		String sql = "SELECT t_account.#,t_forum.# as f_#,t_member.#,t_post.# AS p_# FROM t_account";
		sql = queryBuilder.setAlias(sql);
		System.err.println(sql);
	}

	@Test
	public void testSetArgs() {
		String sql = "SELECT * FROM t_account where username=?";
		Object[] args = { "uuu" };

		sql = queryBuilder.setArgs(sql, args);

		System.out.println(sql);
	}

	@Test
	public void testSetArgs2() {
		String sql = "SELECT * FROM t_account where username=#username";
		Map<Object, Object> args = Convert.toMap("#username", "uuu");
		sql = queryBuilder.setArgMap(sql, args);

		System.out.println(sql);
	}

	@Test
	public void testSetPage() {
		String sql = "SELECT * FROM t_account";
		sql = queryBuilder.setPage(sql, new Page(1, 1));
		System.err.println(sql);
	}

	@Test
	public void update() {
		String sql = "UPDATE t_account SET username='username-1',password='password-1',email='email-1' WHERE id=1";
		assertEquals(sql, queryBuilder.update(user));
	}

	@Test
	public void updateBySql() {
		assertEquals("UPDATE t_account SET email='eml' WHERE id>'3'", queryBuilder.updateBySql("SET email=? WHERE id>?", new Object[] { "eml", 3 }));
	}
}
