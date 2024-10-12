package org.alaitp.fibonnaci.benchmarking;


public class Main {

    public static void main(String[] args) {
        NumberChecker nc = new NumberChecker();
        for (int i = 1001; i < 50000; i++) {
            nc.isPrime1(i);
        }
        System.out.println("warmed up");
        long start = System.currentTimeMillis();
        for (int i = 1001; i < 50000; i++) {
            nc.isPrime1(i);
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);

        for (int i = 1001; i < 50000; i++) {
            nc.isPrime2(i);
        }
        start = System.currentTimeMillis();
        for (int i = 1001; i < 50000; i++) {
            nc.isPrime2(i);
        }
        end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
