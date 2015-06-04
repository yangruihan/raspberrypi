package com.yrh.java.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {

	public static void main(String[] args) throws UnknownHostException {
		InetAddress address = InetAddress.getLocalHost();
		System.out.println("主机名：" + address.getHostName());
		System.out.println("主机地址：" + address.getHostAddress());
		System.out.println("地址：" + address.getAddress());
		System.out.println(address);
	}

}
