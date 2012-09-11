package li;

import li.dao.DaoOfRecordTest;
import li.dao.PageTest;
import li.dao.QueryBuilderTest;
import li.dao.RecordTest;
import li.dao.RecordTransTest;
import li.dao.TransTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ PageTest.class, RecordTest.class, RecordTransTest.class, DaoOfRecordTest.class, QueryBuilderTest.class, TransTest.class })
public class AllDaoTest {

}