package net.udp.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import net.udp.T;

/*
 * 客服端/发送端
 */
@SuppressWarnings("resource")
public class Send extends Thread {
	public void run() {
		try {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));// 从键盘读取数据
			String string;
			while ((string = bufferedReader.readLine()) != null) {// 循环读取
				byte[] buf = string.getBytes();// 将输入的字符串转换为字节数组
				String IP = InetAddress.getLocalHost().getHostAddress().toString();
				DatagramPacket dPacket = new DatagramPacket(buf, buf.length, InetAddress.getByName(IP), T.PORT);
				new DatagramSocket().send(dPacket);
			}
		} catch (Exception e) {
			System.err.println("发送数据失败");
			e.printStackTrace();
		}
	}

}