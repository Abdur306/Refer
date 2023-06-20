package edu.disease.asn3;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Arrays;
import java.util.UUID;

import org.junit.Test;


public class DiseaseControlManagerTest {
	//Test cases for new methods added in DiseaseControlManager
	
		@Test(expected = IllegalStateException.class)
		public void testAddDisease1() {
			DiseaseControlManager dcm=new DiseaseControlManagerImpl(2,2);
			dcm.addDisease("ds1", true);
			dcm.addDisease("dcm2", false);
			dcm.addDisease("dc3", true);	
		}
		
		@Test
		public void testGetDiseaseForNull() {
			DiseaseControlManager dcm=new DiseaseControlManagerImpl(2,2);
			dcm.addDisease("d1", false);
			//System.out.println(UUID.randomUUID());
			assertNull(dcm.getDisease(UUID.randomUUID()));
		}
		
		@Test
		public void testGetDiseaseFromID() {
			DiseaseControlManager dcm=new DiseaseControlManagerImpl(2,2);
			dcm.addDisease("d1", false);
			assertNull(dcm.getDisease(UUID.randomUUID()));
		}
		
		@Test
		public void testGetDiseaseForNotNull() {
			DiseaseControlManager dcm=new DiseaseControlManagerImpl(2,2);
			Disease d=dcm.addDisease("d1", false);
			
			assertEquals(d, dcm.getDisease(d.getDiseaseId()));
		}
		
		@Test(expected=IllegalStateException.class)
		public void testAddPatientForISE() {
			DiseaseControlManager dcm=new DiseaseControlManagerImpl(2,2);
			dcm.addPatient("anil", "sunil", 2, 1);
			dcm.addPatient("abhi", "subhi", 2, 1);
			dcm.addPatient("kuku", "sukku", 2, 1);
		}
		
		@Test
		public void testAddPatient() {
			DiseaseControlManager dcm=new DiseaseControlManagerImpl(2,2);
			assertNotNull(dcm.addPatient("anil", "sunil", 2, 1));
			
		}
		
		@Test
		public void testAddDisease() {
			DiseaseControlManager dcm=new DiseaseControlManagerImpl(2,2);
			assertNotNull(dcm.addDisease("ddd", false));
		}
		
		
		
		@Test
		public void testGetPatientForNull() {
			DiseaseControlManager dcm=new DiseaseControlManagerImpl(2,2);
			dcm.addPatient("anil", "sunil", 2, 1);
			//System.out.println(UUID.randomUUID());
			assertNull(dcm.getPatient(UUID.randomUUID()));
		}
		
		@Test
		public void testGetPatientForNotNull() {
			DiseaseControlManager dcm=new DiseaseControlManagerImpl(2,2);
			Patient p=dcm.addPatient("anil", "sunil", 2, 1);
		
			//System.out.println(UUID.randomUUID());
			assertEquals(p, dcm.getPatient(p.getPatientId()));
			
		}
		
		@Test
		public void testAddDiseaseToPatientForNotNull() {
			DiseaseControlManager dcm=new DiseaseControlManagerImpl(2,2);
			Patient p1=dcm.addPatient("anil", "sunil", 2, 1);
			
			Disease d1=dcm.addDisease("ds1", false);
	
			dcm.addDiseaseToPatient(p1.getPatientId(),d1.getDiseaseId());
			UUID dObjUUID=p1.getDiseaseIds()[0];
			
			assertEquals(d1.getDiseaseId(),dObjUUID);
		}
		
		@Test(expected=IllegalArgumentException.class)
		public void testAddDiseaseToPatientForNull() {
			DiseaseControlManager dcm=new DiseaseControlManagerImpl(2,2);
			Patient p=dcm.addPatient("anil", "sunil", 2, 1);
			dcm.addPatient("abhi", "subhi", 2, 1);
			dcm.addDisease("ds1", false);
			dcm.addDisease("dcm2", false);
			dcm.addDiseaseToPatient(p.getPatientId(), UUID.randomUUID());
		}
		
		@Test(expected=IllegalArgumentException.class)
		public void testAddDiseaseToPatientForNull2() {
			DiseaseControlManager dcm=new DiseaseControlManagerImpl(2,2);
			dcm.addPatient("anil", "sunil", 2, 1);
			dcm.addPatient("abhi", "subhi", 2, 1);
			Disease d1=dcm.addDisease("ds1", false);
			dcm.addDisease("dcm2", false);
			dcm.addDiseaseToPatient(UUID.randomUUID(), d1.getDiseaseId());
		}
		
		@Test(expected=IllegalArgumentException.class)
		public void testAddExposureToPatientForNull() {
			DiseaseControlManager dcm=new DiseaseControlManagerImpl(2,2);
			dcm.addPatient("anil", "sunil", 2, 1);
			dcm.addPatient("abhi", "subhi", 2, 1);
			dcm.addDisease("ds1", false);
			dcm.addDisease("dcm2", false);
			dcm.addExposureToPatient(UUID.randomUUID(), new Exposure(UUID.randomUUID()));
		}
		
		@Test
		public void testAddExposureToPatientForNotNull() {
			DiseaseControlManager dcm=new DiseaseControlManagerImpl(2,2);
			Patient p1=dcm.addPatient("anil", "sunil", 2, 1);
			
			Exposure ex=new Exposure(p1.getPatientId());
			dcm.addExposureToPatient(p1.getPatientId(), ex);
		
			Exposure e=p1.getExposures()[0];
			
			assertEquals(e.getPatientId(),p1.getPatientId());
		}
		
		@Test(expected=IllegalArgumentException.class)
		public void testConstructor() {
			DiseaseControlManager dcm=new DiseaseControlManagerImpl(0,0);
		}
	
		@Test
		public void testGetDiseases() {
			DiseaseControlManager dcm=new DiseaseControlManagerImpl(2,2);
			
			Disease d1=dcm.addDisease("ds1", false);
			Disease d2=dcm.addDisease("dcm2", false);
			Disease[] diseases= {d1,d2};
			
			Disease[] diseases2=dcm.getDiseases();
			
			assert Arrays.equals(diseases, diseases2); 
		}
		
		@Test
		public void testGetPatients() {
			DiseaseControlManager dcm=new DiseaseControlManagerImpl(2,2);
			Patient p1=dcm.addPatient("anil", "sunil", 2, 1);
			Patient p2=dcm.addPatient("abhi", "subhi", 2, 1);
			
			Patient[] patients= {p1,p2};
			
			Patient[] patients2=dcm.getPatients();
			
			assert Arrays.equals(patients, patients2); 

		}
}
