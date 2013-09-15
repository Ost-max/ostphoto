package com.ostphoto.app.admin.photo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.ostphoto.app.Resourse;
import com.ostphoto.app.admin.IModule;


public class PhotoModule implements IModule {
	
   final static String SMALL_VIEW_NAME = "photoup";
   final static String VIEW_NAME = "photo";
	

	@Override
	public String getSmallViewName() {
		return  SMALL_VIEW_NAME;
	}

	@Override
	public Map<String, ?> getSmallAttributes() {
		Map<String, Object> attrs = new HashMap<String, Object>();
		attrs.put(VIEW_NAME + "UpForm", new UploadPhotoForm());
		return attrs;
	}



	
	static void writeToDB(String finalPath, UploadPhotoForm photo) {
		// TODO Auto-generated method stub
		
	}


	static String saveFile(UploadPhotoForm photo) throws IOException {
		MultipartFile file = photo.getFile();
		Path dir = Resourse.getOriginalPhotoDirPaths(); 		
		if (!Files.isDirectory(dir)) {
			Files.createDirectories(dir);
		}
		Path path = Files.createFile(dir.resolve(String.valueOf(file.getOriginalFilename())));
		Files.write(path, file.getBytes());
		return path.toString();
	}



}
