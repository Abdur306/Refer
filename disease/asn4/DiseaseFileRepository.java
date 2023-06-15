package edu.disease.asn4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DiseaseFileRepository {
	private String path;
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public DiseaseAndPatient init(String folderpath) {
		if(folderpath==null) {
			throw new IllegalArgumentException("the folder path is null...");
		}
		this.path=folderpath;
		DiseaseAndPatient dap=new DiseaseAndPatient();
		Disease diseases[]=null;
		Patient patients[]=null;
		
		
			File filepath1=new File(path+"/diseases.dat");
			if(filepath1.exists()) {
				try {
				FileInputStream fis = new FileInputStream(filepath1);
				ObjectInputStream ois = new ObjectInputStream(fis);				
				diseases=(Disease[])ois.readObject();
				}catch(Exception e) {}
			}
					
			File filepath2=new File(path+"/patients.dat");
			if(filepath2.exists()) {
				try {
				FileInputStream fis2=new FileInputStream(filepath2);
				ObjectInputStream ois2=new ObjectInputStream(fis2);		
				patients=(Patient[])ois2.readObject();
				}catch(Exception e) {
					
				}
			}
			
			dap.setDiseases(diseases);
			dap.setPatients(patients);
			return dap;
		
	}
	
	
}
