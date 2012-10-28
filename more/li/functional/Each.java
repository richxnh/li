package li.functional;

import java.util.Arrays;
import java.util.Collection;

public class Each {
    public static Object[] in(Function function, Object[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = function.invoke(array[i]);
        }
        return array;
    }

    public static Collection in(Function function, Collection collection) {
        return Arrays.asList(in(function, collection.toArray()));
    }
}