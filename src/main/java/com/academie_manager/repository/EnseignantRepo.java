
package com.academie_manager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.academie_manager.entities.Departement;
import com.academie_manager.entities.Enseignant;


public interface EnseignantRepo extends JpaRepository<Enseignant, Short> {

	List<Enseignant> findByNomEtudContaining(String nomEtud);
	

}
