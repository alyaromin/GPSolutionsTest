package com.alyaromin.task278;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	String dna1 = sc.nextLine();
	String dna2 = sc.nextLine();
	sc.close();

	dna1 = dna1.replaceAll(" ", "");
	dna2 = dna2.replaceAll(" ", "");

	char[] charDnaPattern = dna1.toCharArray();
	char[] charDna = dna2.toCharArray();

	int countMatches = 0;

	if (charDnaPattern.length == 0) {
	    System.out.println("YES");
	} else {
	    if (charDna.length == 0) {
		System.out.println("NO");
	    } else {
		for (int i = 0, j = 0; (i < charDnaPattern.length) && ((charDnaPattern.length - i) <= (charDna.length - j)); i++) {
		    for (; j < charDna.length;) {
			if (charDnaPattern[i] == charDna[j]) {
			    countMatches++;
			    j++;
			    break;
			}
			j++;
		    }
		}

		if (charDnaPattern.length == countMatches) {
		    System.out.println("YES");
		} else {
		    System.out.println("NO");
		}
	    }
	}

    }

}
