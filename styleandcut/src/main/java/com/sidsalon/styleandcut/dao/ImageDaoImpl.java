package com.sidsalon.styleandcut.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sidsalon.styleandcut.model.UploadImage;
@Repository
public class ImageDaoImpl implements ImageDao {
@Autowired
private SessionFactory sessionFactory;
	@Override
	@Transactional
	public void saveImage(UploadImage uploadImage) {
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(uploadImage);
		session.flush();		
	}

}
