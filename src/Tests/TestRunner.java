package src.Tests;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
	public static void main(String[] args){
		Result result = JUnitCore.runClasses(Tests.class);
	    for (Failure failure : result.getFailures()) {
	         System.out.println(failure.toString());
	    }
	    System.out.println(result.wasSuccessful() ? "All TESTS PASSED" : "You Had a test failure.");
	    if (result.wasSuccessful()) System.exit(0);
	    System.exit(1);
	}
}
