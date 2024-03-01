package com.academie_manager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.academie_manager.entities.Etudiant;

@Repository
public interface EtudiantRepos extends JpaRepository<Etudiant, Short> {
  
	List<Etudiant> findByNomEtudContaining(String nom);
	
	List<Etudiant> findByMailEtudContaining(String email);
	 
}
