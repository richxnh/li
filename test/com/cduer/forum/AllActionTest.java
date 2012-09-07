package com.cduer.forum;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.cduer.forum.action.AccountActionTest;
import com.cduer.forum.action.ForumActionTest;
import com.cduer.forum.action.MemberActionTest;
import com.cduer.forum.action.PostActionTest;
import com.cduer.forum.action.ThreadActionTest;

@RunWith(Suite.class)
@SuiteClasses({ AccountActionTest.class, ForumActionTest.class, MemberActionTest.class, PostActionTest.class, ThreadActionTest.class })
public class AllActionTest {
}