package edu.disease.asn3;
/**
 * This class represents an infectious disease, which is a subclass of the Disease class.
 */
public class InfectiousDisease extends Disease{
	/**
     * @return An array of strings containing examples of infectious diseases.
     */	
@Override
public String[] getExamples() {

	String[] infectionsDiseses=new String[4];
	
	infectionsDiseses[0]="hepatitis";
	infectionsDiseses[1]="cholera";
	infectionsDiseses[2]="corona virus";
	infectionsDiseses[3]="conjunctivitis";
	return infectionsDiseses;
}
}
