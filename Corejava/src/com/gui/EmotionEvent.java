package com.gui;
//时间对象
public class EmotionEvent {
	private Girl source;//事件源
	private String message;//事件描述信息
	public Girl getSource() {
		return source;
	}
	
	public EmotionEvent(Girl source, String message) {
	
		this.source = source;
		this.message = message;
	}

	
	public void setSource(Girl source) {
		this.source = source;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
