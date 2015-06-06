package com.yrh.java.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class URLTest {

	public static void main(String[] args) throws MalformedURLException {
		// 获取 URL 实例
		URL url = new URL("http://www.baidu.com");
		try {
			// 通过 openStream 方法，获取 URL 实例所表示的字节输入流
			InputStream is = url.openStream();
			// 获得字符流数据
			InputStreamReader isr = new InputStreamReader(is);
			// 缓冲
			BufferedReader br = new BufferedReader(isr);
			// 遍历并输出
			String data;
			while ((data = br.readLine()) != null) {
				System.out.println(data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
