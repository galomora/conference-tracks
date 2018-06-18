package ec.gm.tracks.input;

import ec.gm.tracks.model.Talk;

/**
 * Manages the parsing of talk definitions
 * @author galo.mora
 *
 */
public class TalkParser {
	
	private static final String LIGHTNING = "lightning";
	private static final Integer LIGHTNING_VALUE = Integer.valueOf(5);
	
	/**
	 * Parse a {@link Talk} from text definition
	 * @param trackDescription talk description, example: <br />
	 * Writing Fast Tests Against Enterprise Rails 60min
	 * @return Talk containing info obtained from parse
	 */
	public Talk parseTalk (String trackDescription) {
		int index = trackDescription.lastIndexOf(" ");
		String title = trackDescription.substring(0, index);
		String timeString = trackDescription.substring(index + 1);
		int time = 0;
		if (LIGHTNING.equalsIgnoreCase(timeString)) {
			time = LIGHTNING_VALUE;
		} else  {
			time = Integer.parseInt(timeString.substring(0, timeString.lastIndexOf("min")));
		}
		return createTalk(title, time);
	}
	
	/**
	 * Creates an instance of {@link Talk} 
	 * @param title
	 * @param time
	 * @return
	 */
	private Talk createTalk (String title, int time) {
		Talk talk = new Talk ();
		talk.setTitle(title);
		talk.setMinutes(time);
		return talk;
	}
	
}
