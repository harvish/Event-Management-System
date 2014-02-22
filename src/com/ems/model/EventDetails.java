package com.ems.model;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class EventDetails {
	private String customerId;
	private String name;
	private Date startDate;
	private Date endDate ;
	private String eventType;
	private String venueId;
	private int startTime;
	private int endTime;
	private int Budget;
	private String eventId;
	private SimpleDateFormat sdf;
	public EventDetails() {
		sdf=new SimpleDateFormat("yyyy-MM-dd");
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) throws ParseException {
		this.startDate = new java.sql.Date(sdf.parse(startDate).getTime());
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) throws ParseException {
		this.endDate =  new java.sql.Date(sdf.parse(endDate).getTime());
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public String getVenueId() {
		return venueId;
	}
	public void setVenueId(String venueId) {
		this.venueId = venueId;
	}
	public int getStartTime() {
		return startTime;
	}
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
	public int getEndTime() {
		return endTime;
	}
	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}
	public int getBudget() {
		return Budget;
	}
	public void setBudget(int budget) {
		Budget = budget;
	}
	
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	
	public String getEventId() {
		return this.eventId;
	}
	@Override
	public String toString() {
		return "EventDetails [customerId=" + customerId + ", name=" + name
				+ ", startDate=" + startDate + ", endDate=" + endDate
				+ ", eventType=" + eventType + ", venueId=" + venueId
				+ ", startTime=" + startTime + ", endTime=" + endTime
				+ ", Budget=" + Budget + "]";
	}
	
}
