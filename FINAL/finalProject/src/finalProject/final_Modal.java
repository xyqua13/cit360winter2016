package finalProject;

import java.util.HashMap;
import java.util.Map;

public class final_Modal {
	singlePackage aPackage = new singlePackage();
	private HashMap<String, Object> localStorageMap = new HashMap<String, Object>();
	public HashMap<String, Object> getSinglePackage(String data){
		HashMap<String, Object> returnData = new HashMap<String, Object>();
		returnData.put(data, localStorageMap.get(data));
		return returnData;
	}
	public HashMap<String, Object> getAllPackages(){
		return localStorageMap;
	}

	public void addPackages(HashMap<String, Object> holdHashMap) {
		localStorageMap.putAll(holdHashMap);//takes all the data and merges it into the local storage
		
	}
	
}
