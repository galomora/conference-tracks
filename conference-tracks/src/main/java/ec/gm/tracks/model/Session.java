package ec.gm.tracks.model;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
/**
 * Represents a session that contains  talks, can be<br /> 
 * morning or afternoon session
 * @author galo.mora
 *
 */
public class Session {
	public static final Integer MORNING_SESSION_DURATION = Integer.valueOf(180);
	public static final Integer AFTERNOON_SESSION_MINIMUM_DURATION = Integer.valueOf(180);
	public static final Integer AFTERNOON_SESSION_MAXIMUM_DURATION = Integer.valueOf(240);
	public static final String MORNING = "morning";
	public static final String AFTERNOON = "afternoon";
	

	private List<Talk> talks;
	private String type;
	
	public Session(String type) {
		this.type = type;
		
	}
	public List<Talk> getTalks() {
		return talks;
	}
	public void setTalks(List<Talk> talks) {
		this.talks = talks;
	}
	
	public Boolean getIsMorning () {
		if (MORNING.equals(type)) {
			return true;
		}
		return false;
	}
	
	public Boolean getIsAfternoon () {
		if (AFTERNOON.equals(type)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Morning sessions start at 09:00 AM
	 * @return
	 */
	public static Calendar getMorningStart () {
		Calendar cal = new GregorianCalendar();
		cal.clear(Calendar.HOUR);
		cal.clear(Calendar.MINUTE);
		cal.clear(Calendar.SECOND);
		cal.set(Calendar.HOUR, 9);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.AM_PM, Calendar.AM);
		return cal;
	}
	
	/**
	 * Afternoon sessions start at 01:00 PM
	 * @return
	 */
	public static Calendar getAfternoonStart () {
		Calendar cal = new GregorianCalendar();
		cal.clear(Calendar.HOUR);
		cal.clear(Calendar.MINUTE);
		cal.clear(Calendar.SECOND);
		cal.set(Calendar.HOUR, 1);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.AM_PM, Calendar.PM);
		return cal;
	}
}
