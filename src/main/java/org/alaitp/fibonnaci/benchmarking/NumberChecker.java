package org.alaitp.fibonnaci.benchmarking;

public class NumberChecker {

	public Boolean isPrime1(Integer testNumber) {
		for (Integer i = 2; i < testNumber; i++) {
			if (testNumber % i == 0) return false;
		}
		return true;
	}


	public Boolean isPrime2(Integer testNumber) {
		int maxToCheck = (int) Math.sqrt(testNumber) + 1;
		for (int i = 2; i < testNumber; i++) {
			if (testNumber % i == 0) return false;
		}
		return true;
	}
	
	
}
