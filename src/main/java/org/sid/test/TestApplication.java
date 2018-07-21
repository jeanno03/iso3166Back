package org.sid.test;


import org.sid.test.dao.Iso3166Repository;
import org.sid.test.dao.UserRepository;
import org.sid.test.entity.Iso3166;
import org.sid.test.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestApplication implements CommandLineRunner {
	
	@Autowired
	private Iso3166Repository iso3166Repository;
	
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
//		iso3166Repository.save(new Iso3166( "France","AA","AAA",9f));
		iso3166Repository.findAll().forEach(i->{
			System.out.println(i.getPays());
		});
//		userRepository.save(new User("king","1234","king@king.com","Legrand","Stephane"));
		userRepository.findAll().forEach(u->{
			System.out.println(u.getPseudo());
		});
	}
	

}
