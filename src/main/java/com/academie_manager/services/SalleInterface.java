
package com.academie_manager.services;

import java.util.List;
import com.academie_manager.entities.Salle;

public interface SalleInterface {
   
	public Salle createOrUpdateSalle(Salle s);
	
	public List<Salle> getAllSalle();
	
	public Salle deleteSalle(Short numSalle);
	
	public void deleteAll();
	
	public Salle findBySalleNumSalle(Short numSalle);
	
	
	public long countSalle();
}
