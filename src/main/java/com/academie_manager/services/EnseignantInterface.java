
package com.academie_manager.services;

import java.util.List;

import com.academie_manager.entities.College;
import com.academie_manager.entities.Enseignant;


public interface EnseignantInterface {
   
	public Enseignant createOrUpdateEnseignant(Enseignant e);
	
	public List<Enseignant> getAllEnseignant();
	
	public Enseignant deleteEnseignant(Short codeEtud);
	
	public void deleteAll();
	
	public List<Enseignant> findByEnseignantNomEtud(String nomEtud);
	
	
	public long countEnseignant();

	
}
