package com.gui;
//ʱ�����
public class EmotionEvent {
	private Girl source;//�¼�Դ
	private String message;//�¼�������Ϣ
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
