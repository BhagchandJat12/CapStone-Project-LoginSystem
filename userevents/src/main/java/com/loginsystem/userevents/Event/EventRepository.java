package com.loginsystem.userevents.Event;

import java.util.LinkedList;

import com.loginsystem.userevents.User.User;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface EventRepository extends CrudRepository<Event,Integer>{
	
	@Query(value="select * from Event",nativeQuery=true)
	LinkedList<Event> getallEvents();

    //Query for insertion
    @Modifying
    @Query(value = "insert into Event(EventId,Name,Description,Location,StartTime,EndTime,user) values(:i,:n,:d,:l,:s,:e,:u)",nativeQuery = true)
    public void addEvent(@Param("i") int id,@Param("n") String name,@Param("d") String desc,@Param("l") String loc,@Param("s") String sd,@Param("e") String ed,@Param("u") User user);
    
    //Query for display EventList for starttime
    @Modifying
    @Query(value = "select * from Event e where e.StartTime=:s",nativeQuery = true)
    public LinkedList<Event> findByStartTime(@Param("s") String st);
}
