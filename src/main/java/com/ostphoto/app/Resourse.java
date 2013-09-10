package com.ostphoto.app;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Resourse {
	
	public final static String ROOT_DIR = System.getProperty("user.dir");
	public final static String PHOTO_DIR_NAME = "photo";
	public final static String ORIGINAL_DIR_NAME = "original";
	private static final String RESIZED = "resized";
    
	// dir where curently download photo stored
	public static Path getOriginalPhotoDirPaths() {
		return Paths.get(ROOT_DIR + File.separator + PHOTO_DIR_NAME + File.separator + ORIGINAL_DIR_NAME);
	}
	
	// dir where resize photo stored
	public static Path getResizedPhotoDirPaths() {
		return Paths.get(ROOT_DIR + File.separator + PHOTO_DIR_NAME + File.separator + RESIZED);
	}
	
	

}
