package com.briup.enums;

public enum TrafficLight {
	Red(60) {
		public TrafficLight next() {
			return Green;
		}
	},Yellow(3) {
		public TrafficLight next() {
			return Red;
		}
	},Green(60) {
		public TrafficLight next() {
			return Yellow;
		}
	};
	int time;
	 TrafficLight(int time){
		this.time=time;
	}
	 public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public abstract TrafficLight next();
}
	
