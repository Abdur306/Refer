package edu.disease.asn2;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;


public class Exposure {

    // Unique Identifier to identify a Patient
    private UUID patientId;

    // Local Date Time of particular patient
    private LocalDateTime dateTime;

    // Type of Exposure of the disease either Direct or Indirect i.e (D/I)
    private String exposureType;


    /**
     * Constructs a new {@link Exposure}.
     *
     * @param patientId
     *            Intialize {@link Exposure}. Class with Unique Identifier of a Patient
     */
    public Exposure(UUID patientId) {
        this.patientId = patientId;
    }

    /**
     * Returns patientId which is Universally Unique Identifier
     *
     * @return patientId
     */
    public UUID getPatientId() {
        return patientId;
    }


    /**
     * @param patientId set the Id of patient
     */
    public void setPatientId(UUID patientId) {
        this.patientId = patientId;
    }

    /**
     * Returns dateTime which is local date time zone
     *
     * @return dateTime
     */
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    /**
     * @param dateTime set the Local Date Time  of patient
     */
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * Returns type of exposure ( Direct or Indirect)
     *
     * @return exposureType
     */
    public String getExposureType() {
        return exposureType;
    }

    /**
     * @param exposureType Accepts String , it should contain only two values either D or I i.e D Indicates Direct Exposure
     *                     , I Indicates Indirect Exposure
     * @throws IllegalArgumentException If Exposure Type is other than D or I
     */
    public void setExposureType(String exposureType) {
        if ("D".equals(exposureType) || "I".equals(exposureType)) {
            this.exposureType = exposureType;
        } else {
            throw new IllegalArgumentException("Exposure Type Should be Either Direct or Indirect Exposure");
        }
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
        if (!(o instanceof Exposure)) return false;
        Exposure exposure = (Exposure) o;

	    return Objects.equals(patientId, exposure.patientId) &&
                Objects.equals(dateTime, exposure.dateTime);
    }

    /**
     * @return hash value which is unique to compare Objects here uniqueness is on patientId, dateTime
     */
    @Override
    public int hashCode() {
        return Objects.hash(patientId, dateTime);
    }

    /**
     * Print the Exposure Class Object values like PatientId,dateTime,exposureType
     * @return string with all values declared at class level
     */
    @Override
    public String toString() {
        return "Exposure{" +
                "patientId=" + patientId +
                ", dateTime=" + dateTime +
                ", exposureType='" + exposureType + '\'' +
                '}';
    }


}
