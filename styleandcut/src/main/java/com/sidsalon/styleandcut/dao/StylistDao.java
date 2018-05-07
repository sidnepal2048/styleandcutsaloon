package com.sidsalon.styleandcut.dao;

import java.util.List;

import com.sidsalon.styleandcut.model.Stylist;

public interface StylistDao {
	List<Stylist> getAllStylist(); //list of stylist
	Stylist getStylistById(int stylistId);//get stylist by stylistId
	void addStylist(Stylist stylist);
}
