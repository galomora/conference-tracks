package ec.gm.tracks.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ec.gm.tracks.input.TalkParser;
import ec.gm.tracks.model.Session;
import ec.gm.tracks.model.Talk;
import ec.gm.tracks.process.SessionFactory;

/**
 * {@link SessionFactory} tests
 * @author galo
 *
 */
public class TestSessionFactory {
	/**
	 * Test building morning session
	 * @throws Exception
	 */
	@Test
	public void testBuildMorningSession () throws Exception {
		SessionFactory factory = new SessionFactory();
		List<Talk> talks = new ArrayList<Talk> ();
		TalkParser parser = new TalkParser ();
		Talk talk = parser.parseTalk("Writing Fast Tests Against Enterprise Rails 60min");
		talks.add(talk);
		talk = parser.parseTalk("Overdoing it in Python 45min");
		talks.add(talk);
		talk = parser.parseTalk("Lua for the Masses 30min");
		talks.add(talk);
		talk = parser.parseTalk("Ruby Errors from Mismatched Gem Versions 45min");
		talks.add(talk);
		Session session = factory.buildMorningSession(talks);
		Assert.assertEquals(4, session.getTalks().size());
		for (Talk talk1 : session.getTalks()) {
			System.out.println(talk1.toString());
		}
		
	}
}
