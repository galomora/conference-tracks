package ec.gm.tracks.model;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Represents a track, that have a morning session and an afternoon session
 * @author galo.mora
 *
 */
public class Track {
	private Session morningSession;
	private Session afternoonSession;
	private Integer number;
	public Track() {
		morningSession = new Session(Session.MORNING);
		afternoonSession = new Session(Session.AFTERNOON);
	}
	public Session getMorningSession() {
		return morningSession;
	}
	public void setMorningSession(Session morningSession) {
		this.morningSession = morningSession;
	}
	public Session getAfternoonSession() {
		return afternoonSession;
	}
	public void setAfternoonSession(Session afternoonSession) {
		this.afternoonSession = afternoonSession;
	}
	/**
	 * Talk representing Lunch at 12:00 PM
	 * @return
	 */
	private Talk createLunchTalk () {
		Talk talk = new Talk ();
		talk.setTitle("Lunch");
		Calendar cal = new GregorianCalendar();
		cal.clear(Calendar.HOUR);
		cal.clear(Calendar.MINUTE);
		cal.clear(Calendar.SECOND);
		cal.set(Calendar.HOUR, 12);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.AM_PM, Calendar.PM);
		talk.setStartTime(cal.getTime());
		return talk;
	}
	
	/**
	 * Talk representing Networking event <br />
	 * Starts when the last talk of the afternoon session ends
	 * 
	 * @return
	 */
	private Talk createNetworkingTalk () {
		Talk talk = new Talk ();
		talk.setTitle("Networking Event");
		Talk last = this.afternoonSession.getTalks().get(afternoonSession.getTalks().size() - 1);
		Calendar lastTime = new GregorianCalendar();
		lastTime.setTime(last.getStartTime());
		lastTime.add(Calendar.MINUTE, last.getMinutes());
		talk.setStartTime(lastTime.getTime());
		return talk;
	}
	
	/**
	 * String representation of Track
	 */
	public String toString () {
		String s = "Track No. ";
		s += (String.valueOf(number) + ":\n");
		
		for (Talk talk : morningSession.getTalks()) {
			s+= (talk.toString() + "\n");
		}
		s += createLunchTalk ().toString() + "\n";
		for (Talk talk : afternoonSession.getTalks()) {
			s+= (talk.toString() + "\n");
		}
		s += createNetworkingTalk ().toString() + "\n";
		return s;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}

	
}
