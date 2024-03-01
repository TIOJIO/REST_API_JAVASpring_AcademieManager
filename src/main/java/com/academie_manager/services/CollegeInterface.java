
package com.academie_manager.services;

import java.util.List;

import com.academie_manager.entities.College;


public interface CollegeInterface {
   
	public College createOrUpdateCollege(College c);
	
	public List<College> getAllColleges();
	
	public College deleteCollege(String  site);
	
	public void deleteAll();
	
	public List<College> findByCollegeSite(String site);
	
	
	public long countCollege();

	
}
