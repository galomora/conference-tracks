package ec.gm.tracks.process;

import java.util.List;

import ec.gm.tracks.model.Conference;
import ec.gm.tracks.model.Talk;
/**
 * Manages the building of conferences
 * @author galo
 *
 */
public class ConferenceFactory {
	/**
	 * Builds a conference that contains tracks receiving a list of talks 
	 * @param talks
	 * @return
	 */
	public Conference buildConference (List<Talk> talks) {
		Conference conference = new Conference();
		TracksFactory factory = new TracksFactory();
		conference.setTracks(factory.buildTrackList(talks));
		return conference;
	}
}
