package edu.disease.asn2;

import java.util.Objects;
import java.util.UUID;


public abstract class Disease {
	
	

    // UUID of patient
    private UUID diseaseId;

    // Name of disease
    private String name;

    /**
     * Returns id of the disease
     *
     * @return diseaseId
     */
    
    /**

     * @return an array of disease examples as strings.
     */
    public abstract String [] getExamples();
    
    public UUID getDiseaseId() {
        return diseaseId;
    }

    /**
     * @param diseaseId set the UUID of the disease
     */
    public void setDiseaseId(UUID diseaseId) {
        this.diseaseId = diseaseId;
    }

    /**
     * Returns Name of disease
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name set the disease name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param o It accepts Object as a parameter
     * @return boolean true only when both references that are pointing to same object
     *         Multiple invocations of it, should return same result, unless any of the object properties is modified that is being used in the equals() method implementation.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false; 
        if (!(o instanceof Disease)) return false;
        Disease disease = (Disease) o;

        return Objects.equals(diseaseId, disease.diseaseId);
    }

    /**
     * @return hash value which is unique to compare Objects here uniqueness is on patientId
     */
    @Override
    public int hashCode() {
        return Objects.hash(diseaseId);
    }

    /**
     * Print the Disease Class Object values like DiseaseId,Name
     * @return string with all values declared at class level
     */
    @Override
    public String toString() {
        return "Disease{" +
                "diseaseId=" + diseaseId +
                ", name='" + name + '\'' +
                '}';
    }
}
