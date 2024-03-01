
package com.academie_manager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academie_manager.entities.College;
import com.academie_manager.entities.Departement;
import com.academie_manager.repository.CollegeRepo;
import com.academie_manager.repository.DepartementRepo;
import com.academie_manager.repository.EtudiantRepos;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class CollegeService  implements CollegeInterface {

	@Autowired
	CollegeRepo collegeRepos;
	
	
	@Override
	public College createOrUpdateCollege(College c) {
		
		if((c.getSite() == "")) {
			return null;
		}else {
			return collegeRepos.save(c);
		}
		
	}

	@Override
	public List<College> getAllColleges() {
		// TODO Auto-generated method stub
		return collegeRepos.findAll();
	}

	@Override
	public College deleteCollege(String site) {
		// TODO Auto-generated method stub
		Optional<College> college = collegeRepos.findById(site);
		
		if (college.get()==null) {
			return null;
		}else {
			collegeRepos.delete(college.get());
			 return college.get();
		}
		
	}
	
	

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		collegeRepos.deleteAll();
	}
	


	


	@Override
	public List<College> findByCollegeSite(String site) {
		// TODO Auto-generated method stub
		return collegeRepos.findBysiteContaining(site);
	}

	@Override
	public long countCollege() {
		// TODO Auto-generated method stub
		return  collegeRepos.count();
	}
	
      
}
