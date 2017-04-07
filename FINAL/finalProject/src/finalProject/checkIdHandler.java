package finalProject;

import java.util.HashMap;

public class checkIdHandler implements Handler{

	@Override
	public HashMap<String, Object> handleIt(HashMap<String, Object> data) {
		HashMap<String, Object> theObj = new HashMap<String, Object>();
		
		
		//checks server for ID
		boolean found = false;
		String id = data.get("uid").toString();
		if(id.compareTo("1123")==0){
			found=true;
		}
		if(found){
			theObj.put("response","true");
		}else{theObj.put("response","false");}
		return theObj;
	} 

}
