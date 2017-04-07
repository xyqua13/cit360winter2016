package finalProject;

import java.sql.Date;
import java.util.HashMap;

import antlr.collections.List;

public class viewPackagesHandler implements Handler{

	@Override
	public HashMap<String, Object> handleIt(HashMap<String, Object> data) {
		HashMap<String, Object> theObj = new HashMap<String, Object>();
		System.out.println("Packages Viewed");
		Date today = new Date(0);
		
		
		if(data.get("uid").toString().compareTo("1123")==0){
			singlePackage aPackage = new singlePackage();
			aPackage.setId(1111);
			aPackage.setArrivalDateTime(today);
			aPackage.setCarrier("UPS");
			aPackage.setDetails("None");
			//List<singlePackage> allPackages = new List<singlePackage>();
			singlePackage[] allPackages = new singlePackage[1];
			allPackages[0]=aPackage;
			
			theObj.put("response", "pass");
			//get server response
			for(int i = 0; i < allPackages.length;i++){
				theObj.put("package"+(i+1), allPackages[i]);
			}
		}else{theObj.put("response", "fail");}
		return theObj;
	} 


}
