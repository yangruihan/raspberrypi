package com.yrh.utils;

/**
 * Ӧ���쳣��
 * @author Yrh
 *
 */
@SuppressWarnings("serial")
public class AppException extends Exception {
	
	private int exceptionCode;		// �쳣���
	private String message;			// �쳣��Ϣ
	
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
