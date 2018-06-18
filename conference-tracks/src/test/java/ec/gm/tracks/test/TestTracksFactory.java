package ec.gm.tracks.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ec.gm.tracks.input.TalkParser;
import ec.gm.tracks.model.Talk;
import ec.gm.tracks.model.Track;
import ec.gm.tracks.process.TracksFactory;

public class TestTracksFactory {
	@Test 
	public void testBuildTrackList () throws Exception {
		List<Talk> talks = new ArrayList<Talk> ();
		TracksFactory factory = new TracksFactory ();
		TalkParser parser = new TalkParser ();
		Talk talk = parser.parseTalk("Writing Fast Tests Against Enterprise Rails 60min");
		talks.add(talk);
		talk = parser.parseTalk("Overdoing it in Python 45min");
		talks.add(talk);
		List<Track> tracks = factory.buildTrackList(talks);
		//cannot build tracks, not enough talks
		Assert.assertEquals(0, tracks.size());
		talk = parser.parseTalk("Lua for the Masses 30min");
		talks.add(talk);
		talk = parser.parseTalk("Ruby Errors from Mismatched Gem Versions 45min");
		talks.add(talk);
		talk = parser.parseTalk("Common Ruby Errors 45min");
		talks.add(talk);
		talk = parser.parseTalk("Rails for Python Developers lightning");
		talks.add(talk);
		talk = parser.parseTalk("Communicating Over Distance 60min");
		talks.add(talk);
		talk = parser.parseTalk("Accounting-Driven Development 45min");
		talks.add(talk);
		talk = parser.parseTalk("Woah 30min");
		talks.add(talk);
		talk = parser.parseTalk("Sit Down and Write 30min");
		talks.add(talk);
		tracks = factory.buildTrackList(talks);
		//can build one track
		Assert.assertEquals(1, tracks.size());
		System.out.println(tracks.get(0).toString());
	}
}
