package com.cduer.forum.action;

import static org.junit.Assert.assertNotNull;
import li.annotation.Inject;
import li.test.BaseActionTest;

import org.junit.Test;

public class MemberActionTest extends BaseActionTest {
	@Inject
	MemberAction memberAction;

	@Test
	public void find() {
		assertNotNull(memberAction);
		memberAction.find(1);
	}

	@Test
	public void test1() {
		// memberAction.test1(context);
	}

	@Test
	public void testFreemarker() {
		assertNotNull(memberAction);
		// memberAction.testFreemarker(context);
	}

	@Test
	public void testVelocity() {
		assertNotNull(memberAction);
		// memberAction.testVelocity(context);
	}

}