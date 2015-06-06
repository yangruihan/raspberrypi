package com.yrh.java.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 实现 UDP 通信
 * 客户端代码
 * @author Yrh
 *
 */
public class UDPClient {

	public static void main(String[] args) throws IOException {
		// 获得地址、端口、内容
		InetAddress address = InetAddress.getByName("127.0.0.1");
		int port = 9236;
		byte[] content = "用户名：admin;密码：123".getBytes();
		// 根据上面的信息生成 DatagramPacket 实例 
		DatagramPacket packet = new DatagramPacket(content, content.length, address, port);
		// 生成 DatagramSocket 实例
		DatagramSocket socket = new DatagramSocket();
		// 发送信息
		socket.send(packet);
		
		byte[] serverInfo = new byte[1024];
		// 新建一个 DatagramPacket 实例，用来接受从服务器发来的信息
		DatagramPacket packet2 = new DatagramPacket(serverInfo, serverInfo.length);
		// 接收 DatagramPacket
		socket.receive(packet2);
		// 显示信息
		System.out.println("客户端接收信息，服务器说：" + new String(serverInfo, 0, packet2.getLength()));
		
		// 关闭 DatagramSocket
		socket.close();
	}
}
