package com.cduer.forum.record;

import static org.junit.Assert.assertNotNull;
import li.annotation.Inject;
import li.test.BaseTest;

import org.junit.Test;

public class MemberTest extends BaseTest {
	@Inject
	Member member;

	@Test
	public void testList() {
		assertNotNull(member);
	}
}