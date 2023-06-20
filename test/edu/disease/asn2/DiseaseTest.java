package edu.disease.asn2;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.UUID;

import org.junit.Test;

public class DiseaseTest {
	@Test
	public void testInfectiousDiseases() {
		Disease d=new InfectiousDisease();		
		assertNotNull(d.getExamples());
	}
	
	@Test
	public void testNonInfectiousDiseases() {
		Disease d=new NonInfectiousDisease();
		assertNotNull(d.getExamples());
	}
	
	@Test
	public void testDiseasePostiveScenario()
	{
		Disease d=new InfectiousDisease();
		d.setName("dis");
		d.setDiseaseId(UUID.randomUUID());
		assertNotNull(d.toString());
		assertNotNull(d.getDiseaseId());
		assertNotNull(d.getExamples());
		assertNotNull(d.getName());
		assertNotNull(d.hashCode());
		assertTrue(d.equals(d));
		final Disease dObj = d;
		assertTrue(d.equals(d));
		assertTrue(d.equals(d));
		assertTrue(d.equals(d));
				
		assertFalse(d.equals(null));
		final Disease dObjEquals = new InfectiousDisease();
		dObjEquals.setDiseaseId(d.getDiseaseId());
		assertTrue(d.equals(dObjEquals));
		
	}
}
