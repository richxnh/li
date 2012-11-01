package li.quartz;

public class Demo {
    /**
     * JUnit不支持多线程的测试,不能用于测试Quartz
     */
    public static void main(String[] args) {
        Quartz.start();
    }
}