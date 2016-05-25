package com.tessy;

import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import com.tessy.models.*;


public class ModulesScanner {

	public HashMap<String,String> TessyModule;
	public HashMap<Integer,Object> TessyModulesList;
	private Batchtest batchtest;
	private Elements elements;
	private Testcollection[] testcollections;
	private Folder[] folders;
	private Module[] modules;
	private Testobject[] testobjects;
	private int tc1_index;
	private int f1_index;
	private int m1_index;
	private boolean foundtsflag;
	private int ts1_index;
	
	public ModulesScanner() {
		// TODO Auto-generated constructor stub
		this.TessyModule = new HashMap<String, String>();
		batchtest = new Batchtest();
		elements = batchtest.getElements();
		testcollections = elements.getTestcollection();
	}

	
	static <T> T[] append_element(T[] arr, T element) {
	    final int N = arr.length;
	    arr = Arrays.copyOf(arr, N + 1);
	    arr[N] = element;
	    return arr;
	}
	
	static <T> T[] update_element(T[] arr, T element, int index) {
	    final int N = arr.length;
	    if(index >= N) {
	    	arr = append_element(arr,element);
	    } else {
	    	arr[index] = element;
	    }
	    return arr;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer,Object> MyList;
		ModulesScanner m1= new ModulesScanner();
		String FilePath = "./resources";
		MyList = m1.parse_tessy_backup(FilePath);
		System.out.println("Function End");
	}
	
	
    /**
    * Prepare Tessy-Backups Files in Passed Folder
    * @return boolean flag as an indication of successful operation
    * @param	Files	Folder    
    * @param 	includePaths	include paths to be scanned with the source file
    * @throws CoreException
    */	
	public HashMap<String,Object> write_xml_batch(HashMap<Integer,Object> ModulesList){
		
	    File file = new File(".\resources\batchtest.xml");
	    JAXBContext jaxbContext = JAXBContext.newInstance(Batchtest.class);
	    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	    
	    jaxbMarshaller.marshal(c, file);// this line create customer.xml file in specified path.
	    StringWriter sw = new StringWriter();
	    jaxbMarshaller.marshal(batchtest, sw);
	    String xmlString = sw.toString();
	    
	    System.out.println(xmlString);
	}
	
    /**
    * Prepare Tessy-Backups Files in Passed Folder
    * @return boolean flag as an indication of successful operation
    * @param	Files	Folder    
    * @param 	includePaths	include paths to be scanned with the source file
    * @throws CoreException
    */	
	public HashMap<String,Object> prepare_tessy_data_model(HashMap<Integer,Object> ModulesList){

		//
		Testcollection tc1 = null;
		Folder f1 = null;
		Module m1 = null;
		Testobject ts1 = null;
		boolean foundtcflag,foundfflag,foundmflag;
		
		for (int i=0; i<ModulesList.size(); i++) {
			HashMap<String, String> m = (HashMap<String, String>) ModulesList.get(i);
			
			String testcollectionname = m.get("testcollection");
			String foldername = m.get("foldername");
			String modulename = m.get("modulename");			
			
			foundtcflag = false;
			for(int j=0; i < testcollections.length; j++) {
				// search for
				if(testcollections[j].getName()== testcollectionname) {
					foundtcflag = true;
					tc1 = testcollections[j];
					tc1_index = j;
					break;
				}
				// if not foundflag
				if(!foundtcflag) {
					tc1 = new Testcollection();
					tc1.setName(testcollectionname);
					tc1_index = testcollections.length;
				}
			}
			
			foundfflag = false;
			// Get Folders Object for the current TestCollection
			folders = tc1.getFolder();
			for(int j=0; i < folders.length; j++) {
				// search for
				if(folders[j].getName()== foldername) {
					foundfflag = true;
					f1 = folders[j];
					f1_index = j;
					break;
				}
				// if not foundflag
				if(!foundfflag) {
					f1 = new Folder();
					f1.setName(foldername);
					f1_index = folders.length;
				}
			}
			
			foundmflag = false;
			// Get Folders Object for the current TestCollection
			modules = f1.getModule();
			for(int j=0; i < modules.length; j++) {
				// search for
				if(modules[j].getName()== modulename) {
					foundmflag = true;
					m1 = modules[j];
					m1_index = j;
					break;
				}
				// if not foundflag
				if(!foundmflag) {
					m1 = new Module();
					m1.setName(modulename);
					m1_index = modules.length;
				}
			}
			
			foundtsflag = false;
			// Get Folders Object for the current TestCollection
			testobjects = m1.getTestobject();
			for(int j=0; i < testobjects.length; j++) {
				// search for
				if(testobjects[j].getName()== modulename) {
					foundtsflag = true;
					ts1 = testobjects[j];
					ts1_index = j;
					break;
				}
				// if not foundflag
				if(!foundtsflag) {
					ts1 = new Testobject();
					ts1.setName(modulename);
					m1_index = modules.length;
				}
			}			
			
			// Update elements
			update_element(modules,m1,m1_index);
			update_element(folders,f1,f1_index);
			update_element(testcollections,tc1,tc1_index);
			
			// if not foundflag
			folders
			elements.setTestcollection(testcollections);
			
			

		}
		return null;
	}
	
    /**
    * Parse Tessy-Backups Files in Passed Folder
    * @return boolean flag as an indication of successful operation
    * @param	Files	Folder    
    * @param 	includePaths	include paths to be scanned with the source file
    * @throws CoreException
    */	
	public HashMap<Integer,Object> parse_tessy_backup(String folderpath) throws EmptyStackException {

		// List of mocked-files
		this.TessyModulesList = new HashMap<Integer, Object>();
		File folder = new File(folderpath);
		
		//Check that folder exists
		if(!folder.isDirectory()) {
			System.err.println("Not ");
			throw new EmptyStackException();
		}
		
		// get list of files
		File[] files = folder.listFiles();

		System.out.println(">>>>>>>>> Parsing Files in Folder:" + folderpath);
		for (File file : files) {
		    if (file.isFile()) {
		        // Mock only C-Files
		        if(file.getName().endsWith(".tmb")) {
		        	// Create Mock Prepressor
		        	String pattern = "(.*)\\.(.*)\\.(.*)\\%.*\\.tmb";
					Pattern p = Pattern.compile(pattern);
					Matcher m = p.matcher(file.getName());
					
					if (m.find( )) {
						if(m.groupCount()==3) {
				        	TessyModule.put("testcollection", m.group(1));
				        	TessyModule.put("foldername", m.group(2));
				        	TessyModule.put("modulename", m.group(3));
				        	// Push to List
				        	TessyModulesList.put(TessyModulesList.size()+1, TessyModule);
						} else if (m.groupCount()>3) {
							//TODO: not currently supported
						} else {
							//TODO: not currently supported
							System.err.println("Files-Names do not match the pre-specified Pattern: " + pattern);
						}
						System.out.println("Found value: " + m.group(1) );
						System.out.println("Found value: " + m.group(2) );
						System.out.println("Found value: " + m.group(3) );
					} else {
						System.out.println("NO MATCH");
					}					
					boolean b = m.matches();		        	
		        	//MyCMocker.CreateMockPrepressor(file.getAbsolutePath(), includePaths);
		        }
		    }
		}
		return TessyModulesList;
	}	

}
