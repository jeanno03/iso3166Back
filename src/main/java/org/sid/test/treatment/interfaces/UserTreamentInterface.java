package org.sid.test.treatment.interfaces;

import org.sid.test.entity.User;

public interface UserTreamentInterface {
	
	public User createUser(String userPseudo, String mdp, String email, String nom, String prenom) ;

}
