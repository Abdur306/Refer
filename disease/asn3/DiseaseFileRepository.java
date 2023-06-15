package edu.disease.asn3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
 * The DiseaseFileRepository class is responsible for saving and initializing disease and patient data
 * using file-based storage. 
 */
public class DiseaseFileRepository {
	private String path;
	/**
	* Saves the array of diseases and patients to files.
	* @param diseases an array of Disease objects to be saved
    * @param patients an array of Patient objects to be saved
    */
	public void save(Disease diseases[], Patient patients[]) {
		
		FileOutputStream fos;
		try {
			File filepath1=new File(path+"/diseases.dat");
			fos = new FileOutputStream(filepath1);
			ObjectOutputStream oos = new ObjectOutputStream(fos);				
			oos.writeObject(diseases);
			
			File filepath2=new File(path+"/patients.dat");
			FileOutputStream fos2=new FileOutputStream(filepath2);
			ObjectOutputStream oos2=new ObjectOutputStream(fos2);		
			oos2.writeObject(patients);
		
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	/**
     * Initializes the repository by setting the folder path where the data files are stored
     *
     * @param folderPath the folder path where the data files are located
     * @return a  DiseaseAndPatient object containing the initialized diseases and patients
     * @throws IllegalArgumentException if the folderPath is null
     */
	public DiseaseAndPatient init(String folderpath) {
		if(folderpath==null) {
			throw new IllegalArgumentException();
		}
		this.path=folderpath;
		DiseaseAndPatient dap=new DiseaseAndPatient();
		Disease diseases[]=null;
		Patient patients[]=null;
		
		try {
			File filepath1=new File(path+"/diseases.dat");
			if(filepath1.exists()) {
				FileInputStream fis = new FileInputStream(filepath1);
				ObjectInputStream ois = new ObjectInputStream(fis);				
				diseases=(Disease[])ois.readObject();		
			}
					
			File filepath2=new File(path+"/patients.dat");
			if(filepath2.exists()) {
				FileInputStream fis2=new FileInputStream(filepath2);
				ObjectInputStream ois2=new ObjectInputStream(fis2);		
				patients=(Patient[])ois2.readObject();
			}
			
			dap.setDiseases(diseases);
			dap.setPatients(patients);
			return dap;
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}
	}
	
	
}
