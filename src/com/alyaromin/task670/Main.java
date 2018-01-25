package com.alyaromin.task670;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	sc.close();

	int number = 0;
	int i = 1;

	while (n != 0) {
	    if (hasNotRepeatedDigits(i)) {
		number = i;
		n--;
	    }
	    i++;
	}
	System.out.println(number);
    }

    private static boolean hasNotRepeatedDigits(int number) {
	if (number == 0)
	    return true;

	List<Integer> digitsList = new ArrayList<>();
	Set<Integer> digitsSet = new HashSet<>();

	for (; number != 0; number /= 10) {
	    digitsList.add(number % 10);
	    digitsSet.add(number % 10);
	}
	return (digitsList.size() == digitsSet.size());
    }

}
