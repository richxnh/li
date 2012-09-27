package li.ioc;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class IocTest {
	@Test
	public void getByName() {
		assertNotNull(Ioc.get("beanA"));
	}

	@Test
	public void getByTypeAndName() {
		assertNotNull(Ioc.get(A.class, "beanA"));
	}

	public void getByType() {
		assertNotNull(Ioc.get(A.class));
	}
}