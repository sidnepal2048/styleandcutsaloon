package com.sidsalon.styleandcut.service;

import java.util.List;

import com.sidsalon.styleandcut.model.Appointment;

public interface AppointmentService {
	Appointment createAppointment(Appointment appointment);

    List<Appointment> findAllAppointment();

    Appointment findAppointment(Long id);

    void confirmAppointment(Long id);
}
