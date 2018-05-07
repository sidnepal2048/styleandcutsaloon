package com.sidsalon.styleandcut.dao;

import java.util.List;

import com.sidsalon.styleandcut.model.Email;

public interface EmailDao {
	List<Email> findAllEmail();
}
