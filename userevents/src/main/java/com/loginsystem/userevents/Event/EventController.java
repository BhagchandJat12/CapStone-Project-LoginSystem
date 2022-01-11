package com.loginsystem.userevents.Event;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import javax.transaction.Transactional;

import com.loginsystem.userevents.User.User;
import com.loginsystem.userevents.User.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EventController {

    @Autowired
    private EventRepository repository;
    @Autowired
    private UserRepository repo;
  //Add Event page
    @GetMapping("/add")
    public String addEvent(Event event,Model m){
        m.addAttribute("event",new Event());
       LinkedList<Integer> li=this.repo.findById();
     // LinkedList<User> li=this.repo.getAllUser();
        m.addAttribute("li", li);
        return "addevent";
    }
   //Save Event to DB
     @Transactional
    @PostMapping("/addevents")
    public String SaveEvent(Event event,Model m,Model mod,Model mo) throws Exception{
    	LinkedList<Event> li=  this.repository.getallEvents();
    	List<User> list=this.repo.findAll();
    	mo.addAttribute("li" ,li);
    	 mod.addAttribute("list",list);
      LocalDate s= LocalDate.parse(event.getStartTime());
      LocalDate e= LocalDate.parse(event.getEndTime());
      if(event.getName()!=null&& event.getLocation()!=null) {
    	  if(s.isBefore(e) || s.isEqual(e) &&s!=null) { 
    	        this.repository.save(event);
    	         return "users";
    	    }else{
    	      m.addAttribute("string", "Enter valid date");
    	      new Exception("Enter valid date");
    	      return "addevent";
    	    }
      }else {
    	  m.addAttribute("string", "Enter Details");
          new Exception("Enter valid date");
          return "addevent";
      }
   
    }
    
    //Show all Events on Page
    @GetMapping("/events")
    public String events(Event e,Model m,Model ms) throws Exception{
        m.addAttribute("event", new Event());
        LinkedList<Event> list= this.repository.findByStartTime(e.getStartTime());
        ms.addAttribute("li",list);
        System.out.println(e.getStartTime());
        new Exception();
        return "users";
    }

  
}
