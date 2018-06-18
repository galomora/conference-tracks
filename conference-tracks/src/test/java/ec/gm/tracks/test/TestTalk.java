package ec.gm.tracks.test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

import ec.gm.tracks.model.Talk;

public class TestTalk {
	@Test 
	public void testTalkFormatting () throws Exception {
		Talk talk = new Talk();
		talk.setTitle("Overdoing it in Python");
		talk.setMinutes(45);
		Calendar calendar = new GregorianCalendar();
		calendar.clear(Calendar.HOUR);
		calendar.clear(Calendar.MINUTE);
		calendar.clear(Calendar.SECOND);
		calendar.set(Calendar.HOUR, 9);
		calendar.set(Calendar.MINUTE, 30);
		calendar.set(Calendar.AM_PM, Calendar.AM);
		talk.setStartTime(calendar.getTime());
		Assert.assertEquals("09:30 AM Overdoing it in Python 45min", talk.toString());
	}
}
