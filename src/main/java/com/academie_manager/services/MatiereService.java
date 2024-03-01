package com.academie_manager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academie_manager.entities.Departement;
import com.academie_manager.entities.Matiere;
import com.academie_manager.repository.DepartementRepo;
import com.academie_manager.repository.EtudiantRepos;
import com.academie_manager.repository.MatiereRepo;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class MatiereService  implements MatiereInterface {

	@Autowired
	MatiereRepo matiereRepos;
	
	
	@Override
	public Matiere createOrUpdateMatiere(Matiere m) {
		
		if((m.getLabelMat() == "")) {
			return null;
		}else {
			return matiereRepos.save(m);
		}
		
	}

	@Override
	public List<Matiere> getAllMatiere() {
		// TODO Auto-generated method stub
		return matiereRepos.findAll();
	}

	@Override
	public Matiere deleteMatiere(String codeMat) {
		// TODO Auto-generated method stub
		Optional<Matiere> matiere = matiereRepos.findById(codeMat);
		
		if (matiere.get()==null) {
			return null;
		}else {
			matiereRepos.delete(matiere.get());
			 return matiere.get();
		}
		
	}
	
	

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		matiereRepos.deleteAll();
	}
	


	


	@Override
	public List<Matiere> findByMatiereCodeMat(String labelMat) {
		// TODO Auto-generated method stub
		return matiereRepos.findByLabelMatContaining(labelMat);
	}

	@Override
	public long countMatiere() {
		// TODO Auto-generated method stub
		return  matiereRepos.count();
	}
	
      
}
