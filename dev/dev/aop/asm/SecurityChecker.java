package dev.aop.asm;

public class SecurityChecker {
	public static void checkSecurity(String msg) {
		System.out.println("SecurityChecker.checkSecurity ... " + msg);
	}

	public static void check1(String msg) {
		System.out.println("SecurityChecker.check1 ... " + msg);
	}

	public static void check2(Integer msg) {
		System.out.println("SecurityChecker.check2 ... " + msg);
	}

	public static void check3(String msg, Integer num) {
		System.out.println("SecurityChecker.check3 ... " + msg + "\t" + num);
	}

	public static void check4(String msg, String msg2) {
		System.out.println("SecurityChecker.check4 ... " + msg + "\t" + msg2);
	}
}