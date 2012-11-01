package li.mvc;

import static org.junit.Assert.assertNotNull;
import li.test.ActionTest;

import org.junit.Before;
import org.junit.Test;

public class ContextTest extends ActionTest {
    @Before
    public void before() {
        Context.init(request, response, null);
    }

    @Test
    public void getRequest() {
        assertNotNull(Context.getRequest());
    }

    @Test
    public void getResponse() {
        assertNotNull(Context.getResponse());
    }
}