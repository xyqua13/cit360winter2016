package jUnitTests;

import org.junit.Test;
import static org.junit.Assert.*;

public class jUnitSandbox {
	// The jUnit test is a very powerful yet simple. I work mostly with JavaScript 
	// And after learning about even the most basic functions of jUnitTests I wish
	// There was something similar to use with JavaScript.
	//
	// jUnit test simple call a function and test if it returns what is expected. 
	// If not the system will throw an error but keep testing. As far as I can tell
	// the tests work best on a granular level. If I do this, does the system do that.
	// Multiple assertEquals in a single test function work but it won't show each 
	// individual result but rather a concatenation of all tests. Basically if 
	// if(assertTest&&assertTest&&asserTest) are all good then its a pass, else 
	// the test fails.
	
	// From the results of the test it would seem all tests are run asynchronously 
	
	//Good tests where everything Works
	@Test
	public void additionTest(){
		testableFunctions test = new testableFunctions();
		int testResult = test.addition(1, 5);
		assertEquals(6,testResult);
		assertEquals(50,testResult);
	}
	@Test
	public void subtractionTest(){
		testableFunctions test = new testableFunctions();
		int testResult = test.subtraction(5, 2);
		assertEquals(3,testResult);
	}
	@Test
	public void multiplicationTest(){
		testableFunctions test = new testableFunctions();
		int testResult = test.multiplication(5, 2);
		assertEquals(10,testResult);
	}
	@Test
	public void divisionTest(){
		testableFunctions test = new testableFunctions();
		int testResult = test.division(50, 5);
		assertEquals(10,testResult);
	}
	@Test
	public void concat(){
		testableFunctions test = new testableFunctions();
		String testResult = test.concat("This", "One");
		assertEquals("ThisOne",testResult);
	}
	@Test
	public void removeGood(){
		testableFunctions test = new testableFunctions();
		String testResult = test.remove("This", "is");
		assertEquals("Th",testResult);
	}
	@Test
	public void removeWeird(){
		testableFunctions test = new testableFunctions();
		String testResult = test.remove("This", "Watermellon");
		assertEquals("This",testResult);
	}
	
	
	// Bad Tests, All results are not as intended.
	@Test
	public void additionTestBad(){
		testableFunctions test = new testableFunctions();
		int testResult = test.addition(1, 5);
	}
	@Test
	public void subtractionTestBad(){
		testableFunctions test = new testableFunctions();
		int testResult = test.subtraction(5, 2);
		assertEquals(30,testResult);
	}
	@Test
	public void multiplicationTestBad(){
		testableFunctions test = new testableFunctions();
		int testResult = test.multiplication(5, 2);
		assertEquals(100,testResult);
	}
	@Test
	public void divisionTestBad(){
		testableFunctions test = new testableFunctions();
		int testResult = test.division(50, 5);
		assertEquals(100,testResult);
	}
	@Test
	public void concatBad(){
		testableFunctions test = new testableFunctions();
		String testResult = test.concat("This", "One");
		assertEquals("ThsisOne",testResult);
	}
	@Test
	public void removeGoodBad(){
		testableFunctions test = new testableFunctions();
		String testResult = test.remove("This", "is");
		assertEquals("Tah",testResult);
	}
	@Test
	public void removeWeirdBad(){
		testableFunctions test = new testableFunctions();
		String testResult = test.remove("This", "Watermellon");
		assertEquals("Thisa",testResult);
	}
}
