package jUnitTests;

public class testableFunctions {
	public int addition(int v1, int v2){
		return v1+v2;
	}
	public int subtraction(int v1, int v2){
		return v1-v2;
	}
	public int multiplication(int v1, int v2){
		return v1*v2;
	}
	public int division(int v1, int v2){
		return v1/v2;
	}
	
	public String concat (String v1, String v2){
		return v1+v2;
	}
	public String remove (String v1, String v2){
		return v1.replace(v2,"");
	}
}
