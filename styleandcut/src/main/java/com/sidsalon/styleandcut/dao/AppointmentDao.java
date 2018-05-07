package com.sidsalon.styleandcut.dao;

import java.util.List;

import com.sidsalon.styleandcut.model.Appointment;

public interface AppointmentDao {
	List<Appointment> findAllAppointment();
	Appointment createAppointment(Appointment appointment);

    Appointment findAppointment(Long id);

    void confirmAppointment(Long id);


}
