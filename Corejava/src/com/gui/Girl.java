package com.gui;

import java.util.*;


public class Girl {
	private String name;
	
	//维护监听着
	private Set<EmotionListener>boys;

	public Girl(String name) {
		this.name=name;
		boys=new HashSet<>();
	}
	//添加事件监听器
	public void addEmotionListener(EmotionListener boy) {
		boys.add(boy);
	}
	//删除事件监听器
	public void DelEmotionListener(EmotionListener boy) {
		boys.remove(boy);
	}
	//产生事件
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
