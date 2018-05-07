package com.sidsalon.styleandcut.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sidsalon.styleandcut.model.Appointment;
@Repository
public class AppointmentDaoImpl implements AppointmentDao {
@Autowired 
private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Appointment> findAllAppointment() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("Select ap from Appointment ap where (customer != null and stylist!=null) and date!=null");
		List<Appointment> appointmentList = query.list();
		//session.flush();
		if(session.isOpen()){
			session.close();
		}
		return appointmentList;
	}
	
	@Override
	@Transactional
	public Appointment findAppointment(Long id) {
		Session session = sessionFactory.openSession();
		Appointment appointment = (Appointment)session.get(Appointment.class, id);
		session.flush();
		return appointment;
	}
	
	@Override
	@Transactional
	public void confirmAppointment(Long id) {
		Session session = sessionFactory.openSession();
		Appointment appointment = findAppointment(id);
	    appointment.setConfirmed(true);
	    session.save(appointment);
	    session.flush();
	}
		
	@Override
	@Transactional
	public Appointment createAppointment(Appointment appointment) {
		Session session = sessionFactory.openSession();
		//session.saveOrUpdate(appointment);
		//System.out.println(appointment);
		appointment.setConfirmed(true);
		session.merge(appointment);
		//session.saveOrUpdate(appointment);
		
		session.flush();
		return appointment;
	}

	public String findAppointment() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Appointment");
		String appointment = query.getQueryString();
		session.flush();
		return appointment;
	}
	
}
