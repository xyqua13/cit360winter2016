package jsonSandbox;

import java.io.Serializable;
import java.sql.Date;

public class person implements Serializable {
 private String theString;
 private int theInt;
 private Date theDate;
 public person(String string, int i, Date date) {
	 theString = string;
	 theInt = i;
	 theDate = date;
	// TODO Auto-generated constructor stub
}

 public void print() {
	 System.out.println("To Object: ");
	 System.out.println("theString " +theString+" theInt "+theInt+" theDate "+theDate);
 }

}