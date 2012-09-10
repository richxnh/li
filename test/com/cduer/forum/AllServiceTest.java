package com.cduer.forum;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.cduer.forum.service.UserServiceTest;

@RunWith(Suite.class)
@SuiteClasses({ UserServiceTest.class })
public class AllServiceTest {

}
