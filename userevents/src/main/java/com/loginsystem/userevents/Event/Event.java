package com.loginsystem.userevents.Event;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.loginsystem.userevents.User.User;
//Create table event
@Entity
public class Event {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "eventid")
    private int EventId;

    @Column(nullable = false,name="name")
    private String Name;
    
    @Column(name = "description")
    private String Description;

    @Column(nullable = false,name = "Location")
    private String Location;

    @Column(nullable = false,name="starttime")
    private String StartTime;

    @Column(name = "endtime")
    private String EndTime;
    
    @OneToOne(cascade = CascadeType.ALL)
   private User userid;

    public Event() {
    }

	public int getEventId() {
		return EventId;
	}

	public void setEventId(int eventId) {
		EventId = eventId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public String getStartTime() {
		return StartTime;
	}

	public void setStartTime(String startTime) {
		StartTime = startTime;
	}

	public String getEndTime() {
		return EndTime;
	}

	public void setEndTime(String endTime) {
		EndTime = endTime;
	}

	public User getUserid() {
		return userid;
	}

	public void setUserid(User userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "Event [EventId=" + EventId + ", Name=" + Name + ", Description=" + Description + ", Location="
				+ Location + ", StartTime=" + StartTime + ", EndTime=" + EndTime + ", userid=" + userid + "]";
	}

   
}