package edu.disease.asn3;

import java.util.UUID;
/**
The DiseaseControlManagerImpl class implements the DiseaseControlManager interface.
*/

public class DiseaseControlManagerImpl implements DiseaseControlManager{
	private Disease[] diseases;
	private Patient[] patients;
	
	/**
	@throws IllegalArgumentException if maxDisease or maxPatients is less than or equal to 0.
	*/
	public DiseaseControlManagerImpl(int maxDisease,int maxPatients) {
		if(maxDisease<=0 || maxPatients<=0){
			throw new IllegalArgumentException("the arguments passed are not valid..pass value greater than zero.");
		}
		else {
			diseases=new Disease[maxDisease];
			patients=new Patient[maxPatients];
		}
	}
	
	int diseasecount=0;
	int patientcount=0;
	/**
	@throws IllegalStateException if the maximum limit for adding diseases has been reached.
	*/
	@Override
	public Disease addDisease(String name, boolean infectious) {

		
		if(diseases.length>diseasecount) {
			if(infectious) {
				Disease d=new InfectiousDisease();
				d.setName(name);
				d.setDiseaseId(UUID.randomUUID());
				diseases[diseasecount]=d;
				diseasecount++;
			}
			else
			{
				Disease d=new NonInfectiousDisease();
				d.setName(name);
				d.setDiseaseId(UUID.randomUUID());
				diseases[diseasecount]=d;
				diseasecount++;
			}
		}
		else {
				throw new IllegalStateException("maximum limit reached for adding diseases");
			}
		return diseases[diseasecount-1];
	}
	

	@Override
	public Disease getDisease(UUID dieseaseId) {		
		for(Disease d:diseases) {
			if(d!=null) {
			if(d.getDiseaseId()==dieseaseId) {
				return d;
			}
			break;
			}else {
				throw new IllegalStateException("there are no diseases in the diseases array...");
			}
		}
				return null;
	}
	/**
	* @throws IllegalStateException if the maximum limit for adding patients has been reached.
    */

	@Override
	public Patient addPatient(String firstName, String lastName, int maxDiseases, int maxExposures) {
		
		if(patients.length>patientcount) {
			Patient p=new Patient(maxDiseases,maxExposures);
			p.setFirstName(firstName);
			p.setLastName(lastName);
			p.setPatientId(UUID.randomUUID());
			patients[patientcount]=p;
			patientcount++;
		}
		else {
			throw new IllegalStateException("maximum limit reached for adding patients");
		}
		return patients[patientcount-1];

	}

	@Override
	public Patient getPatient(UUID patientId) {
				for(Patient p:patients) {
					if(p!=null) {	
						if(p.getPatientId()==patientId) {
							return p;
						}
						break;
					}else {
						throw new IllegalStateException("there are no patients in the patients array");
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

		
		for(Patient p:patients) {
			if(p!=null) {	
				if(p.getPatientId()==patientId) {
					patient=p;
					break;
				}
				else {
					throw new IllegalArgumentException("patient ID passed is not valid");
				}
			}else {
				throw new IllegalArgumentException("there are not patients in the patient array");
			}
		}
		
		
		for(Disease d:diseases) {
			if(d!=null) {
				if(d.getDiseaseId()==diseaseId) {
					disease=d;
					break;
				}
				else {
					throw new IllegalArgumentException("disease ID passed is not valid");
				}
			}else {
				throw new IllegalArgumentException("there are no diseases in the diseases array");
			}
		}
		
		
		patient.addDiseaseId(disease.getDiseaseId());
	}
	/**
	* @throws IllegalArgumentException if the patientId is invalid.
    */

	@Override
	public void addExposureToPatient(UUID patientId, Exposure exposure) {
		for(Patient p:patients) {
			if(p!=null) {
				if(p.getPatientId()==patientId) {
					p.addExposure(exposure);
					break;
				}
				else {
					throw new IllegalArgumentException("patient ID passed is not valid...");
				}
			}else {
				throw new IllegalArgumentException("there are no patients in the patients array");
			}
		}
	}


	@Override
	public Disease[] getDiseases() {

		return diseases;
	}


	@Override
	public Patient[] getPatients() {

		return patients;
	}
	
}
