package edu.disease.asn6;

import java.time.LocalDateTime;
import java.util.Objects;

public class PatientZero {
	private Patient patient;
	private LocalDateTime exposureDateTime;
	private boolean exposed;
	/**
	 * @return the patient
	 */
	public Patient getPatient() {
		return patient;
	}
	/**
	 * @param patient the patient to set
	 */
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	/**
	 * @return the exposureDateTime
	 */
	public LocalDateTime getExposureDateTime() {
		return exposureDateTime;
	}
	/**
	 * @param exposureDateTime the exposureDateTime to set
	 */
	public void setExposureDateTime(LocalDateTime exposureDateTime) {
		this.exposureDateTime = exposureDateTime;
	}
	/**
	 * @return the exposed
	 */
	public boolean isExposed() {
		return exposed;
	}
	/**
	 * @param exposed the exposed to set
	 */
	public void setExposed(boolean exposed) {
		this.exposed = exposed;
	}
	@Override
	public String toString() {
		return "PatientZero [patient=" + patient + ", exposureDateTime=" + exposureDateTime + ", exposed=" + exposed
				+ "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(exposed, exposureDateTime, patient);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PatientZero other = (PatientZero) obj;
		return exposed == other.exposed && Objects.equals(exposureDateTime, other.exposureDateTime)
				&& Objects.equals(patient, other.patient);
	}
	
	
}
