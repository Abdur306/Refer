package edu.disease.asn6;

import static org.junit.Assert.assertArrayEquals;

import java.util.List;

import org.junit.Test;

public class DiseaseFileRepositoryTest {
	
	@Test(expected=IllegalArgumentException.class)
	public void testNullPath() {
		DiseaseFileRepository dfr=new DiseaseFileRepository();
		dfr.init(null);
	}
	
	@Test
	public void testSaveMethod() {
		try {
		DiseaseFileRepository dfr=new DiseaseFileRepository();
		
		DiseaseControlManager dcm=new DiseaseControlManagerImpl(2,2);
		dcm.addPatient("anil", "sunil", 2, 1);
		dcm.addPatient("abhi", "subhi", 2, 1);
		dcm.addDisease("ds1", false);
		dcm.addDisease("dcm2", false);
		
		List<Disease> d=dcm.getDiseases();
		List<Patient> p=dcm.getPatients();
		
		dfr.init("d:/src");
		
		dfr.save(dcm.getDiseases(), dcm.getPatients());
		DiseaseAndPatient dap=dfr.init("d:/src");
		
		List<Disease> d2=dap.getDiseases();
		List<Patient> p2=dap.getPatients();
		
		assertArrayEquals(d.toArray(), d2.toArray());
		assertArrayEquals(p.toArray(), p2.toArray());}
		catch(Exception e) {
			
		}
	}
		
	}
	
	

