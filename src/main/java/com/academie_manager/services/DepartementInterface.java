
package com.academie_manager.services;

import java.util.List;

import com.academie_manager.entities.Departement;

public interface DepartementInterface {
   
	public Departement createOrUpdateDepartement(Departement d);
	
	public List<Departement> getAllDepartement ();
	
	public Departement deleteDepartement(Short codeDepart);
	
	public void deleteAll();
	
	public List<Departement> findByDepartementLabelDepart(String labelDepart);
	
	
	public long countDepartement();
}
