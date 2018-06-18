package ec.gm.tracks.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Represents a talk of the conference
 * @author galo.mora
 *
 */
public class Talk {
	public static final Integer LIGHTNING = Integer.valueOf(5);
	private String title;
	private int minutes;
	private Date startTime;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getMinutes() {
		return minutes;
	}
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	/**
	 * Obtain the starting hour of the talk in the format hh:mm AM/PM
	 * @return
	 */
	public String getFormatedStartTime() {
		SimpleDateFormat format = new SimpleDateFormat("hh:mm a");
		return format.format(startTime);
	}
	
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
	/**
	 * A String representation of the talk in the format: <br />
	 * START_TIME TALK_TITLE DURATION
	 */
	public String toString () {
		String s = "";
		if (startTime != null) {
			s += getFormatedStartTime();
		}
		s += " " + title;
		if (minutes != 0) {
			if (minutes != 5) {
				s += (" " + minutes + "min");
			} else {
				s += (" lightning" );
			}
		}
		return s;
	}
	
	
	

	
}
