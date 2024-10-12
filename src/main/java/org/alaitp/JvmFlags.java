package org.alaitp;

import java.util.Arrays;

public class JvmFlags {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(args));
        System.out.println(System.getProperty("java.version"));
    }
}
