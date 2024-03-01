package com.academie_manager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academie_manager.entities.Departement;
import com.academie_manager.entities.Salle;
import com.academie_manager.repository.DepartementRepo;
import com.academie_manager.repository.EtudiantRepos;
import com.academie_manager.repository.SalleRepo;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class SalleService  implements SalleInterface {

	@Autowired
	SalleRepo salleRepos;
	
	
	@Override
	public Salle createOrUpdateSalle(Salle s) {
		
		if((s.getNumSalle()) == null) {
			return null;
		}else {
			return salleRepos.save(s);
		}
		
	}

	@Override
	public List<Salle> getAllSalle() {
		// TODO Auto-generated method stub
		return salleRepos.findAll();
	}

	@Override
	public Salle deleteSalle(Short numSalle) {
		// TODO Auto-generated method stub
		Optional<Salle> salle = salleRepos.findById(numSalle);
		
		if (salle.get()==null) {
			return null;
		}else {
			salleRepos.delete(salle.get());
			 return salle.get();
		}
		
	}
	
	

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		salleRepos.deleteAll();
	}
	


	


	@Override
	public Salle findBySalleNumSalle(Short numsalle) {
		// TODO Auto-generated method stub
		return salleRepos.findById(numsalle).get();
	}

	@Override
	public long countSalle() {
		// TODO Auto-generated method stub
		return  salleRepos.count();
	}
	
      
}

