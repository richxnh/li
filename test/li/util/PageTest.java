package li.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PageTest {
    @Test
    public void test() {
        Page page = new Page();
        page.setRecordCount(100);
        assertEquals(20 + "", page.getPageSize() + "");
    }
}