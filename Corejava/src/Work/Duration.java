package Work;

public class Duration {
	private int hours;
	private int minutes;
	private int seconds;
	public Duration(int hours, int minutes, int seconds) {
		super();
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
	}
	public Duration(int totalSeconds) {
		this.hours=totalSeconds/3600;
		int r=totalSeconds-hours*3600;
		this.minutes=r/60;
	this.seconds=r%60;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public int getMinutes() {
		return minutes;
	}
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	public int getSeconds() {
		return seconds;
	}
	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}
	
	public int getTotalSeconds() {
		return seconds+(60*(minutes+(hours*60)));
	}
	
	public String toString() {
		return hours+" "+minutes+" "+seconds;
	}
}
