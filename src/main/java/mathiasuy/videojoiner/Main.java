package mathiasuy.videojoiner;

import java.io.Console;
import java.io.File;
import java.io.IOException;

public class Main {
    private static String outputName = "output";
	private static String mkvmerge = "mkvmerge.exe";

	public static void main(String[] args) throws IOException {
    	File directory = new File("");
    	
    	String path = directory.getAbsolutePath();
    	
    	File output = new File( path + "\\output.mp4");
    	
    	if (output.exists()) {
    		output.delete();
    	}
    	
    	directory = new File(path);
    	
    	File[] files = directory.listFiles();

    	
    	String videos = " -o " + outputName + ".mp4 ";
    	
    	for (int i = 0; i < files.length; i++) {
    		if (files[i].getName().endsWith(".mp4")) {
    			videos += " " + files[i].getAbsolutePath() + " + ";
    		}
		}
    	videos = videos.substring(0, videos.lastIndexOf("+") - 1);

        Runtime rt = Runtime.getRuntime();
        rt.exec(path + "\\resources\\mkvmerge.exe" + videos);
    	System.out.println(videos);
    	
    	
    	
    }
}
