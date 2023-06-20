package edu.disease.asn1;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

public class PatientTest {

	private Patient patient;
	
	private static final String FIRST_NAME = "firstName";
	
	private static final String LAST_NAME = "lastName";
	
	private Exposure exposure;
	
	@Before
	public void setUp() {
		final UUID uuid = UUID.randomUUID();
		exposure = new Exposure(uuid);
		exposure.setDateTime(LocalDateTime.now());
		exposure.setExposureType("D");
		patient = new Patient(1,1);
		patient.setDiseaseIds(new UUID[] {UUID.randomUUID(), UUID.randomUUID()});
		patient.setExposures(new Exposure[] {exposure});
		patient.setFirstName(FIRST_NAME);
		patient.setLastName(LAST_NAME);
		patient.setPatientId(uuid);
	}
	
	@Test
	public void testPatientPostiveScenario()
	{
		assertNotNull(patient.toString());
		assertNotNull(patient.getDiseaseIds());
		assertNotNull(patient.getExposures());
		assertNotNull(patient.getFirstName());
		assertNotNull(patient.getLastName());
		assertNotNull(patient.hashCode());
		assertNotNull(patient.getPatientId());
		final Patient patientObj = patient;
		assertTrue(patient.equals(patientObj));
		assertTrue(patient.equals(patient));
		assertFalse(patient.equals(null));
		final Patient patientObjEquals = new Patient(1,1);
		patientObjEquals.setPatientId(patient.getPatientId());
		assertTrue(patient.equals(patientObjEquals));
		
	}
	
	@Test
	public void testAddDisease()
	{
	    final Patient patientTest = new Patient(3,3);
	    patientTest.addDiseaseId(UUID.randomUUID());
	    patientTest.addDiseaseId(UUID.randomUUID());
	    patientTest.addDiseaseId(UUID.randomUUID());
	    System.out.println(patientTest.getDiseaseIds()[0]);
		assertEquals(3, patientTest.getDiseaseIds().length);
	}
	
	@Test
	public void testAddExposure()
	{
	    final Patient patientTest = new Patient(3,3);
	    patientTest.addExposure(exposure);
	    patientTest.addExposure(exposure);
	    patientTest.addExposure(exposure);
	    System.out.println(patientTest.getExposures()[0]);
		assertEquals(3, patientTest.getExposures().length);
	}
	
	
	@Test(expected = NoSuchElementException.class)
	public void testAddDiseaseException()
	{
		patient.addDiseaseId(UUID.randomUUID());
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testAddExposureException()
	{
		patient.addExposure(exposure);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testExceptionPatient()
	{
		Patient patientTest = new Patient(-1, -1); 
		
	}
}
