package com.yrh.java.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 服务器线程 用来模拟多线程登录
 * 
 * @author Yrh
 *
 */
public class UDPServerThread extends Thread {

	DatagramSocket socket = null;
	DatagramPacket data = null;

	public UDPServerThread(DatagramSocket socket, DatagramPacket data) {
		this.socket = socket;
		this.data = data;
	}

	/*
	 * 覆写 run 方法
	 * 
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		super.run();

		// 解析用户发送的信息
		String userInfo = new String(data.getData(), 0, data.getLength());
		// 打印
		System.out.println("服务器读取数据，客户端说：" + userInfo);

		// 返回客户端一个信息
		byte[] serverInfo = "欢迎您".getBytes();
		InetAddress address = data.getAddress();
		int port = data.getPort();

		System.out.println("地址：" + address.getHostAddress());
		System.out.println("端口：" + port);

		// 根据上面的信息生成 DatagramPacket 实例
		DatagramPacket packet2 = new DatagramPacket(serverInfo,
				serverInfo.length, address, port);
		// 发送信息
		try {
			socket.send(packet2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
