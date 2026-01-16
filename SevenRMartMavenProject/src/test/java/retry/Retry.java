package retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{
	int counter = 0; 
	int retryLimit = 2; 
	 
	public boolean retry(ITestResult result) { //invoke when testcase fails

		System.out.println(counter);
		if(counter < retryLimit) 
		{ 
			counter++; 
			return true; //reexecution
		} 
		return false; //stop execution
	}
}
