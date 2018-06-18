package ec.gm.tracks.process;

import java.util.ArrayList;
import java.util.List;

import ec.gm.tracks.model.Session;
import ec.gm.tracks.model.Talk;
import ec.gm.tracks.model.Track;

/**
 * Manages the building of tracks
 * @author galo.mora
 *
 */
public class TracksFactory {

	private SessionFactory sessionFactory;
	private List<Talk> currentTalks;
	
	public TracksFactory() {
		sessionFactory = new SessionFactory ();
	}
	
	/**
	 * Creates a list of tracks that compose a conference
	 * @param talks
	 * @return
	 */
	public List<Track> buildTrackList (List<Talk> talks) {
		List<Track> tracks = new ArrayList<>();
		currentTalks = removeAlreadyUsedTalks (talks, new ArrayList <Integer> ());
		int trackNumber = 1;
		while (moreTracks(currentTalks)) {
			Track track;
			track = createTrack(currentTalks);
			track.setNumber(trackNumber);
			tracks.add(track);
			trackNumber ++;
		}
		return tracks;
	}
	
	/**
	 * Creates a track with a morning and an afternoon sessions
	 * @param talks
	 * @return
	 */
	private Track createTrack (List<Talk> talks) {
		Session morningSession = sessionFactory.buildMorningSession(talks);
		currentTalks = removeAlreadyUsedTalks (talks, sessionFactory.getSelectedIndexes());
		Session afternoonSession = sessionFactory.buildAfternoonSession(currentTalks);
		currentTalks = removeAlreadyUsedTalks (currentTalks, sessionFactory.getSelectedIndexes());
		Track track = new Track();
		track.setMorningSession(morningSession);
		track.setAfternoonSession(afternoonSession);
		return track;
	}
	
	/**
	 * Creates a new Talk list
	 * @param talksOrigin
	 * @param selectedIndexes
	 * @return
	 */
	private List<Talk> removeAlreadyUsedTalks (List<Talk> talksOrigin, List<Integer> selectedIndexes) {
		List<Talk> newList = new ArrayList<>();
		int i = 0;
		for (Talk talk : talksOrigin) {
			if (!selectedIndexes.contains(Integer.valueOf(i))) {
				newList.add(talk);
			}
			i++;
		}
		return newList;
	}
	/**
	 * Determines if there are enough talks to build a track
	 * @param talks
	 * @return tru if there are enough talks
	 */
	private boolean moreTracks (List<Talk> talks) {
		int minimumTime = Session.MORNING_SESSION_DURATION + Session.AFTERNOON_SESSION_MINIMUM_DURATION;
		int total = 0;
		for (Talk talk : talks) {
			total += talk.getMinutes();
		}
		return total >= minimumTime;
	}

	
}
