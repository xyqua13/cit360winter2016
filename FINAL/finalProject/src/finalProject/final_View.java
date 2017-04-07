package finalProject;

import java.io.IOException;
import java.util.Scanner;

public class final_View {
	Scanner in = new Scanner(System.in);
	void printMessage(String msg){
		System.out.print(msg);
	}
	void printMessageNewLine(String msg){
		System.out.println(msg);
	}
	public String getStringInput(){
		
		return "";
	}
	public int getIntInput()
	{
		return 1;
	}
	public int getInputInt()
	{
		int inputInt = in.nextInt();
		return inputInt;
	}
	public String getInputString()
	{
		String inputString = in.nextLine();
		return inputString;
	}
}
