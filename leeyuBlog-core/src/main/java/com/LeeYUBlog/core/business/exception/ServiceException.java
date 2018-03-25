package com.LeeYUBlog.core.business.exception;

public class ServiceException extends Exception {

	private static final long serialVersionUID = 8285381305025666854L;
	private int exceptionType = 0;//regular error
	
	private String messageCode = null;
	
	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}

	public ServiceException() {
		super();
	}
	
	public ServiceException(String messageCode) {
		super();
		this.messageCode = messageCode;
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}
	
	public ServiceException(int exceptionType) {
		super();
		this.exceptionType = exceptionType;
	}
	
	public ServiceException(int exceptionType, String message) {
		super(message);
		this.exceptionType = exceptionType;
	}
	
	public ServiceException(int exceptionType, String message, String messageCode) {
		super(message);
		this.messageCode = messageCode;
		this.exceptionType = exceptionType;
	}
	
	public int getExceptionType() {
		return exceptionType;
	}
	
	public void setExceptionType(int exceptionType) {
		this.exceptionType = exceptionType;
	}
	
	public String getMessageCode() {
		return messageCode;
	}

}
