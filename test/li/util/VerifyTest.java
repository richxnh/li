package li.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import li.test.BaseTest;

import org.junit.Test;

public class VerifyTest extends BaseTest {
    @Test
    public void basicType() {
        assertTrue(Verify.basicType(int.class));
        assertTrue(Verify.basicType(Integer.class));
        assertFalse(Verify.basicType(this.getClass()));
    }

    @Test
    public void contain() {
        assertTrue(Verify.contain("12345", "123"));
        assertTrue(Verify.contain("ABCDE", "bCd"));
    }

    @Test
    public void endWith() {
        assertTrue(Verify.endWith("abcdefg", "efg"));
    }

    @Test
    public void isEmpty() {
        assertTrue(Verify.isEmpty("   "));
    }

    @Test
    public void regex() {
        assertTrue(Verify.regex("abcdefg", ".*"));
    }

    @Test
    public void startWith() {
        assertTrue(Verify.startWith("abcdefg", "abc"));
    }
}