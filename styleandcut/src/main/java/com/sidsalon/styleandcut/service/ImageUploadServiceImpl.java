package com.sidsalon.styleandcut.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sidsalon.styleandcut.dao.ImageDao;
import com.sidsalon.styleandcut.model.UploadImage;
@Service
public class ImageUploadServiceImpl implements ImageService {
@Autowired
private ImageDao imageDao;
	@Override
	public void saveImage(UploadImage uploadImage) {
		imageDao.saveImage(uploadImage);
	}

}
