package edu.disease.asn6;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContactTrace {
	DiseaseControlManager dcm;
	List<Patient> p;
	//Patient p[]=null;
	public ContactTrace(DiseaseControlManager dcm) {
		this.dcm=dcm;
		p=new ArrayList<Patient>();
		p=dcm.getPatients();
	}
	PatientZero pzero=new PatientZero();
	PatientZero earliestDirectExposure = null;
	Patient patient=null;
	int i=0;
	
	/*
	 * Here's a general overview of how recursion works:

    The recursive function checks for a base case: This is a condition that determines when the function should stop calling itself and return a result. 
    It is usually a simple case that can be solved directly without further recursion.

    Recursive calls: If the base case is not met, the recursive function calls itself with a modified input. This creates a new instance of the function that works on a smaller or simpler version of the original problem.

    Progress towards the base case: Each recursive call should be designed to make progress towards the base case. This ensures that the function eventually reaches the base case and stops the recursion.

    Combining results: As the recursive calls return results, they are combined or processed to obtain the final result. This may involve merging, summing, multiplying, or performing other operations on the results.

Here's a simple example where a method should accept a patient to start with and loop through the patients exposures. 
All exposures that have exposureType equal to "D" is direct exposure.  
For each direct exposure, compare its dateTime value to the prior earliest exposure.  If the exposure is before the prior exposure, 
then assign it as the prior earliest exposure.  
Continue with this logic until you have recursively evaluated all exposures in the line of exposures starting with the first patient.

I first check the given patient for patientzero test and then I loop around all the patients from the patient array which I queried from DiseaseControlManager.
For Each patient I again continue with the same method findPateintZero(Patient p) and check whether this patient is infected before the previous patient.
This way I recursively do for all the patients and I zero in on the patient who is affected first.
	 */
	public PatientZero findPatientZero(Patient patient) {
		
	
        // Loop through the patient's exposures
		  
        for (Exposure exposure : patient.getExposures()) {
            if (exposure.getExposureType().equals("D")) {
                // Direct exposure found
            	
                if (earliestDirectExposure == null || exposure.getDateTime().isBefore(earliestDirectExposure.getExposureDateTime())) {
                	if(earliestDirectExposure!=null) {
                	System.out.println(exposure.getDateTime()+":"+earliestDirectExposure.getExposureDateTime());
                	}
                    // Update the earliest direct exposure
                	pzero.setExposed(true);
                	pzero.setExposureDateTime(exposure.getDateTime());
                	pzero.setPatient(patient);
                    earliestDirectExposure = pzero;
                }
            }
        }

   	 // Recursively evaluate exposures of contacted patients
        if(i<p.size()) {
        	Patient contactedPatient=p.get(i);
        	i++;
            PatientZero directExposure = findPatientZero(contactedPatient);
            
            if (directExposure != null) {
                if (earliestDirectExposure == null || directExposure.getExposureDateTime().isBefore(earliestDirectExposure.getExposureDateTime())) {
                    // Update the earliest direct exposure
                    earliestDirectExposure = directExposure;
                }
            }
        }
      
        return earliestDirectExposure;
         
    }
		
	
	
}
