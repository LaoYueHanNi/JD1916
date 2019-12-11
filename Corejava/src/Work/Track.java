package Work;

public class Track {
	private String title;
	private String duration;
	
	
	public Track(String title, String duration) {
		super();
		this.title = title;
		this.duration = duration;
	}
	public String getTitle() {
		return title;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	
}
