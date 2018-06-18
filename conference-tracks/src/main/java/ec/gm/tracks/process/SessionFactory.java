package ec.gm.tracks.process;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import ec.gm.tracks.model.Session;
import ec.gm.tracks.model.Talk;

/**
 * Manages the building of Sessions
 * @author galo.mora
 *
 */
public class SessionFactory {
	private int total = 0;
	private List<Integer> selectedIndexes;
	
	/**
	 * Builds a morning session taking a list of talks as input
	 * @param talks
	 * @return A morning session starting at 09:00 ending at 12:00, time for lunch
	 */
	public Session buildMorningSession (List<Talk> talks) {
		//Talk [] talkArray = talks.toArray(new Talk [talks.size()]);
		restart ();
		Session morningSession = new Session (Session.MORNING);
		morningSession.setTalks(new ArrayList<Talk> ());
		buildSession (0, obtainTimesFromTalks (talks), Session.MORNING_SESSION_DURATION);
		if (selectedIndexes.isEmpty()) {
			System.out.println("Cannot build the morning session");
			return morningSession;
		}
		for (Integer index : selectedIndexes ) {
			morningSession.getTalks().add(talks.get(index.intValue()));
		}
		configureTimes (morningSession);
		return morningSession;
	}
	
	/**
	 * Builds an afternoon session taking a list of talks as input
	 * @param talks
	 * @return An afternoon session starting at 01:00 PM ending <br />
	 * between 04:00 PM and 05:00 PM, when networking event starts
	 */
	public Session buildAfternoonSession (List<Talk> talks) {
		//Talk [] talkArray = talks.toArray(new Talk [talks.size()]);
		restart ();
		Session afternoonSession = new Session (Session.AFTERNOON);
		afternoonSession.setTalks(new ArrayList<Talk> ());
		boolean success = buildSession (0, obtainTimesFromTalks (talks), Session.AFTERNOON_SESSION_MAXIMUM_DURATION);
		if (! success) {
			restart ();
			buildSession (0, obtainTimesFromTalks (talks), Session.AFTERNOON_SESSION_MINIMUM_DURATION, Session.AFTERNOON_SESSION_MAXIMUM_DURATION);
		}
		for (Integer index : selectedIndexes ) {
			afternoonSession.getTalks().add(talks.get(index.intValue()));
		}
		configureTimes (afternoonSession);
		return afternoonSession;
	}
	
	/**
	 * Sets starting time in every talk contained in a session
	 * @param session
	 */
	private void configureTimes (Session session) {
		Calendar time = null;
		if (session.getIsMorning()) {
			time = Session.getMorningStart();
		} else if (session.getIsAfternoon()) {
			time = Session.getAfternoonStart();
		}
		for (Talk talk : session.getTalks()) {
			talk.setStartTime(time.getTime());
			time.add(Calendar.MINUTE, talk.getMinutes());
		}
	}
	
	/**
	 * Required restarting elements when a session building is starting
	 */
	private void restart () {
		total = 0;
		selectedIndexes = new ArrayList <Integer> ();
	}
	
	/**
	 * Get the minutes from talks
	 * @param talks
	 * @return array containing the minutes of duration of every talk
	 */
	private int [] obtainTimesFromTalks (List<Talk> talks) {
		int [] array = new int [talks.size()] ;
		int i = 0;
		for (Talk talk : talks) {
			array [i] =  talk.getMinutes();
			i++;
		}
		return array;
	}
	
	/**
	 * Uses backtracking to build a session, ie, a list of talks that fill the required time
	 * @param position starting position in array, required for recursivity
	 * @param input array containing the length in minutes of every talk, in the same order as the talk list
	 * @param target time required to fill
	 * @return true when a solution is found
	 */
	private boolean buildSession (int position, int[] input, int target) {
		total += input[position];
		selectedIndexes.add(Integer.valueOf(position));
        if (total == target) {
            //success
            return true;
        }
        /*
        if (posicionReal == entrada.length - 1) {
            return false;
        }
        */
        if (total < target && (position < input.length - 1)) {
            if (buildSession (position+1, input, target)) {
                return true;
            }
        }
        total -= input[position];
        selectedIndexes.remove(Integer.valueOf(position));
        if (position == input.length - 1) {
            return false;
        } else {
        	if (buildSession (position+1, input, target)) {
                return true;
            }
        }
        return false;
    }
	
	/**
	 * Uses backtracking to build a session, ie, a list of talks that fill the required time
	 * @param position starting position in array, required for recursivity
	 * @param input array containing the length in minutes of every talk, in the same order as the talk list
	 * @param targetInit minimum time to be a valid solution
	 * @param targetEnd maximum time to be a valid solution
	 * @return true when a solution is found
	 */
	private boolean buildSession (int position, int[] input, int targetInit, int targetEnd) {
		total += input[position];
		selectedIndexes.add(Integer.valueOf(position));
        if (total <= targetEnd & total >= targetInit) {
        	//success
            return true;
        }
        /*
        if (posicionReal == entrada.length - 1) {
            return false;
        }
        */
        if (total < targetEnd && (position < input.length - 1)) {
            if (buildSession (position+1, input, targetInit, targetEnd)) {
                return true;
            }
        }
        total -= input[position];
        selectedIndexes.remove(Integer.valueOf(position));
        if (position == input.length - 1) {
            return false;
        } else {
        	if (buildSession (position+1, input, targetInit, targetEnd)) {
                return true;
            }
        }
        return false;
    }

	public List<Integer> getSelectedIndexes() {
		return selectedIndexes;
	}
	
	
}
