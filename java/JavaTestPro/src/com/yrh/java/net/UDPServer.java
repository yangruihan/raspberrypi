package com.yrh.java.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 实现 UDP 通信 服务器端代码
 * 
 * @author Yrh
 *
 */
public class UDPServer {

	public static void main(String[] args) throws IOException {
		// 实现一个 DatagramSocket 实例，并指定端口，用来接受数据报
		DatagramSocket socket = new DatagramSocket(9236);
		// 获得一个 DatagramPacket 实例
		byte[] info = new byte[1024];
		DatagramPacket data = null;
		// 接受客户端发送的信息
		System.out.println("***服务器即将启动，等待客户端连接***");
		// 计数器
		int count = 0;
		
		while (true) {
			// 新建一个 DatagramPacket
			data = new DatagramPacket(info, info.length);
			
			// 接受 DatagramPacket
			socket.receive(data);
			
			// 创建一个线程实例
			UDPServerThread thread = new UDPServerThread(socket, data);
			
			// 开始线程
			thread.start();
			
			System.out.println("\n这是第" + ++count + "台客户端");
		}
	}
}
