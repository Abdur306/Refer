package edu.disease.asn2;

public class NonInfectiousDisease extends Disease{
	/**
     * @return An array of strings containing examples of Non-infectious diseases.
     */	
@Override
public String[] getExamples() {

	String[] noninfectionsDiseses=new String[4];
	
	noninfectionsDiseses[0]="diabetes";
	noninfectionsDiseses[1]="cancer";
	noninfectionsDiseses[2]="Cardiovascular";
	noninfectionsDiseses[3]="Mental health Problems";
	return noninfectionsDiseses;
	}
}
