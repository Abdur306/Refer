package edu.disease.asn6;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.ArrayList;

/**
 *The compareTo() method compares the last names of the two patients. 
 *If the last names are different, the method returns the difference between the last names. 
 *If the last names are equal, the method returns the difference between the first names. 
 *This allows the Patient class to be sorted by last name and first name.
 */
public class Patient implements Comparable<Patient>, Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public Patient() {

	}
	@Override
	public int compareTo(Patient o) {
		int lastNameComparison=0;
		if (this.lastName == null && o.lastName == null) {
            return 0; // Both names are null, consider them equal
        } else if (this.lastName == null) {
            return -1; // The current object's name is null, consider it less than other
        } else if (o.lastName == null) {
            return 1; // The other object's name is null, consider it less than the current object
        } else {
            // Compare the names with case sensitivity
        	lastNameComparison = this.lastName.toLowerCase().compareTo(o.lastName.toLowerCase());
        }
		
        if (lastNameComparison != 0) {
            return lastNameComparison; // If last names are different, return the result
        } else {
        	if(this.firstName!=null && o.lastName!=null) {
        		return this.firstName.toLowerCase().compareTo(o.lastName.toLowerCase()); // If last names are equal, compare first names
        	}
        	else {
        		return lastNameComparison;
        	}
        }
	}
	
    // Unique Id of Patient
    private UUID patientId;

    // First Name of Patient
    private String firstName;

    // Last Name of Patient
    private String lastName;

    /**
     * Intialize an array of {@link Exposure}
     */
    private List<Exposure> exposures;

    // Intialize an array of UUID
    private List<UUID> diseaseIds;

    /**
     * Constructs a new {@link Patient}.
     *
     * @param maxDiseases  Accepts argument maxDiseases which is an integer
     * @param maxExposures Accepts argument maxExposures which is an integer
     * @throws IllegalArgumentException if maxDiseases is not an instance of int
     *                                  if maxExposures is not an instance of int
     */
    public Patient(int maxDiseases, int maxExposures) throws IllegalArgumentException {
        if (maxDiseases > 0 &&  maxExposures > 0) {
        	//this.diseaseIds = new UUID[maxDiseases];
        	diseaseIds=new ArrayList<UUID>(maxDiseases);
        	
            //this.exposures = new Exposure[maxExposures];
        	exposures=new ArrayList<Exposure>(maxExposures);
        } else {
        	throw new IllegalArgumentException("maxDiseases/maxExposure cannot be less Zero , as it is not able to intialize size");
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
    //	boolean checkIndex = false;
 //   	for(int i = 0; i < diseaseIds.size(); i++){
 //   	    if(diseaseIds.get(i) == null){
    	    	diseaseIds.add(diseaseId);
    	    	//checkIndex = true;
 //   	    	break;
 //   	    }
    	}
//    	if(checkIndex == false){
//    	    System.out.println("Array is full");
//            throw new IndexOutOfBoundsException("Not able to insert the element to an array , as size is not available");
//    	}
//    }

    /**
     * Adds element of  {@link Exposure} to Exposures Array
     *
     * @param exposureObj  Accepts argument exposure which is an instance {@link Exposure}
     * @throws IndexOutOfBoundsException if size of element is overflow to insert to array it throws index out of bound exception
     *
     */
    public void addExposure(Exposure exposureObj) {
    	boolean checkIndex = false;
 //   	for(int i = 0; i < exposures.size(); i++){
 //   	    if(exposures.get(i) == null){
    	    	exposures.add(exposureObj);
    	    	//checkIndex = true;
 //   	    	break;
 //   	    }
    	}
//    	if(checkIndex == false){
//    	    System.out.println("Array is full");
//            throw new IndexOutOfBoundsException("Not able to insert the element to an array , as size is not available");
//    	}
//    }
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
    public List<Exposure> getExposures() {
        return exposures;
    }

    /**
     * @param exposures set the Exposure {@link Exposure}
     */
    public void setExposures(List<Exposure> exposures) {
        this.exposures = exposures;
    }

    /**
     * Returns All diseaseIds present in array
     *
     * @return diseaseIds
     */
    public List<UUID> getDiseaseIds() {
        return diseaseIds;
    }

    /**
     * @param diseaseIds set the diseaseIds
     */
    public void setDiseaseIds(List<UUID> diseaseIds) {
        this.diseaseIds = diseaseIds;
    }

    /**
     * @param o It accepts Object as a parameter
     * @return boolean true only when both references that are pointing to same object
     *         Multiple invocations of it, should return same result, unless any of the object properties is modified that is being used in the equals() method implementation.
     */
 
	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", exposures=" + exposures + ", diseaseIds=" + diseaseIds + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(diseaseIds, exposures, firstName, lastName, patientId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		return Objects.equals(diseaseIds, other.diseaseIds) && Objects.equals(exposures, other.exposures)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(patientId, other.patientId);
	}

	
    /**
     * @return hash value which is unique to compare Objects here uniqueness is on patientId
     */
    
    
//    public static void main(String[] args) {
//    	        Patient obj1 = new Patient();
//    	        obj1.setFirstName("Joe");obj1.setLastName("Smith");
//    	        Patient obj2 = new Patient();
//    	        obj2.setFirstName("andy");obj2.setLastName("smith");
//    	        Patient obj3 = new Patient();
//    	        obj3.setFirstName("anand");obj3.setLastName("babu");
////    	        Patient obj4 = new Patient();
////    	        obj4.setFirstName("babu");obj4.setLastName("maha");
//    	        
//    	        // Create an array of objects in an unsorted order
//    	        Patient[] unsortedArray = {obj1, obj2, obj3};//, obj3,obj4};
//
//    	        // Sort the array
//    	        Arrays.sort(unsortedArray);
//    	        
//    	        System.out.println(unsortedArray[0]);
//    	        System.out.println(unsortedArray[1]);
//    	        System.out.println(unsortedArray[2]);
//
//	}
}
