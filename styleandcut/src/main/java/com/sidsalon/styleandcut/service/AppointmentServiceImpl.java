package com.sidsalon.styleandcut.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sidsalon.styleandcut.dao.AppointmentDao;
import com.sidsalon.styleandcut.model.Appointment;

@Service
public class AppointmentServiceImpl implements AppointmentService{
	@Autowired
	private AppointmentDao appointmentDao;

	@Override
	public Appointment createAppointment(Appointment appointment) {
		
		return appointmentDao.createAppointment(appointment);
	}

	@Override
	public List<Appointment> findAllAppointment() {
		
		return appointmentDao.findAllAppointment();
	}

	@Override
	public Appointment findAppointment(Long id) {
		// TODO Auto-generated method stub
		return appointmentDao.findAppointment(id);
	}

	@Override
	public void confirmAppointment(Long id) {
		appointmentDao.confirmAppointment(id);
		
	}
	
}
