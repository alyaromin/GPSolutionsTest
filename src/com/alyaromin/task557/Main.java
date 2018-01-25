package com.alyaromin.task557;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int m = sc.nextInt();
	int n = sc.nextInt();
	int a = sc.nextInt() - 1;
	int b = sc.nextInt() - 1;
	int p = sc.nextInt();

	int[][] multipleMatrix = new int[n][n];
	int[][] matrix1 = new int[n][n];
	int[][] matrix2Transposed = new int[n][n];

	for (int x = 0; x < n; x++) {
	    for (int y = 0; y < n; y++) {
		multipleMatrix[x][y] = sc.nextInt();
	    }
	}
	for (int i = 1; i < m; i++) {
	    for (int x = 0; x < n; x++) {
		for (int y = 0; y < n; y++) {
		    matrix1[x][y] = multipleMatrix[x][y];
		    matrix2Transposed[y][x] = sc.nextInt();
		    multipleMatrix[x][y] = 0;
		}
	    }
	    for (int x = 0; x < n; x++) {
		for (int y = 0; y < n; y++) {
		    for (int k = 0; k < n; k++) {
			multipleMatrix[x][y] += matrix1[x][k] * matrix2Transposed[y][k];
			if (multipleMatrix[x][y] >= p) {
			    multipleMatrix[x][y] = multipleMatrix[x][y] % p;
			}
		    }
		}
	    }
	}
	sc.close();

	System.out.println(multipleMatrix[a][b]);
    }

}