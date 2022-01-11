package com.loginsystem.userevents.User;

import java.util.LinkedList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.loginsystem.userevents.Event.Event;
import com.loginsystem.userevents.Event.EventRepository;

@Controller
public class UserController {
    
    @Autowired
    private UserRepository repository;
    @Autowired
    private EventRepository repo;
    
    //Home page
    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }

	//Show all User on page
	  @GetMapping("/users") 
      public String getUser(Model model,Model m){
		  List<User> list= this.repository.findAll();
		  LinkedList<Event> li= this.repo.getallEvents();
		  m.addAttribute("li",li);
	  model.addAttribute("list",list);
	  return "users"; }
	  //Add user Page
	  @GetMapping("/Signup")
       public String signup(Model model) {
	  model.addAttribute("user",new User());
       return "signup"; }
	  
    //For Login on Page   
	  @GetMapping("/login")
     public String login(Model model){ 
	  model.addAttribute("user",new User());
	  return "login"; 
  }  

  //Save User Details on DB
@Transactional
   @PostMapping("/process_register")
   public String processRegister(User user,Model m) throws Exception {
	   BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    String encodedPassword = passwordEncoder.encode(user.getPassword());
	    user.setPassword(encodedPassword);
     //  this.repository.addUser(user.getName(),user.getAge(), user.getGender(),user.getEmail(),user.getPassword());
     User u=this.repository.findByEmail(user.getEmail());
     //Checking for unique Email
	  if(u==null){
        repository.save(user);
          return "index";
    }else{
      m.addAttribute("email","ENTER UNIQUE_EMAIL");
      new Exception("Email Exist");
      return "signup";
    }
	    
	    
   } 
}
