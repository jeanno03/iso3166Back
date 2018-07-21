package org.sid.test.web;

import java.util.List;


import org.sid.test.dao.Iso3166Repository;
import org.sid.test.entity.Iso3166;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class Iso3166RestService {

	@Autowired
	private Iso3166Repository iso3166Repository;

	@RequestMapping(value = "/iso3166s", method = RequestMethod.GET)
	public List<Iso3166> getIso3166s() {
		return iso3166Repository.findAll();
	}

	@RequestMapping(value = "/iso3166s/{pays}", method = RequestMethod.GET)
	public Iso3166 getIso3166(@PathVariable String pays) {
		return iso3166Repository.findOne(pays);
	}

	@RequestMapping(value = "/chercherIso3166", method = RequestMethod.GET)
	public Page<Iso3166> chercher(@RequestParam(name = "mc", defaultValue = "") String mc,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "15") int size) {
		return iso3166Repository.chercher("%" + mc + "%", new PageRequest(page, size));
	}

	@RequestMapping(value = "/saveIso3166s", method = RequestMethod.POST)
	public Iso3166 save(@RequestBody Iso3166 i) {
		return iso3166Repository.save(i);
	}
	

	@RequestMapping(value = "/iso3166s/{pays}", method = RequestMethod.DELETE)
	public boolean supprimer(@PathVariable String pays) {
		iso3166Repository.delete(pays);
		return true;
	}

	@RequestMapping(value = "/iso3166s/{pays}", method = RequestMethod.PUT)
	public Iso3166 save(@PathVariable String pays, @RequestBody Iso3166 i) {
		System.out.println("\npays "+pays +" - i.getPays "+i.getPays());
			//si on modifie pas le nom du pays
		if(pays.equals(i.getPays())) {
	//			iso3166Repository.delete(pays);
				i.setPays(pays);		
			}
		//si on modifie le nom du pays
	if(!pays.equals(i.getPays())) {
			iso3166Repository.delete(pays);
			iso3166Repository.save(i);
		}
		return iso3166Repository.save(i);

	}

}
