package org.sid.test.treatment;

import java.io.Serializable;

import org.mindrot.jbcrypt.BCrypt;
import org.sid.test.dao.UserRepository;
import org.sid.test.entity.User;
import org.sid.test.treatment.interfaces.UserTreamentInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserTreatment implements UserTreamentInterface{

	@Autowired
	private UserRepository userRepository;

	public User createUser(String userPseudo, String mdp, String email, String nom, String prenom) {
System.out.println("pourquoi01");
		String hashedpassword = null;
		hashedpassword = BCrypt.hashpw(mdp, BCrypt.gensalt());
return		userRepository.save(new User(userPseudo, hashedpassword, email, nom, prenom));

	}

}
