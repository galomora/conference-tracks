package ec.gm.tracks.test;

import org.junit.Assert;
import org.junit.Test;

import ec.gm.tracks.input.TalkParser;
import ec.gm.tracks.model.Talk;


public class TestParser {

	private static final String LIGHTNING = "lightning";
	private static final Integer LIGHTNING_VALUE = Integer.valueOf(5);
	
	@Test
	public void parseTrackTest () {
		TalkParser parser = new TalkParser ();
		Talk talk = parser.parseTalk("Overdoing it in Python 45min");
		Assert.assertEquals("Overdoing it in Python", talk.getTitle());
		Assert.assertEquals(45, talk.getMinutes());
	}

}
