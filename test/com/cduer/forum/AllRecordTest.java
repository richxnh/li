package com.cduer.forum;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.cduer.forum.record.AccountTest;
import com.cduer.forum.record.ForumTest;
import com.cduer.forum.record.MemberTest;
import com.cduer.forum.record.PostTest;
import com.cduer.forum.record.ThreadTest;

@RunWith(Suite.class)
@SuiteClasses({ AccountTest.class, ForumTest.class, MemberTest.class, PostTest.class, ThreadTest.class })
public class AllRecordTest {
}