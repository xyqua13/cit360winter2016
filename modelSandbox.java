package mvcSandbox;

import java.util.HashSet;
import java.util.Set;

public class modelSandbox {

		static Set<Integer> allData = new HashSet<Integer>();
		public void  setNumber(Integer in)
		{
			allData.add(in);
		}
		public static boolean checkInput(Integer in)
		{
			return allData.contains(in);
		}
		public static String getData()
		{
			return allData.toString();
		}
}
