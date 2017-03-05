package systemLevelTest;

import java.util.Scanner;

public class systemeLevelTestSandbox {

	public static void main(String[] args) {
		System.out.println("Hello Welcome to the Useless Program");
		String stringIn = "";
		Scanner in = new Scanner(System.in);
		while (!stringIn.equals("exit") && !stringIn.equals("Exit")){
			try{
				System.out.print("Enter your name ('exit' to end): ");
				stringIn = in.nextLine();
				stringIn = stringIn.replaceAll("[^A-Za-z ]+", "");
				stringIn = stringIn.replaceAll("[ ]{2,}+", " ");
				if(!stringIn.equals("exit") && !stringIn.equals("Exit"))
				{
					System.out.println("Hello " + stringIn);
				}
				else
				{
					System.out.println("\nThank you for using the Useless Program!");
				}
			}catch(Exception e)
			{System.out.println("Error- Input not valid. Try again.");}
		}
	}
}
