package com.briup.exception;
//自定义异常
public class TeacherException extends Exception{

	public TeacherException() {
		super();
	}

	public TeacherException(String message, Throwable cause) {
		super(message, cause);
	}

	public TeacherException(String message) {
		super(message);
	}

	public TeacherException(Throwable cause) {
		super(cause);
	}
}
