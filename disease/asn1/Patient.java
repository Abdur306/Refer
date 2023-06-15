package edu.disease.asn1;

import java.util.*;

/**
 * Stores the Data of Patient like Id, firstName, LastName, {@link Exposure}, diseaseIds
 */
public class Patient {

    // Unique Id of Patient
    private UUID patientId;

    // First Name of Patient
    private String firstName;

    // Last Name of Patient
    private String lastName;

    /**
     * Intialize an array of {@link Exposure}
     */
    private Exposure[] exposures;

    // Intialize an array of UUID
    private UUID[] diseaseIds;

    /**
     * Constructs a new {@link Patient}.
     *
     * @param maxDiseases  Accepts argument maxDiseases which is an integer
     * @param maxExposures Accepts argument maxExposures which is an integer
     * @throws IllegalArgumentException if maxDiseases is not an instance of int
     *                                  if maxExposures is not an instance of int
     */
    public Patient(int maxDiseases, int maxExposures) throws IllegalArgumentException {
        if (maxDiseases < 0 || maxExposures < 0) {
        	throw new IllegalArgumentException("maxDiseases/maxExposure cannot be less Zero , as it is not able to intialize size");
        } else {
            this.diseaseIds = new UUID[maxDiseases];
            this.exposures = new Exposure[maxExposures];
        }
    }

    /**
     * Adds element to DiseaseIds Array
     *
     * @param diseaseId  Accepts argument diseaseId which is an UUID
     * @throws IndexOutOfBoundsException if size of element is overflow to insert to array it throws index out of bound exception
     *
     */
    public void addDiseaseId(UUID diseaseId) {
    	boolean checkIndex = false;
    	for(int i = 0; i < diseaseIds.length-1; i++){
    	    if(diseaseIds[i] == null){
    	    	diseaseIds[i] = diseaseId;
    	    	checkIndex = true;
    	    	break;
    	    }
    	}
    	if(checkIndex == false){
    	    System.out.println("Array is full");
            throw new NoSuchElementException("Not able to insert the element to an array , as size is not available");
    	}
    }

    /**
     * Adds element of  {@link Exposure} to Exposures Array
     *
     * @param exposureObj  Accepts argument exposure which is an instance {@link Exposure}
     * @throws IndexOutOfBoundsException if size of element is overflow to insert to array it throws index out of bound exception
     *
     */
    public void addExposure(Exposure exposureObj) {
    	boolean checkIndex = false;
    	for(int i = 0; i < exposures.length; i++){
    	    if(exposures[i] == null){
    	    	exposures[i] = exposureObj;
    	    	checkIndex = true;
    	    	break;
    	    }
    	}
    	if(checkIndex == false){
    	    System.out.println("Array is full");
            throw new NoSuchElementException("Not able to insert the element to an array , as size is not available");
    	}
    }
    /**
     * Returns Unique Id of a Patient
     *
     * @return patientId
     */
    public UUID getPatientId() {
        return patientId;
    }

    /**
     * @param patientId set the UUID
     */
    public void setPatientId(UUID patientId) {
        this.patientId = patientId;
    }

    /**
     * Returns first name of the Patient
     *
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName set the firstName  of patient
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns last name of the Patient
     *
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName set the lastName  of patient
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns All Exposure Objects present in array
     *
     * @return exposures
     */
    public Exposure[] getExposures() {
        return exposures;
    }

    /**
     * @param exposures set the Exposure {@link Exposure}
     */
    public void setExposures(Exposure[] exposures) {
        this.exposures = exposures;
    }

    /**
     * Returns All diseaseIds present in array
     *
     * @return diseaseIds
     */
    public UUID[] getDiseaseIds() {
        return diseaseIds;
    }

    /**
     * @param diseaseIds set the diseaseIds
     */
    public void setDiseaseIds(UUID[] diseaseIds) {
        this.diseaseIds = diseaseIds;
    }

    /**
     * @param o It accepts Object as a parameter
     * @return boolean true only when both references that are pointing to same object
     *         Multiple invocations of it, should return same result, unless any of the object properties is modified that is being used in the equals() method implementation.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;
        Patient patient = (Patient) o;
        return patientId.equals(patient.patientId);
    }

    /**
     * @return hash value which is unique to compare Objects here uniqueness is on patientId
     */
    @Override
    public int hashCode() {
        return Objects.hash(patientId);
    }

    /**
     * Print the Patient Class Object values like PatientId,firstName,lastName,Expsoures, DiseaseIds
     * @return string with all values declared at class level
     */
    @Override
    public String toString() {
        return "Patient{" +
                "patientId=" + patientId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", exposures=" + Arrays.toString(exposures) +
                ", diseaseIds=" + Arrays.toString(diseaseIds) +
                '}';
    }
}
