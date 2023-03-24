package com.jwtuser;

import com.jwtuser.model.User;
import com.jwtuser.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Random;



@SpringBootApplication
public class UserApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	Random random=new Random();

	public void createUsers(){
//		User user=new User();
//		Long id=(long) random.nextInt(100);
//		user.setId(id);
//		user.setEmail("user"+id+"@gmail.com");
//		user.setPassword("user"+id);
//		user.setProfile("Developer");
//		user.setStatus(true);
//		user.setUsername("user"+id);
//
//		User save=userRepository.save(user);
//		System.out.println(save);

	}

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);

	}


	@Override
	public void run(String... args) throws Exception {
//		createUsers();
	}
}
