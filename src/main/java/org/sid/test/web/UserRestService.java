package org.sid.test.web;

import java.util.List;

import org.sid.test.dao.UserRepository;
import org.sid.test.entity.Iso3166;
import org.sid.test.entity.User;
import org.sid.test.treatment.UserTreatment;
import org.sid.test.treatment.interfaces.UserTreamentInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class UserRestService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserTreamentInterface userTreamentInterface;
	
	
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<User> getUsers() {
		return userRepository.findAll();
	}
	
	@RequestMapping(value = "/user/{pseudo}", method = RequestMethod.GET)
	public User getUser(@PathVariable String pseudo) {
		return userRepository.findOne(pseudo);
	}

//	@RequestMapping(value = "/createUser/{pseudo}/{mdp}/{email}/{nom}/{prenom}", method = RequestMethod.GET)
//	public User createUser(
//			@PathVariable String pseudo,
//			@PathVariable String mdp,
//			@PathVariable String email,
//			@PathVariable String nom,
//			@PathVariable String prenom
//			) {
//		try {
//System.out.println("OK");
//
//			System.out.println("pseudo : " + pseudo);
//			userTreamentInterface.createUser(pseudo, mdp, email, nom, prenom);
//			return	null;
//			
//	
//	
//		}catch(NullPointerException ex) {
//			//
//		}
//		
//		return null;
//	}

	
	
	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public User save(@RequestBody User u) {
		String pseudo = null;
		String mdp = null;
		String email = null;
		String nom = null;
		String prenom = null;
		
		try {
			pseudo = u.getPseudo();
			mdp = u.getMdp();
			email = u.getEmail();
			nom = u.getNom();
			prenom = u.getPrenom();
			return userTreamentInterface.createUser(pseudo, mdp, email, nom, prenom);
		}catch (NullPointerException ex) {
			//
		}
		return null;
		
	}
	
	
	
	
	
	
	
}
