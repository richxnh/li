package demo.record;

import static org.junit.Assert.*;
import li.annotation.Inject;
import li.test.BaseTest;

import org.junit.Before;
import org.junit.Test;

import demo.record.Forum;

public class ForumTest extends BaseTest {
	@Inject
	Forum forum;

	@Before
	public void before() {
		assertNotNull(forum);
	}

	@Test
	public void testList() {
	}
}
