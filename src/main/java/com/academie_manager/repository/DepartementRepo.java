package com.academie_manager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.academie_manager.entities.Departement;


public interface DepartementRepo extends JpaRepository<Departement, Short> {

	List<Departement> findByLabelDepartContaining(String labelDepart);
	

}
