package li.util;

import li.test.BaseTest;

import org.junit.Test;

public class LogTest extends BaseTest {
    private static final Log LOG = Log.init();

    @Test
    public void test() {
        LOG.info("LOG测试信息");
    }

    @Test
    public void put() {
        Log.put("123", "123");
    }

    @Test
    public void get() {
        Log.get("123");
    }
}