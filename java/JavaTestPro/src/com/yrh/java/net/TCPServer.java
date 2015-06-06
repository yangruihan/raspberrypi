package com.yrh.java.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现 TCP 通信
 * 服务器端代码
 * @author Yrh
 *
 */
public class TCPServer {

	public static void main(String[] args) throws IOException {
		// 新建一个 ServerSocket 实例，端口为9236
		ServerSocket serverSocket = new ServerSocket(9236);
		
		System.out.println("***服务器即将启动，等待客户端连接***");
		
		// 记录一下当前客户端数量
		int count = 0;
		
		// 通过死循环来不断监听客户端的连接
		Socket socket = null;
		while (true) {
			// 通过 ServerSocket 的 accept 方法，返回一个 Socket 实例
			socket = serverSocket.accept();
			// 新建一个服务器线程
			TCPServerThread serverThread = new TCPServerThread(socket);
			// 开始线程
			serverThread.start();
			
			System.out.println("当前客户端数量：" + ++count);
			
			// 获得当前客户端的 InetAddress
			InetAddress inetAddress = socket.getInetAddress();
			// 输出客户端 ip 地址
			System.out.println("当前客户端 ip 为：" + inetAddress.getHostAddress());
		}
		
	}
}
