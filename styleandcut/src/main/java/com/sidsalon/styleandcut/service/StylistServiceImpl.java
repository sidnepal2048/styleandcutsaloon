package com.sidsalon.styleandcut.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sidsalon.styleandcut.dao.StylistDao;
import com.sidsalon.styleandcut.model.Stylist;
@Service
public class StylistServiceImpl implements StylistService{
@Autowired
private StylistDao stylistDao;
	@Override
	public List<Stylist> getAllStylist() {
		
		return stylistDao.getAllStylist();
	}

	@Override
	public Stylist getStylistById(int stylistId) {
		
		return stylistDao.getStylistById(stylistId);
	}

	@Override
	public void addStylist(Stylist stylist) {
		stylistDao.addStylist(stylist);

	}

}
