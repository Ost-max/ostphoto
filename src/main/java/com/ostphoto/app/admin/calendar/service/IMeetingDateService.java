package com.ostphoto.app.admin.calendar.service;

import java.util.List;

import com.ostphoto.app.admin.calendar.domains.MeetingDate;

public interface IMeetingDateService {
	void addMeetingDate(MeetingDate date);

	List<MeetingDate> getAllMeetingDates();
}
