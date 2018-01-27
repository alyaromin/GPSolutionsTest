package com.alyaromin.task557;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer tokenizer;
    static BufferedReader reader;

    public static void main(String[] args) throws Exception {

	reader = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));

	int m = nextInt();
	int n = nextInt();
	int a = nextInt() - 1;
	int b = nextInt() - 1;
	int p = nextInt();

	List<int[][]> matrixes = new ArrayList<>();

	matrixes.add(0, readMatrix(n));

	for (int i = 1; i < m; i++) {
	    matrixes.add(i, readTransposedMatrix(n));
	}

	if (m >= 1) {
	    for (int i = 1; i < m; i++) {
		matrixes.set(0, multipleMatrixes(matrixes.get(0), matrixes.get(i), n, p));
	    }
	}

	System.out.println(matrixes.get(0)[a][b]);
    }

    private static int[][] readMatrix(final int columns) throws Exception {
	int[][] matrix = new int[columns][columns];

	for (int i = 0; i < columns; i++) {
	    for (int j = 0; j < columns; j++) {
		matrix[i][j] = nextInt();
	    }
	}
	return matrix;
    }

    private static int[][] readTransposedMatrix(final int columns) throws Exception {
	int[][] matrix = new int[columns][columns];

	for (int i = 0; i < columns; i++) {
	    for (int j = 0; j < columns; j++) {
		matrix[j][i] = nextInt();
	    }
	}
	return matrix;
    }

    private static int[][] multipleMatrixes(final int[][] matrix1, final int[][] transposedMatrix2, final int columns, final int module) {

	int[][] resultMatrix = new int[columns][columns];

	for (int i = 0; i < columns; i++) {
	    for (int j = 0; j < columns; j++) {
		int sum = 0;
		for (int k = 0; k < columns; k++) {
		    sum += matrix1[i][k] * transposedMatrix2[j][k];
		}
		resultMatrix[i][j] = sum % module;
	    }
	}
	return resultMatrix;
    }

    private static int nextInt() throws Exception {
	return Integer.parseInt(nextToken());
    }

    private static String nextToken() throws Exception {
	while (tokenizer == null || !tokenizer.hasMoreTokens()) {
	    tokenizer = new StringTokenizer(reader.readLine());
	}
	return tokenizer.nextToken();
    }
}