package com.academie_manager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academie_manager.entities.Etudiant;
import com.academie_manager.repository.EtudiantRepos;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class EtudiantService  implements EtudiantInterface {

	@Autowired
	EtudiantRepos etudiantRepos;
	
	
	@Override
	public Etudiant createOrUpdateEtudiant(Etudiant e) {
		
		if((e.getNomEtud() == "") || (!e.getMailEtud().contains("@"))) {
			return null;
		}else {
			return etudiantRepos.save(e);
		}
		
	}

	@Override
	public List<Etudiant> getAllEtudiants() {
		// TODO Auto-generated method stub
		return etudiantRepos.findAll();
	}

	@Override
	public Etudiant deleteEtudiant(Short codeEtudiant) {
		// TODO Auto-generated method stub
		
		Optional<Etudiant> etudiant = etudiantRepos.findById(codeEtudiant);
		
		if (etudiant.get()==null) {
			return null;
		}else {
			 etudiantRepos.delete(etudiant.get());
			 return etudiant.get();
		}
		
	}
	
	

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		etudiantRepos.deleteAll();
	}
	

	@Override
	public List<Etudiant> findByEtudiantName(String etudiantName) {
		// TODO Auto-generated method stub
		//etudiantRepos.findBy(null, null)
		return etudiantRepos.findByNomEtudContaining(etudiantName);
	}

	@Override
	public List<Etudiant> findByEtudiantEmail(String etudiantEmail) {
		// TODO Auto-generated method stub
		return etudiantRepos.findByMailEtudContaining(etudiantEmail);
	}

	@Override
	public Etudiant findByUserCode(Short userId) {
		// TODO Auto-generated method stub
		return etudiantRepos.findById(userId).get();
	}

	@Override
	public long countEtudiant() {
		// TODO Auto-generated method stub
		return etudiantRepos.count();
	}
	
      
}
