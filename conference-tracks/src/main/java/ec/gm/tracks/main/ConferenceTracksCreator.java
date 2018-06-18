package ec.gm.tracks.main;

import java.io.IOException;
import java.util.List;

import ec.gm.tracks.input.TalkLoader;
import ec.gm.tracks.model.Conference;
import ec.gm.tracks.model.Talk;
import ec.gm.tracks.process.ConferenceFactory;

/**
 * Executable class, main class of jar
 * 
 * @author galo.mora
 *
 */
public class ConferenceTracksCreator {

	/**
	 * Executable from command line Searches for a file with name "talks" or name
	 * specified <br />
	 * Parse file and print builded tracks
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		List<Talk> talks;
		try {
			talks = loadTalksFromFile (args);
		} catch (IOException e) {
			return;
		}
		ConferenceFactory factory = new ConferenceFactory();
		Conference conference = factory.buildConference(talks);
		conference.print();
	}

	/**
	 * Load talks from file
	 * @param args
	 * @return
	 * @throws IOException
	 */
	private static List<Talk> loadTalksFromFile(String[] args) throws IOException {
		List<Talk> talks;
		if (args.length == 0) {
			talks = loadDefaultFile();
		} else {
			talks = loadCustomFile(args[0]);
		}
		return talks;
	}

	/**
	 * Load file with default name talks
	 * 
	 * @return
	 * @throws IOException
	 */
	private static List<Talk> loadDefaultFile() throws IOException {
		TalkLoader loader = new TalkLoader();
		try {
			return loader.loadTalks();
		} catch (IOException e) {
			System.out.println("Cannot find talks file, place a file named talks in the current directory");
			System.out.println("The file must contain the talks definitions as defined in Problem Two spec");
			throw e;
		}
	}

	/**
	 * Load file with custom file name
	 * 
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	private static List<Talk> loadCustomFile(String fileName) throws IOException {
		TalkLoader loader = new TalkLoader();
		try {
			return loader.loadTalks(fileName);
		} catch (IOException e) {
			System.out.println("Cannot find talks file with name " + fileName
					+ ", place a text file with the name specified in the current directory");
			System.out.println("The file must contain the talks definitions as defined in Problem Two spec");
			throw e;
		}
	}
}
