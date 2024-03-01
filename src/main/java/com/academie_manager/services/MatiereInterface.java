
package com.academie_manager.services;

import java.util.List;

import com.academie_manager.entities.Matiere;

public interface MatiereInterface {
   
	public Matiere createOrUpdateMatiere(Matiere m);
	
	public List<Matiere> getAllMatiere();
	
	public Matiere deleteMatiere(String codeMat);
	
	public void deleteAll();
	
	public List<Matiere> findByMatiereCodeMat(String codeMat);
	
	
	public long countMatiere();
}
