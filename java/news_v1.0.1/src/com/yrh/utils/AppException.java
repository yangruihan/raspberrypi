package com.yrh.utils;

/**
 * 应用异常类
 * @author Yrh
 *
 */
@SuppressWarnings("serial")
public class AppException extends Exception {
	
	private int exceptionCode;		// 异常编号
	private String message;			// 异常信息
	
	public AppException(String message) {
		this.message = message;
	}
	
	public AppException(String message, int code) {
		this.exceptionCode = code;
		this.message = message;
	}
	
	public int getExceptionCode() {
		return exceptionCode;
	}
	
	public String getMessage() {
		return message;
	}
}
