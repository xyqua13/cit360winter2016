package mvcSandbox;

import java.util.HashSet;
import java.util.Set;

public class modelSandbox {

		static Set<Integer> allData = new HashSet<Integer>();
		//Setter for entering a number
		public void  setNumber(Integer in)
		{
			allData.add(in);
		}
		//check input checks if the input is already in the hash set
		public static boolean checkInput(Integer in)
		{
			return allData.contains(in);
		}
		//Getter to return full data set
		public static String getData()
		{
			return allData.toString();
		}
}
