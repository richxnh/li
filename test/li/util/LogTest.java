package li.util;

import li.test.BaseTest;

import org.junit.Test;

public class LogTest extends BaseTest {
    private static final Log LOG = Log.init();

    @Test
    public void test() {
        LOG.info("LOG测试信息");
    }
}