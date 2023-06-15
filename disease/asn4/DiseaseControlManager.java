package edu.disease.asn4;

import java.util.UUID;

public interface DiseaseControlManager {

    /**
     * Adds a new disease 
     *
     * @param name The name of the disease
     * @param infectious Whether the disease is infectious or not
     * @return The newly created disease
     */
    Disease addDisease(String name, boolean infectious);

    /**
     * Gets a disease by its ID
     *
     * @param diseaseId - The ID of the disease.
     * @return The disease with the specified ID, or null if nothing exists
     */
    Disease getDisease(UUID diseaseId);

    /**
     * Adds a new patient
     *
     * @param firstName The patient's first name
     * @param lastName The patient's last name
     * @param maxDiseases The maximum number of diseases that the patient can have
     * @param maxExposures The maximum number of exposures that the patient can have
     * @return The newly created patient
     */
    Patient addPatient(String firstName, String lastName, int maxDiseases, int maxExposures);

    /**
     * Gets a patient by its ID
     *
     * @param patientId The ID of the patient.
     * @return The patient with the specified ID, or null if no such patient exists.
     */
    Patient getPatient(UUID patientId);

    /**
     * Adds a disease to a patient
     *
     * @param patientId The ID of the patient.
     * @param diseaseId The ID of the disease.
     */
    void addDiseaseToPatient(UUID patientId, UUID diseaseId);

    /**
     * Adds an exposure to a patient
     *
     * @param patientId The ID of the patient.
     * @param exposure The exposure to add.
     */
    void addExposureToPatient(UUID patientId, Exposure exposure);

    Disease[] getDiseases() ;
    
    Patient[] getPatients();
    
    
}