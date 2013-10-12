package com.ostphoto.app.admin.photo;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.ostphoto.app.admin.photo.domains.Photo;


public class Resourse {
//extends WebMvcConfigurerAdapter
	
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

//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//	    registry.addResourceHandler("/photo/**").addResourceLocations("file:" + Paths.get(ROOT_DIR, PHOTO_DIR_NAME).toString());
//	}

	
	
	public static File getPhotoFile(String date, String name) throws IOException {
		return Paths.get(ROOT_DIR, PHOTO_DIR_NAME, ORIGINAL_DIR_NAME, date, name).toFile();
		
	}
	
	
	public static String saveFile(UploadPhotoForm photo) throws IOException {
		MultipartFile file = photo.getFile();
		Path dir = Resourse.getOriginalPhotoDirPaths(); 		
		if (!Files.isDirectory(dir)) {
			Files.createDirectories(dir);
		}	
		int dotIndx = file.getOriginalFilename().lastIndexOf('.');
		String fileType = null;
		if (dotIndx > 0) {
			fileType = file.getOriginalFilename().substring(dotIndx+1);
		}
		// TODO very expencive(memory leak) - should be refactore
		String fileNameString = new BigInteger(100, new SecureRandom()).toString(15).substring(0, 8) + "." + fileType;
		Path path = Files.createFile(dir.resolve(fileNameString));
		Files.write(path, file.getBytes());
		return fileNameString;
	}
//	public static List<String> convertPhotosToUrl(List<Photo> allPhoto) {
//		List<String> urlList = new ArrayList<String>();
//		for(Photo photo : allPhoto) {
//			urlList.add("/resources/photo/original/" + photo.getUpdate() + "/" + photo.getFileName());
//		}
//
//		return urlList;
//	}

}
