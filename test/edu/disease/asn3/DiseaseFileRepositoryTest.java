package edu.disease.asn3;

import java.util.Arrays;

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
		
		Disease d[]=dcm.getDiseases();
		Patient p[]=dcm.getPatients();
		
		dfr.init("d:/src");
		
		dfr.save(dcm.getDiseases(), dcm.getPatients());
		DiseaseAndPatient dap=dfr.init("d:/src");
		
		Disease[] d2=dap.getDiseases();
		Patient[] p2=dap.getPatients();
		
		assert Arrays.equals(d, d2);
		assert Arrays.equals(p, p2);}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
