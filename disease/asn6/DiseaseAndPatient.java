package edu.disease.asn6;

import java.util.List;

public class DiseaseAndPatient {
	private List<Disease> diseases;
	
	private List<Patient> patients;

	/**
	 * @return the diseases
	 */
	public List<Disease> getDiseases() {
		return diseases;
	}

	/**
	 * @param diseases the diseases to set
	 */
	public void setDiseases(List<Disease> diseases) {
		this.diseases = diseases;
	}

	/**
	 * @return the patients
	 */
	public List<Patient> getPatients() {
		return patients;
	}

	/**
	 * @param patients the patients to set
	 */
	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}


	
	
}
