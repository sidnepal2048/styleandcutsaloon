package com.sidsalon.styleandcut.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sidsalon.styleandcut.model.Authorities;
import com.sidsalon.styleandcut.model.Stylist;
import com.sidsalon.styleandcut.model.Users;
@Repository
public class StylistDaoImpl implements StylistDao {
@Autowired
private SessionFactory sessionFactory;
	@Override
	@Transactional
	public List<Stylist> getAllStylist() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Stylist");
		List<Stylist> stylist = query.list();
		session.flush();
		return stylist;
		}

	@Override
	@Transactional
	public Stylist getStylistById(int stylistId) {
		Session session = sessionFactory.openSession();
		Stylist stylist = (Stylist)session.get(Stylist.class, stylistId);
		session.flush();
		return stylist;
	}

	@Override
	@Transactional
	public void addStylist(Stylist stylist) {
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(stylist);
		
		Users user = new Users();
		user.setUsername(stylist.getUsername());
		user.setPassword(stylist.getStylistPassword());
		user.setEnabled(true);
		user.setStylistId(stylist.getStylistId());
		session.saveOrUpdate(user);
		
		Authorities authority = new Authorities();
		authority.setUsername(stylist.getUsername());
		authority.setAuthority("ROLE_ADMIN");
		session.saveOrUpdate(authority);
		session.flush();

	}

}
