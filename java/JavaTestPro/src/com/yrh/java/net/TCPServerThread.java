package com.yrh.java.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 服务器线程 用来模拟多线程登录
 * 
 * @author Yrh
 *
 */
public class TCPServerThread extends Thread {

	Socket socket = null;

	/*
	 * 带有一个 Socket 参数的构造函数
	 */
	public TCPServerThread(Socket socket) {
		this.socket = socket;
	}

	/*
	 * 覆写 run 方法
	 */
	@Override
	public void run() {
		super.run();
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		OutputStream os = null;
		PrintWriter pw = null;
		
		try {
			// 通过 Socket 的 getInputStream 方法取得一个输入流对象
			is = socket.getInputStream();
			// 将字节输入流转换成字符输入流
			isr = new InputStreamReader(is);
			// 缓冲读入
			br = new BufferedReader(isr);
			// 开始读取数据
			String data;
			while ((data = br.readLine()) != null) {
				System.out.println("服务器读取数据，客户端说：" + data);
			}
			// 关闭输入流
			socket.shutdownInput();
			
			// 向客户端发送信息，获得 OutputStream 实例
			os = socket.getOutputStream();
			// 包装成 PrintWriter 实例
			pw = new PrintWriter(os);
			// 写数据
			pw.write("欢迎您");
			// 刷新缓冲区
			pw.flush();
			// 关闭输出流
			socket.shutdownOutput();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			try {
				if (pw != null)
					pw.close();
				if (os != null)
					os.close();
				if (br != null)
					br.close();
				if (isr != null)
					isr.close();
				if (is != null)
					is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
