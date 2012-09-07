package net.udp;

import net.udp.net.Recive;
import net.udp.net.Send;

public class T {
	public static final Integer PORT = 9878;

	public static void main(String[] args) throws Exception {
		new Recive().start();
		new Send().start();
	}
}