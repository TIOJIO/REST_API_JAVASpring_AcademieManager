package com.academie_manager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.academie_manager.entities.Matiere;



public interface MatiereRepo extends JpaRepository<Matiere, String> {

	List<Matiere> findByLabelMatContaining(String labelMat);
	

}
