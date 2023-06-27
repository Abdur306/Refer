package edu.disease.asn6;

import static org.junit.Assert.assertArrayEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
//EXPLANATION: Arrays have size limitation but collection dont have a size limitation and more over they have plenty of user defined methods
/**
 * 
 * @author Hp
 * This class primarily serializes the patients and diseases collections to a DAT file for later reference.
 *
 */
public class DiseaseFileRepository {
	private String path;
	public void save(List<Disease> diseases, List<Patient> patients) {
		
		FileOutputStream fos;
		try {
			File filepath1=new File(path+"/diseases.dat");
			fos = new FileOutputStream(filepath1);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			try {
				oos.writeObject(diseases);
			}catch(Exception ex) {
				ex.printStackTrace();
				try {
					fos.close();
					oos.close();
				}catch(Exception exx) {
					exx.printStackTrace();
				}
			}
			
			File filepath2=new File(path+"/patients.dat");
			FileOutputStream fos2=new FileOutputStream(filepath2);
			ObjectOutputStream oos2=new ObjectOutputStream(fos2);
			try {
	
				oos2.writeObject(patients);
			}catch(Exception ex) {
				ex.printStackTrace();
				try {
					fos2.close();
					oos2.close();
				}catch(Exception exx) {
					exx.printStackTrace();
				}
			}
			
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public DiseaseAndPatient init(String folderpath) {
		if(folderpath==null) {
			throw new IllegalArgumentException("folder path cannot be null...");
		}
		this.path=folderpath;
		DiseaseAndPatient dap=new DiseaseAndPatient();
		List<Disease> diseases=new ArrayList<Disease>();
		List<Patient> patients=new ArrayList<Patient>();
		
		
			File filepath1=new File(path+"/diseases.dat");
			if(filepath1.exists()) {
				try {
				FileInputStream fis = new FileInputStream(filepath1);
				ObjectInputStream ois = new ObjectInputStream(fis);
				try {
				diseases=(List<Disease>)ois.readObject();
				}catch(Exception e) {
					try{
						fis.close();
						ois.close();}catch(Exception ex) {
							ex.printStackTrace();
						}
					}
				}catch(Exception exx) {
					exx.printStackTrace();
				}
			}
					
			File filepath2=new File(path+"/patients.dat");
			if(filepath2.exists()) {
				try {
				FileInputStream fis2=new FileInputStream(filepath2);
				ObjectInputStream ois2=new ObjectInputStream(fis2);	
				try {
					patients=(List<Patient>)ois2.readObject();
				}catch(Exception ex) {
					ex.printStackTrace();
					try {
						ois2.close();
						fis2.close();
					}catch(Exception exx) {
						exx.printStackTrace();
					}
				}
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			
			dap.setDiseases(diseases);
			dap.setPatients(patients);
			return dap;
		
	}
	
	
}
