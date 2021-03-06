package dam.ej07;

import java.util.Random;

public class Ejercicio7 {

	public static final int SIZE = 4;
	
	public static void main(String[] args) {
		int[][] m1 = new int[SIZE][SIZE];
		int[][] m2 = matrizUnidad(SIZE);
		
		randomFill(m1, SIZE * SIZE);

		System.out.println("1º Matriz:");
		System.out.println(prettyPrint(m1));
		
		System.out.println("2º Matriz:");
		System.out.println(prettyPrint(m2));
		
		int[][] resultado = productoMatrices(m1, m2);
		
		System.out.println("1º Matriz multiplicada por la 2º:");
		System.out.println(prettyPrint(resultado));
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

	private static int[][] productoMatrices(int[][] m1, int[][] m2) {
		// Supongo que ambas matrices son matrices n1xm1 y n2xm2 (que todas las filas y son del mismo tamaño)
		if (m1[0].length != m2.length) {
			return null;
		}
		int[][] result = new int[m1.length][m2[0].length];
		
		for (int i = 0, j, k; i < result.length; i++) {
			for (j = 0; j < result[i].length; j++) {
				result[i][j] = 0;
				for (k = 0; k < result[i].length; k++) {
					result[i][j] += m1[i][k] * m2[k][j];
				}
			}
		}
		
		return result;
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
