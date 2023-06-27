package edu.disease.asn6;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
The DiseaseControlManagerImpl class implements the DiseaseControlManager interface.
*/

public class DiseaseControlManagerImpl implements DiseaseControlManager{
	private List<Disease> diseases;
	private List<Patient> patients;
	int maxDisease=0;
	int maxPatients=0;
	
	/**
	@throws IllegalArgumentException if maxDisease or maxPatients is less than or equal to 0.
	*/
	public DiseaseControlManagerImpl(int maxDisease,int maxPatients) {
		if(maxDisease<=0 || maxPatients<=0){
			throw new IllegalArgumentException("the arguments passed are not valid..pass value greater than zero.");
		}
		else {
			diseases=new ArrayList<Disease>();
			
			patients=new ArrayList<Patient>();
			this.maxDisease=maxDisease;
			this.maxPatients=maxDisease;
		}
	}

	int diseasecount=0;
	int patientcount=0;
	/**
	@throws IllegalStateException if the maximum limit for adding diseases has been reached.
	*/
	@Override
	public Disease addDisease(String name, boolean infectious) {

		
		if(diseases.size()<maxDisease) {
			if(infectious) {
				Disease d=new InfectiousDisease();
				d.setName(name);
				d.setDiseaseId(UUID.randomUUID());
				diseases.add(d);
				diseasecount++;
			}
			else
			{
				Disease d=new NonInfectiousDisease();
				d.setName(name);
				d.setDiseaseId(UUID.randomUUID());
				diseases.add(d);
				diseasecount++;
			}
		}
		else {
				throw new IllegalStateException("maximum limit reached for adding diseases");
			}
		return diseases.get(diseasecount-1);
	}
	

	@Override
	public Disease getDisease(UUID dieseaseId) {		
		for(Disease d:diseases) {
			if(d!=null) {
			if(d.getDiseaseId()==dieseaseId) {
				return d;
			}
			break;
			}
		}
				return null;
	}
	/**
	* @throws IllegalStateException if the maximum limit for adding patients has been reached.
    */

	@Override
	public Patient addPatient(String firstName, String lastName, int maxDiseases, int maxExposures) {
		
		
		if(patients.size()<maxPatients) {
			Patient p=new Patient(maxDiseases,maxExposures);
			p.setFirstName(firstName);
			p.setLastName(lastName);
			p.setPatientId(UUID.randomUUID());
			patients.add(p);
			patientcount++;
		}
		else {
			throw new IllegalStateException("maximum limit reached for adding patients.....");
		}
		return patients.get(patientcount-1);

	}
	@Override
	public Patient getPatient(UUID patientId) {
				for(Patient p:patients) {
					if(p!=null) {	
						if(p.getPatientId()==patientId) {
							return p;
						}
						break;
					}
				}
				return null;
	}
	/**
	* @throws IllegalArgumentException if the patientId or diseaseId is invalid.
    */

	@Override
	public void addDiseaseToPatient(UUID patientId, UUID diseaseId) {
		Patient patient=null;
		Disease disease=null;

		if(patients.isEmpty()) {
			throw new IllegalArgumentException("there are no patients in the patient collection....");
		}
		
		for(Patient p:patients) {
			if(p!=null) {	
				if(p.getPatientId()==patientId) {
					patient=p;
					break;
				}
				else {
					throw new IllegalArgumentException("patient ID passed is not valid...");
				}
			}
		}
		
		if(diseases.isEmpty()) {
			throw new IllegalArgumentException("there are no diseases in the diseases collection...");
		}
		for(Disease d:diseases) {
			if(d!=null) {
				if(d.getDiseaseId()==diseaseId) {
					disease=d;
					System.out.println(disease);
					break;
				}
				else {
					throw new IllegalArgumentException("disease ID passed is not valid");
				}
			}
		}
		
		
		patient.addDiseaseId(disease.getDiseaseId());
		System.out.println(patient.getDiseaseIds());
	}
	/**
	* @throws IllegalArgumentException if the patientId is invalid.
    */

	@Override
	public void addExposureToPatient(UUID patientId, Exposure exposure) {
		if(patients.isEmpty()) {
				throw new IllegalArgumentException("there are no diseases in the diseases collection...");
		}
		for(Patient p:patients) {
			if(p!=null) {
				if(p.getPatientId()==patientId) {
					System.out.println(exposure);
					p.addExposure(exposure);
					System.out.println(p.getExposures());
					break;
				}
				else {
					throw new IllegalArgumentException("patient ID passed is not valid...");
				}
			}
		}
	}	
	@Override
	public List<Disease> getDiseases() {
		// TODO Auto-generated method stub
		return diseases;
	}
	
	@Override
	public List<Patient> getPatients() {
		// TODO Auto-generated method stub
		return patients;
	}
	
	
}
