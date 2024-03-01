
package com.academie_manager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academie_manager.entities.Departement;
import com.academie_manager.entities.Enseignant;
import com.academie_manager.repository.DepartementRepo;
import com.academie_manager.repository.EnseignantRepo;
import com.academie_manager.repository.EtudiantRepos;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class EnseignantService  implements EnseignantInterface {

	@Autowired
	EnseignantRepo enseigantRepos;
	
	
	@Override
	public Enseignant createOrUpdateEnseignant(Enseignant e) {
		
		if((e.getNomEtud() == "")) {
			return null;
		}else {
			return enseigantRepos.save(e);
		}
		
	}

	@Override
	public List<Enseignant> getAllEnseignant() {
		// TODO Auto-generated method stub
		return enseigantRepos.findAll();
	}

	@Override
	public Enseignant deleteEnseignant(Short codeEtud) {
		// TODO Auto-generated method stub
		Optional<Enseignant> enseignant = enseigantRepos.findById(codeEtud);
		
		if (enseignant.get()==null) {
			return null;
		}else {
			enseigantRepos.delete(enseignant.get());
			 return enseignant.get();
		}
		
	}
	
	

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		enseigantRepos.deleteAll();
	}
	


	


	@Override
	public List<Enseignant> findByEnseignantNomEtud(String nomEtud) {
		// TODO Auto-generated method stub
		return enseigantRepos.findByNomEtudContaining(nomEtud);
	}

	@Override
	public long countEnseignant() {
		// TODO Auto-generated method stub
		return  enseigantRepos.count();
	}
	
      
}
