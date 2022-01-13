package dam.ej03;

import java.util.Random;

public class Ejercicio3 {

	public static final int SIZE_R = 3;
	public static final int SIZE_C = 4;
	
	public static void main(String[] args) {
		int[][] matriz = new int[SIZE_R][SIZE_C];
		
		randomFill(matriz, SIZE_R * SIZE_C);
		
		System.out.println("Matriz:");
		System.out.println(prettyPrint(matriz));
		
		getMaximo(matriz);
	}

	private static void getMaximo(int[][] arr) {
		int maxR = 0, maxC = 0;
		for (int i = 0, j; i < arr.length; i++) {
			for (j = 0; j < arr[i].length; j++) {
				if (arr[i][j] > arr[maxR][maxC]) {
					maxR = i;
					maxC = j;
				}
			}
		}
		System.out.printf("El valor máximo del array se encuentra en la posición (%d, %d) con un valor = %d\n", maxR, maxC, arr[maxR][maxC]);
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
