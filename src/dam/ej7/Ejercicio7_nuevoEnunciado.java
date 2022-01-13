package dam.ej7;

import java.util.Random;

public class Ejercicio7_nuevoEnunciado {

	public static final int SIZE = 3;
	
	public static void main(String[] args) {
		int[][] m1 = new int[SIZE][SIZE];
		
		randomEvenFill(m1, SIZE * SIZE);

		System.out.println("Matriz:");
		System.out.println(prettyPrint(m1));
		
		int sumaDiaInv = 0;
		
		for (int i = SIZE - 1, j = 0; i >= 0; i--, j++) {
			sumaDiaInv += m1[i][j];
		}
		
		System.out.println("Las suma de la diagonal inversa es " + sumaDiaInv);
	}

	private static void randomEvenFill(int[][] matriz, int maxHalfVal) {
		Random r = new Random();
		
		for (int i = 0, j; i < matriz.length; i++) {
			for (j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = r.nextInt(maxHalfVal) * 2;
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
