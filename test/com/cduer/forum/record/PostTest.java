package com.cduer.forum.record;

import static org.junit.Assert.assertNotNull;
import li.annotation.Inject;
import li.test.BaseTest;

import org.junit.Test;

public class PostTest extends BaseTest {
	@Inject
	Post post;

	@Test
	public void testList() {
		assertNotNull(post);
	}
}
