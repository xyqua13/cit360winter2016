package finalProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.net.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.quickconnectfamily.json.JSONException;
import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;
import org.quickconnectfamily.json.JSONParser;
import org.quickconnectfamily.json.JSONUtilities;
import org.quickconnectfamily.json.ParseException;

public class final_Control {
	public static void main(String[] args) throws IOException, InterruptedException{
		//variables
		boolean quit = false;
		singlePackage holdPackage = new singlePackage();
		final_View view = new final_View();
		final_Modal modal = new final_Modal();
		int currentUserId = -1;
		int userMenuSelect=-1;
		String stringedId = "";
		int randomID = -1;
		boolean validId= false;
		int packageId=-1;
		String packageCarrier="";
		
		//set up application controller
		HashMap<String,Object> holdHashMap= new HashMap<String,Object>();//holdHashMap for commands
		commandManager controller = new commandManager();
		saveHandler save = new saveHandler();
		addPackageHandler addPackage = new addPackageHandler();
		viewPackagesHandler viewPackages = new viewPackagesHandler();
		checkIdHandler checkId = new checkIdHandler();
		loadSaveHandler loadSave = new loadSaveHandler();
		controller.mapCommand("save", save);
		controller.mapCommand("add", addPackage);
		controller.mapCommand("view", viewPackages);
		controller.mapCommand("check", checkId);
		controller.mapCommand("loadSave", loadSave);
		
		view.printMessage("Welcome to the package tracker.\nEnter your User ID(Enter 0000 for new user):");
		userMenuSelect = view.getInputInt();
		while(!quit){
			if(currentUserId==-1)//user logged in
			{//user signin process
				if(userMenuSelect==0){//if 0000 entered creates id
					randomID = (int)(Math.random()*9000)+1000;
					stringedId=Integer.toString(randomID);
					if(randomID<1000){
						stringedId="0"+stringedId;
					}
					currentUserId=Integer.parseInt(stringedId);
					view.printMessage("Welcome User: "+currentUserId+"\n");
				}else{
					//checks server for ID
					//checks for saved file
					stringedId= Integer.toString(userMenuSelect);
					holdHashMap.put("uid", stringedId);//loads the user id into the hashmap to be checked
					holdHashMap = controller.handleRequest("check",holdHashMap);//checks for ID in database 
					if(holdHashMap.get("response").toString().compareTo("false")==0){//reads teh response message. If it is false it will prompt for a valid login
						view.printMessage("ID not found.\nEnter User ID(Enter 0000 for new user):");
						userMenuSelect = view.getInputInt();//gets input to start loop over again
					}else if(holdHashMap.get("response").toString().compareTo("true")==0){
						//If it does find the correct response it checks for 
						//if it will create a file and save it for future use.
						currentUserId=userMenuSelect;//sets ID
						validId=true;
						File savedFile = new File("packageApp_"+stringedId+".json");
						if(!savedFile.exists()){//File exists, reads in file and saves it to local storage
							view.printMessageNewLine("Creating New File");
							holdHashMap.clear();
							holdHashMap.put("uid", stringedId);
							//Get Data from Server
							holdHashMap = controller.handleRequest("view",holdHashMap);
							holdHashMap.put("uid", stringedId);
							holdHashMap.remove("response");
							controller.handleRequest("save", holdHashMap);
							//controller.handleRequest("check",holdHashMap);
						}else{
							holdHashMap.clear();
							holdHashMap.put("uid", stringedId);
							view.printMessageNewLine("Loading File");
							holdHashMap = controller.handleRequest("loadSave", holdHashMap);//loads the saved json file
							modal.addPackages(holdHashMap);//saves data local
							view.printMessageNewLine("File loaded successfully.");
						}
					}else{System.out.println("ERROR");}
				}
			}//if signed in
			if(currentUserId!=-1){
				packageId=-1;
				packageCarrier="";
				view.printMessageNewLine("\nUser Id: "+currentUserId+"\n---Main Menu---\n\t1: View Packages\n\t2: Add Package\n\t9: Sign Out");
				userMenuSelect = view.getInputInt();
				if(userMenuSelect==1){//viewPackages
					holdHashMap.put("uid", currentUserId);//example
					controller.handleRequest("view",holdHashMap);
					
				}else if(userMenuSelect==2){//addPackage
						view.printMessage("Enter Your Package ID: ");
						packageId=view.getInputInt();
						while(packageCarrier ==""&&!quit){
							view.printMessageNewLine("Select your carrier...\n\t1. UPS\n\t2. FedEx\n\t3. DHL\n\t4. USPS\n\t9. Cancel");
							int hold = view.getInputInt();
							if(hold==1){
								packageCarrier ="UPS";
							}else if(hold==2){packageCarrier ="FedEx";
							}else if(hold==3){packageCarrier ="DHL";
							}else if(hold==4){packageCarrier ="USPS";
							}else if(hold==9){quit=true;
							}else{
								view.printMessage("---Error---");
							}
						}
						quit=false;
						if(packageCarrier!=""){
							holdHashMap.put("uid", stringedId);//example
							holdHashMap.put("carrier", packageCarrier);
							holdHashMap = controller.handleRequest("add",holdHashMap);
							view.printMessageNewLine(holdHashMap.toString());
							modal.addPackages(holdHashMap);
							controller.handleRequest("save", holdHashMap);
							view.printMessageNewLine("Package Added");
						}
					}else if(userMenuSelect==9){//quit
						quit=true;
					view.printMessage("---Have a Nice Day!---");
				}else{
					view.printMessage("ERROR: Please Enter a valid input.");
				}
			}
		}
	}
}
