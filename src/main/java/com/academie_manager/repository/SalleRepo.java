
package com.academie_manager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.academie_manager.entities.Salle;


public interface SalleRepo extends JpaRepository<Salle, Short> {
	

}
