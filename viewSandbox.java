package mvcSandbox;

import java.util.Scanner;

public class viewSandbox {
	public static void printText(String message)
	{
		System.out.println(message);
	}
	public String getInputString()
	{
		Scanner in = new Scanner(System.in);
		String inputString = in.nextLine();
		return inputString;
	}
	public int getInputInt()
	{
		Scanner in = new Scanner(System.in);
		int inputInt = in.nextInt();
		return inputInt;
	}
}
