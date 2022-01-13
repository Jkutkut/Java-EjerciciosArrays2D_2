package dam.ej02;

import java.util.Random;

public class Ejercicio2 {
	
	public static final int SIZE = 4;
	
	public static void main(String[] args) {
		int[][] matriz = new int[SIZE][SIZE];
		
		randomFill(matriz, SIZE);
		
		System.out.println("La matriz es");
		System.out.println(prettyPrint(matriz));
		
		System.out.println("La matriz es simetrica " + esSimetrica(matriz));
		
		int [][] simetrica = {
			{1,2,3,4},
			{2,2,3,4},
			{3,3,3,4},
			{4,4,4,4}
		};
		System.out.println("\n\nLa matriz simétrica es");
		System.out.println(prettyPrint(simetrica));
		System.out.println("La matriz es simetrica " + esSimetrica(simetrica));
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
	
	/**
	 * Basado en https://es.wikipedia.org/wiki/Matriz_sim%C3%A9trica
	 */
	public static boolean esSimetrica(int arr[][]) {
		for (int i = 0, j; i < arr.length; i++) {
			if (arr.length != arr[i].length) {
				return false;
			}
			for (j = 0; j < arr[i].length; j++) {
				if (arr[i][j] != arr[j][i]) {
					return false;
				}
			}
		}
		return true;
	}
}
