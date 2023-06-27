package edu.disease.asn6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.junit.Test;

public class ContactTraceTest {

	@Test
	public void testFindPatientZero() {
		DiseaseControlManager dcm=new DiseaseControlManagerImpl(4,4);
		Patient p1=dcm.addPatient("anil", "sunil", 2, 1);
		Exposure ex1=new Exposure(p1.getPatientId());
		ex1.setDateTime(LocalDateTime.of(2020,5,20,10,30,0));
		ex1.setExposureType("D");
				
		Patient p2=dcm.addPatient("abhi", "subhi", 2, 1);
		Exposure ex2=new Exposure(p2.getPatientId());
		ex2.setDateTime(LocalDateTime.of(2023,5,21,10,30,0));
		ex2.setExposureType("D");
		
		Patient p3=dcm.addPatient("nisha", "subhi", 2, 1);
		Exposure ex3=new Exposure(p3.getPatientId());
		ex3.setDateTime(LocalDateTime.of(2022,4,21,10,30,0));
		ex3.setExposureType("D");
				
		p1.setExposures(Arrays.asList(ex2,ex1));
		p2.setExposures(Arrays.asList(ex3));
		p3.setExposures(Arrays.asList(ex2));
		
		ContactTrace ct=new ContactTrace(dcm);
		
		PatientZero pzero2=ct.findPatientZero(p3);
		
		PatientZero pzero1=new PatientZero();
		pzero1.setExposed(true);
		pzero1.setExposureDateTime(LocalDateTime.of(2020,5,20,10,30,0));
		pzero1.setPatient(p1);
		
		System.out.println(pzero1);
		System.out.println(pzero2);
		assertEquals(pzero1,pzero2);
	}
}

