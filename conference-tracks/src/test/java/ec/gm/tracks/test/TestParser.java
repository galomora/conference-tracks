package ec.gm.tracks.test;

import org.junit.Assert;
import org.junit.Test;

import ec.gm.tracks.input.TalkParser;
import ec.gm.tracks.model.Talk;

/**
 * {@link TalkParser} Tests
 * @author galo
 *
 */
public class TestParser {

	private static final Integer LIGHTNING_VALUE = Integer.valueOf(5);
	
	/**
	 * Test common track
	 */
	@Test
	public void parseTrackTest () {
		TalkParser parser = new TalkParser ();
		Talk talk = parser.parseTalk("Overdoing it in Python 45min");
		Assert.assertEquals("Overdoing it in Python", talk.getTitle());
		Assert.assertEquals(45, talk.getMinutes());
	}
	
	/**
	 * Test lightning track
	 */
	@Test
	public void parseLightningTest () {
		TalkParser parser = new TalkParser ();
		Talk talk = parser.parseTalk("Rails for Python Developers lightning");
		Assert.assertEquals("Rails for Python Developers", talk.getTitle());
		Assert.assertEquals(LIGHTNING_VALUE.intValue(), talk.getMinutes());
	}

}
