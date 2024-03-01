

package com.academie_manager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.academie_manager.entities.College;




public interface CollegeRepo extends JpaRepository<College, String> {

	List<College> findBysiteContaining(String site);
	

}

