package com.gui;

public class Boy {
	public static void main(String[] args) {
		Girl g1=new Girl("lucy");
		g1.addEmotionListener(new EmotionListener() {

			public void sad(EmotionEvent event) {
				Girl girl=event.getSource();
				System.out.println(girl.getName());
			}

			public void happy(EmotionEvent event) {
				
			}
			
		});
		g1.cry();
	}
}
