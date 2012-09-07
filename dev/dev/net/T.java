package dev.net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

@SuppressWarnings({ "resource", "unused" })
public class T {
	public static void main(String[] args) throws Throwable {
		DatagramSocket server = new DatagramSocket(5000);
		byte[] buf = new byte[1024];
		DatagramPacket packet = new DatagramPacket(buf, buf.length);
		server.receive(packet);
		String receive = new String(packet.getData(), 0, packet.getLength());

	}
}