package org.sid.test.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.print.Pageable;


import org.sid.test.entity.User;

public interface UserRepository extends JpaRepository<User,String>{

//	@Query("select u from User i where u.pseudo like :x")
//	public Page<User> chercher(@Param("x")String mc, Pageable pageable);
}
