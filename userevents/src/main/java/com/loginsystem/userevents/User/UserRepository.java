package com.loginsystem.userevents.User;

import java.util.LinkedList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * @author BHAGCHAND JAT
 *
 */
public interface UserRepository extends JpaRepository<User,Integer>{
    //Get all User detail from DB
    @Query(value = "select u from User u")
    public LinkedList<User> getAllUser();
   //Get  User detail for email and password 
    @Query( "select u from User u where u.Email= ?1 and u.Password= ?2")
    public LinkedList<User> findByEmailandpassword( String Email, String Pass); 

	
	 @Modifying
	  @Query("update  User b set   b.Name= ?1 ,b.Age= ?2,b.Gender= ?3, b.Email= ?4,b.Password= ?5  where b.Id= ?6" )
	 public void updateUser( String Name, int age, String gender, String Email, String pass, int id);
	  
	 
    // show details of user for some email
    @Query( "select u from User u where u.Email=?1")
    public User findByEmail( String email);

	@Query( "select u.Id from User u")
    public LinkedList<Integer> findById( );
    
    @Query( "select u from User u where u.Password=?1")
    public User findByPass( String pass);

    
}
