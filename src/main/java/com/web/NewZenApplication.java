package com.web;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.web.dao.UserRepository;
import com.web.entities.User;

@SpringBootApplication
public class NewZenApplication {

	private final UserRepository userRepository;

	NewZenApplication(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		
		
	  ApplicationContext context =	SpringApplication.run(NewZenApplication.class, args);
	  UserRepository userRepository = context.getBean(UserRepository.class);
//	  User user = new User();
//	  user.setName("Harshal");
//	  user.setCity("Chandrapur");
//	  user.setStatus("Java Programmer");
//	  userRepository.save(user);
//	  System.out.println(user);
	  
//	  User user1 = new User();
//	  user1.setName("Nikhil");
//	  user1.setCity("Jharkhand");
//	  user1.setStatus("Programmer");
//	  
//	  User user2 = new User();
//	  user2.setName("Sai");
//	  user2.setCity("Hyderabad");
//	  user2.setStatus("Programmer");
//	  
//	  List<User> users = List.of(user1,user2);
//	  Iterable<User> saveAll = userRepository.saveAll(users);
//	  saveAll.forEach(user->{
//		  System.out.println(user);
//	  });
	  
	  //Update by user id
//	  Optional<User> optional = userRepository.findById(3);
//	  User user = optional.get();
//	  System.out.println(user);
//	  user.setName("Sai Kumar");
//	  user.setCity("Ameerpet");
//	  
//	  User result = userRepository.save(user);
//	  System.out.println(result);
	  //how to get the data
	  //findById - return optional containing data
	  
//	  Iterable<User> itr = userRepository.findAll();
//	  Iterator<User> iterator = itr.iterator();
//	  while (iterator.hasNext()) {
//		User user = iterator.next();
//		System.out.println(user);
//	}
	 
//	  Iterable<User> itr = userRepository.findAll();
//	  itr.forEach(new Consumer<User>() {
//		@Override
//		public void accept(User t) {
//			// TODO Auto-generated method stub
//			System.out.println(t);
//		}
//		  
//	  });


//	  Iterable<User> itr = userRepository.findAll();
//	  itr.forEach(user->{
//		  System.out.println(user);
//	  });
	  
	  //Deleting the user by id
//	  userRepository.deleteById(3);
//	  System.out.println("deleted");
	  
	  //Deleting all users
	  Iterable<User> users = userRepository.findAll();
	  users.forEach(user->System.out.println(user));
	  userRepository.deleteAll(users);
	}

}
