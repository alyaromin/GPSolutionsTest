package com.alyaromin.task579;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);

	Set<Integer> positiveNumbers = new HashSet<>();
	Set<Integer> negativeNumbers = new HashSet<>();

	int count = sc.nextInt();
	int[] sequence = new int[count];
	int originalSum = 0;

	for (int i = 0; i < sequence.length; i++) {
	    sequence[i] = sc.nextInt();

	    if (sequence[i] < 0) {
		negativeNumbers.add(i + 1);
	    }
	    if (sequence[i] > 0) {
		positiveNumbers.add(i + 1);
	    }

	    originalSum += sequence[i];
	}

	if (originalSum >= 0) {
	    System.out.println(positiveNumbers.size());
	    for (int i : positiveNumbers) {
		System.out.print(i + " ");
	    }
	} else {
	    System.out.println(negativeNumbers.size());
	    for (int i : negativeNumbers) {
		System.out.print(i + " ");
	    }
	}
	sc.close();
    }
}
