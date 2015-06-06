package com.yrh.java.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 实现 TCP 通信
 * 客户器端代码
 * @author Yrh
 *
 */
public class TCPClient {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		// 创建一个 Socket 实例，并设置目标 ip 及端口号
		Socket socket = new Socket("127.0.0.1", 9236);
		// 获得 OutputStream 实例
		OutputStream os = socket.getOutputStream();
		// 将其包装为 PrintWriter 实例
		PrintWriter pw = new PrintWriter(os);
		// 向其中写入信息
		pw.write("用户名:admin;密码:123");
		// 刷新缓冲区
		pw.flush();
		// 关闭输出流
		socket.shutdownOutput();
		
		// 接受服务器数据
		InputStream is = socket.getInputStream();
		// 包装成 BufferedReader 实例
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		// 从中读取数据
		String data;
		while ((data = br.readLine()) != null) {
			System.out.println("客户端接收信息，服务器说：" + data);
		}
		// 关闭输入流
		socket.shutdownInput();
		
		// 关闭组件
		br.close();
		is.close();
		pw.close();
		os.close();
		socket.close();
	}
}
