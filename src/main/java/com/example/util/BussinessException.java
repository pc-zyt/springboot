package com.example.util;

public class BussinessException extends RuntimeException{

	private static final long serialVersionUID = 1L;
    public static final String DISPLAY = "display";
    public static final String UNDISPLAY = "undisplay";

	/** 异常发生时的code */
	private String errorCode;

	/**
	 * 获取异常code
	 * 
	 * @return errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * 业务异常构造函数
	 * 
	 * @param message
	 *            异常信息
	 * @param errorCode
	 *            异常code
	 * @param errorType
	 *            异常类型
	 */
	public BussinessException(String message, String errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	/**
	 * 业务异常构造函数
	 * 
	 * @param message
	 *            异常信息
	 * @param errorCode
	 *            异常code
	 * @param errorType
	 *            异常类型
	 */
	public BussinessException(String message) {
		super(message);
	}

	/**
	 * 业务异常构造函数
	 * 
	 * @param message
	 *            异常信息
	 * @param cause
	 *            异常对象
	 */
	public BussinessException(String message, Throwable cause) {
		super(message, cause);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
