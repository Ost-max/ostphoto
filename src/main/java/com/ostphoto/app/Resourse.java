package com.ostphoto.app;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;


public class Resourse {
	
	public final static String ROOT_DIR = System.getProperty("user.dir");
	public final static String PHOTO_DIR_NAME = "photo";
	public final static String ORIGINAL_DIR_NAME = "original";
	//TODO check when class init and how long does it exists 
	public final static String DATE_DIR =  new Date(System.currentTimeMillis()).toString();
	private static final String RESIZED = "resized";
	

    
	// dir where curently download photo stored
	public static Path getOriginalPhotoDirPaths() {
		return Paths.get(ROOT_DIR, PHOTO_DIR_NAME, ORIGINAL_DIR_NAME, DATE_DIR);
	}
	
	// dir where resize photo stored
	public static Path getResizedPhotoDirPaths() {
		return Paths.get(ROOT_DIR, PHOTO_DIR_NAME, RESIZED, DATE_DIR);
	}

	

}
