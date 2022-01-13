package dam.ej08;

import java.util.Random;

public class Ejercicio8_nuevoEnunciado {

	public static final int SIZE = 4;
	
	public static void main(String[] args) {
		int[][] m1 = new int[SIZE][SIZE];
		int[][] m2 = matrizUnidad(SIZE);
		
		randomFill(m1, SIZE * SIZE);

		System.out.println("1º Matriz:");
		System.out.println(prettyPrint(m1));
		
		System.out.println("2º Matriz:");
		System.out.println(prettyPrint(m2));

		dimeSiSonIguales(m1, m2);
		dimeSiSonIguales(m1, m1);
	}
	
	private static void dimeSiSonIguales(int[][] m1, int[][] m2) {
		System.out.println("\n***************");
		System.out.println("Las matrices:");
		System.out.println(prettyPrint(m1));
		System.out.println(prettyPrint(m2));
		if (matrixEquals(m1, m2)) {
			System.out.println("Son iguales");
		}
		else {
			System.out.println("No son iguales");
		}
		System.out.println("***************\n");
	}
	
	private static boolean matrixEquals(int[][] m1, int[][] m2) {
		if (m1.length != m2.length) {
			return false;
		}
		for (int i = 0, j; i < m1.length; i++) {
			if (m1[i].length != m2[i].length) {
				return false;
			}
			for (j = 0; j < m1[i].length; j++) {
				if (m1[i][j] != m2[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
	
	private static int[][] matrizUnidad(int n) {
		int[][] arr = new int[n][n];
		for (int i = 0, j; i < arr.length; i++) {
			for (j = 0; j < arr[i].length; j++) {
				arr[i][j] = 0;
			}
			arr[i][i] = 1;
		}
		return arr;
	}

	private static void randomFill(int[][] matriz, int maxVal) {
		Random r = new Random();
		
		for (int i = 0, j; i < matriz.length; i++) {
			for (j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = r.nextInt(maxVal);
			}
		}
	}
	
	public static String prettyPrint(int arr[][]) {
		String str = "{\n";
		for (int i = 0, j; i < arr.length; i++) {
			str += "  { ";
			if (arr[i].length > 0) {
				str += arr[i][0];
				for (j = 1; j < arr[i].length; j++) {
					str += ", " + arr[i][j];
				}
			}
			str += " }\n";
		}
		str += "}";
		return str;
	}
}
