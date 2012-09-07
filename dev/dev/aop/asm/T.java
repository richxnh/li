package dev.aop.asm;

public class T {
	public static void main(String[] args) throws Throwable {
		Account account = Generator.wrap(Account.class);
		account.operation1();
		account.operation2();
		account.operation3();
	}
}