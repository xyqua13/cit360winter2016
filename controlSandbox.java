package mvcSandbox;

import java.util.Scanner;

public class controlSandbox {
	public static void main(String[] args) {
		viewSandbox view = new viewSandbox();
		modelSandbox model = new modelSandbox();
		view.printText("1: Add Number /n 2:View Data /n 3:Quit");
		Integer input = view.getInputInt();
		while (input!=3)
		{
			if(input == 1)
			{
				//Calls the VIEW to print out information for user interaction
				view.printText("Enter a number you want to save: ");
				
				// calls to VIEW to read in the input
				input = view.getInputInt();
				
				//Checks the input with the data in the MODEL 
				if(!model.checkInput(input))
				{model.setNumber(input);
				view.printText("Success /n Data:");//if success sends success message to view.
				view.printText(model.getData());}//Prints out all data from the MODEL
				else
				{
					view.printText("Number already exists in Data");//Error Message sent to view
				}
			}
			else
			{
				view.printText(model.getData());// Calls view to print out data. 
			}
			view.printText("1: Add Number /n 2:View Data /n 3:Quit"); //prints out menu to view
			input = view.getInputInt();
		}
	}
}
