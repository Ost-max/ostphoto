package com.ostphoto.app.admin.calendar.domains;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "meeting_date")
public class MeetingDate {
	// id` INT NOT NULL,
	// `fio` VARCHAR(200) NULL,
	// `date` DATE NULL,
	// `startTime` TIME NULL,
	// `endTime` TIME NULL,

	@Id
	@Column(name = "id")
	@GeneratedValue
	private int id;

	public int getId() {
		return id;
	}

	@Column(name = "fio")
	private String fio;

	@Column(name = "meetingDate")
	private Date meetingDate;

	@Column(name = "startTime")
	private String startTime;

	@Column(name = "endTime")
	private String endTime;

	public String getFio() {
		return fio;
	}

	public void setFio(String fio) {
		this.fio = fio;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public Date getMeetingDate() {
		return meetingDate;
	}

	public void setMeetingDate(Date meetingDate) {
		this.meetingDate = meetingDate;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
}
