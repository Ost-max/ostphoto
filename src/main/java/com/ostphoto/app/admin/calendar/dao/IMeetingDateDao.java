package com.ostphoto.app.admin.calendar.dao;

import java.util.List;

import com.ostphoto.app.admin.calendar.domains.MeetingDate;

public interface IMeetingDateDao {

	void create(MeetingDate meetingDate);

	List<MeetingDate> getAll();

}
