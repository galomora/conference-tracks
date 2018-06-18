package ec.gm.tracks.model;

import java.util.List;
/**
 * Represents a conference that have tracks
 * @author galo
 *
 */
public class Conference {
	private List<Track> tracks;

	public List<Track> getTracks() {
		return tracks;
	}

	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}
	
	public void print () {
		for (Track track: tracks) {
			System.out.println(track.toString());
		}
	}
	
	public String toString () {
		String s = "";
		for (Track track: tracks) {
			s += track.toString() + "\n";
		}
		return s;
	}
	
}
