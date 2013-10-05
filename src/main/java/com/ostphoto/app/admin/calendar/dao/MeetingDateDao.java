package com.ostphoto.app.admin.calendar.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ostphoto.app.admin.calendar.domains.MeetingDate;

@Repository
public class MeetingDateDao implements IMeetingDateDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void create(MeetingDate meetingDate) {
		sessionFactory.getCurrentSession().save(meetingDate);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MeetingDate> getAll() {
		return sessionFactory.getCurrentSession()
				.createQuery("from meeting_date").list();
	}

}
