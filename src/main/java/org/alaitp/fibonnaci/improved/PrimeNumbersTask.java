package org.alaitp.fibonnaci.improved;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumbersTask implements Runnable {

	private List<Integer> primes = new ArrayList<Integer>();
	private Integer lastNumberChecked;
	private Integer lastNumberRetrieved = 0;
	private NumberChecker checker;
	private Boolean finished;

	private void generateNextPrime() {

		//only the add really needs to be synchronized
		synchronized (this) {
			Integer testNumber = lastNumberChecked + 1;
			while (!checker.isPrime(testNumber)) {
				testNumber++;
			}
			lastNumberChecked = testNumber;
			primes.add(testNumber);
		}
	}

	public void taskComplete() {
		finished = true;
	}

	public int getSize() {
		synchronized (this) {
			return (primes.size());
		}
	}

	public Integer getNextNumber() {
			if (primes.size() > lastNumberRetrieved) {
				//doesn't need to be syncrhonized as not amending code
				lastNumberRetrieved++;
				return primes.get(lastNumberRetrieved-1);
			}
			else return null;
		}
	

	@Override
	public void run() {
		finished = false;
		checker= new NumberChecker();
		synchronized (this) {
			primes.add(2);
		}
		lastNumberChecked = 2;

		while (!finished) {
			generateNextPrime();
		}
	}
}
