package ec.gm.tracks.util;

public class Util {

	/**
     * Get jar directory
     * @return 
     */
    public String obtainJarDirectory () {
        String directoryWithJar = getClass().getProtectionDomain().getCodeSource().getLocation().toString().substring(6);
        return directoryWithJar.substring(0, directoryWithJar.lastIndexOf("/") + 1);
    }
}
