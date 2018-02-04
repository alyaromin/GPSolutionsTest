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

	final int countOfMatrixes = nextInt();
	final int size = nextInt();
	final int wantedRowIndex = nextInt() - 1;
	final int wantedColumnIndex = nextInt() - 1;
	final int module = nextInt();

	List<int[][]> matrixes = new ArrayList<>();

	matrixes.add(0, readMatrix(size, size));

	for (int i = 1; i < countOfMatrixes; i++) {
	    matrixes.add(i, readTransposedMatrix(size, size));
	}

	if (countOfMatrixes >= 1) {
	    for (int i = 1; i < countOfMatrixes; i++) {
		matrixes.set(0, multiplyMatrixes(matrixes.get(0), matrixes.get(i), module));
	    }
	}

	System.out.println(matrixes.get(0)[wantedRowIndex][wantedColumnIndex]);
    }

    private static int[][] readMatrix(final int rowCount, final int columnCount) throws Exception {
	int[][] matrix = new int[rowCount][columnCount];

	for (int i = 0; i < rowCount; i++) {
	    for (int j = 0; j < columnCount; j++) {
		matrix[i][j] = nextInt();
	    }
	}
	return matrix;
    }

    private static int[][] readTransposedMatrix(final int rowCount, final int columnCount) throws Exception {
	int[][] matrix = new int[rowCount][columnCount];

	for (int i = 0; i < rowCount; i++) {
	    for (int j = 0; j < columnCount; j++) {
		matrix[j][i] = nextInt();
	    }
	}
	return matrix;
    }

    private static int[][] multiplyMatrixes(final int[][] matrix1, final int[][] transposedMatrix2, final int module) {

	final int rowCount = matrix1.length;
	final int columnCount = rowCount;

	int[][] resultMatrix = new int[rowCount][columnCount];

	for (int i = 0; i < rowCount; i++) {
	    for (int j = 0; j < columnCount; j++) {
		int sum = 0;
		for (int k = 0; k < rowCount; k++) {
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