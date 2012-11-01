package li.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ReflectTest {
    @Test
    public void copy() {
        _Model2 attr = new _Model2();
        attr.attr1 = "Model2.attr.attr1";

        _Model1 model1 = new _Model1();
        model1.attr1 = "123123";
        model1.attr2 = false;
        model1.model2 = attr;

        _Model2 model2 = new _Model2();
        Reflect.copy(model1, model2);

        assertEquals("123123", model2.attr1);
        assertEquals(false, model2.attr2);
        assertEquals(attr, model2.model2);
    }

    @Test
    public void testActualType() {
        System.out.println(Reflect.actualType(ReflectTest.class, 9));
    }
}