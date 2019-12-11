package com.gui;

import java.util.*;


public class Girl {
	private String name;
	
	//ά��������
	private Set<EmotionListener>boys;

	public Girl(String name) {
		this.name=name;
		boys=new HashSet<>();
	}
	//����¼�������
	public void addEmotionListener(EmotionListener boy) {
		boys.add(boy);
	}
	//ɾ���¼�������
	public void DelEmotionListener(EmotionListener boy) {
		boys.remove(boy);
	}
	//�����¼�
	public void cry() {
		EmotionEvent event=new EmotionEvent(this,"ku");
		for(EmotionListener boy:boys) {
			boy.sad(event);
		}
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
