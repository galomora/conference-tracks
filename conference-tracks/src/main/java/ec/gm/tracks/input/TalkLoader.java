package ec.gm.tracks.input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ec.gm.tracks.model.Talk;
import ec.gm.tracks.util.Util;

/**
 * Manages the loading of talks from a text file
 * @author galo.mora
 *
 */
public class TalkLoader {
	
	/**
	 * Loads talk definitions from text file <br />
	 * text file should be named talks and be in same directory where <br />
	 * the executable jar is <br />
	 * Each definition is a line in the text file<br />
	 * definition example: <br />
	 * Writing Fast Tests Against Enterprise Rails 60min
	 * @return List of {@link Talk} instances containing the info obtained from text file
	 * @throws IOException
	 */
	public List<Talk> loadTalks () throws IOException {
		return readFile (loadFile ("talks"));
	}
	
	/**
	 * Loads talk definitions from text file given the file name,<br />
	 * text file should be in same directory where <br />
	 * the executable jar is <br />
	 * Each definition is a line in the text file<br />
	 * definition example: <br />
	 * Writing Fast Tests Against Enterprise Rails 60min
	 * @return List of {@link Talk} instances containing the info obtained from text file
	 * @throws IOException
	 */
	public List<Talk> loadTalks (String fileName) throws IOException {
		return readFile (loadFile (fileName));
	}

	/**
	 * Load file given filename
	 * @param fileName name
	 * @return File loaded
	 */
	private File loadFile (String fileName) {
		Util util = new Util ();
		return new File (util.obtainJarDirectory() + fileName);
	}
	
	/**
	 * Reads file and gets a list of {@link Talk}
	 * @param talksFile file to read
	 * @return list of {@link Talk}
	 * @throws IOException
	 */
	private List<Talk> readFile (File talksFile) throws IOException {
		FileReader reader = new FileReader(talksFile);
		BufferedReader bufferedReader = new BufferedReader(reader);
		List<Talk> talks = getTalksList(bufferedReader); 
		bufferedReader.close();
		reader.close();
		return talks;
	}
	
	/**
	 * Gets talks list from file using a {@link BufferedReader}
	 * @param bufferedReader from talks file, needs to be closed outside
	 * @return list of {@link Talk}
	 * @throws IOException
	 */
	private List<Talk> getTalksList (BufferedReader bufferedReader) throws IOException {
		List<Talk> talks = new ArrayList<Talk> ();
		TalkParser parser = new TalkParser ();
		String line;
		while ((line = bufferedReader.readLine()) != null)   {
			  talks.add(parser.parseTalk(line));
		}
		return talks;
	}
}
