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
				view.printText("Enter a number you want to save: ");
				input = view.getInputInt();
				if(!model.checkInput(input))
				{model.setNumber(input);
				view.printText("Success /n Data:");
				view.printText(model.getData());}
				else
				{
					view.printText("Number already exists in Data");
				}
			}
			else
			{
				view.printText(model.getData());
			}
			view.printText("1: Add Number /n 2:View Data /n 3:Quit");
			input = view.getInputInt();
		}
	}
}
