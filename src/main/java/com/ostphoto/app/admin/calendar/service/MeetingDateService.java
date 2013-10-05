package com.ostphoto.app.admin.calendar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ostphoto.app.admin.calendar.dao.IMeetingDateDao;
import com.ostphoto.app.admin.calendar.domains.MeetingDate;

@Service
public class MeetingDateService implements IMeetingDateService {

	@Autowired
	private IMeetingDateDao meetingDateDao;

	@Override
	@Transactional
	public void addMeetingDate(MeetingDate date) {
		meetingDateDao.create(date);
	}

	@Override
	@Transactional
	public List<MeetingDate> getAllMeetingDates() {
		return meetingDateDao.getAll();
	}

}