
package com.academie_manager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academie_manager.entities.Departement;
import com.academie_manager.repository.DepartementRepo;
import com.academie_manager.repository.EtudiantRepos;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class DepartementService  implements DepartementInterface {

	@Autowired
	DepartementRepo departementRepos;
	
	
	@Override
	public Departement createOrUpdateDepartement(Departement d) {
		
		if((d.getLabelDepart() == "")) {
			return null;
		}else {
			return departementRepos.save(d);
		}
		
	}

	@Override
	public List<Departement> getAllDepartement() {
		// TODO Auto-generated method stub
		return departementRepos.findAll();
	}

	@Override
	public Departement deleteDepartement(Short codeDepart) {
		// TODO Auto-generated method stub
		Optional<Departement> departemennt = departementRepos.findById(codeDepart);
		
		if (departemennt.get()==null) {
			return null;
		}else {
			departementRepos.delete(departemennt.get());
			 return departemennt.get();
		}
		
	}
	
	

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		departementRepos.deleteAll();
	}
	


	


	@Override
	public List<Departement> findByDepartementLabelDepart(String labelDepart) {
		// TODO Auto-generated method stub
		return departementRepos.findByLabelDepartContaining(labelDepart);
	}

	@Override
	public long countDepartement() {
		// TODO Auto-generated method stub
		return  departementRepos.count();
	}
	
      
}
