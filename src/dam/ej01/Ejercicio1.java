package dam.ej01;

import java.util.Random;

public class Ejercicio1 {
	
	public static final int SIZE = 4;
	
	public static void main(String[] args) {
		int[][] matriz = new int[SIZE][SIZE];
		
		randomFill(matriz, SIZE);
		
		System.out.println(prettyPrint(matriz));
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
