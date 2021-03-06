package demo;

import li.FrameworkTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import demo.action.AccountActionTest;
import demo.action.DemoActionTest;
import demo.action.ForumActionTest;
import demo.action.MemberActionTest;
import demo.action.PostActionTest;
import demo.action.ThreadActionTest;
import demo.record.AccountTest;
import demo.record.ForumTest;
import demo.record.MemberTest;
import demo.record.PostTest;
import demo.record.ThreadTest;

@RunWith(Suite.class)
@SuiteClasses({ FrameworkTest.class, //
        AccountTest.class, ForumTest.class, MemberTest.class, PostTest.class, ThreadTest.class,//
        DemoActionTest.class, AccountActionTest.class, MemberActionTest.class, ForumActionTest.class,//
        PostActionTest.class, ThreadActionTest.class })
public class AllTest {

}