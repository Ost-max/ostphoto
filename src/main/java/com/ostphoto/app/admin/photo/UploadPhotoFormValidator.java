package com.ostphoto.app.admin.photo;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UploadPhotoFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return UploadPhotoForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		 UploadPhotoForm form = (UploadPhotoForm)target;
		 if(form.getFile().isEmpty()) {
		    errors.rejectValue("file", "file.empty", "File field is empty. Please fill this field.");
		 }
	}

}
