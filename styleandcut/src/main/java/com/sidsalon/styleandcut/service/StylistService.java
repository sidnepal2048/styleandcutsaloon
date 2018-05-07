package com.sidsalon.styleandcut.service;

import java.util.List;

import com.sidsalon.styleandcut.model.Stylist;

public interface StylistService {
	List<Stylist> getAllStylist(); //list of stylist
	Stylist getStylistById(int stylistId);//get stylist by stylistId
	void addStylist(Stylist stylist);
}
