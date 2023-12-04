package com.kerchanshe.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser  implements IRetryAnalyzer {
	int counter = 0;
	int retryLimit = 2;

	@Override
	public boolean retry(ITestResult itestresult) {
		if (counter < retryLimit) {
			counter++;
			return true;
		}
		return false;
	}

}
