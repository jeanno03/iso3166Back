package org.sid.test.dao;


import org.sid.test.entity.Iso3166;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Iso3166Repository extends JpaRepository<Iso3166,String>{
	
@Query("select i from Iso3166 i where i.pays like :x")
public Page<Iso3166> chercher(@Param("x")String mc, Pageable pageable);
	


}
