package net.udp.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

import net.udp.T;

/*
 * 服务器/ 接受端
 */
public class Recive extends Thread {
	DatagramSocket datagramSocket;

	public Recive() {
		try {
			datagramSocket = new DatagramSocket(T.PORT);
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		while (true) {
			byte[] buf = new byte[1024];
			DatagramPacket dPacket = new DatagramPacket(buf, buf.length);
			try {
				datagramSocket.receive(dPacket);
				String IP = dPacket.getAddress().getHostAddress();
				String data = new String(dPacket.getData(), 0, dPacket.getLength());
				int portString = dPacket.getPort();
				System.out.println("IP:" + IP + "端口:" + portString + "\n" + data);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}