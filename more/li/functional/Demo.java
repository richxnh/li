package li.functional;

import java.util.Arrays;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List list = (List) Each.in(new Function() {
            public Object invoke(Object... args) {
                System.out.print(args[0] + "\t");
                return args[0];
            }
        }, Each.in(new Function() {
            public Object invoke(Object... args) {
                return (Integer) args[0] * 2;
            }
        }, Arrays.asList(1, 2, 3, 4, 5)));

        Each.in(new Function() {
            public Object invoke(Object... args) {
                System.out.print(args[0] + "\t");
                return args[0];
            }
        }, list);
    }
}