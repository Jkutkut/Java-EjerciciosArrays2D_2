package dam.ej04;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio4 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Número de filas -> ");
		int sizeR = Integer.parseInt(sc.nextLine());
		System.out.print("Número de columnas -> ");
		int sizeC = Integer.parseInt(sc.nextLine());
		sc.close();
		
		int[][] matriz = new int[sizeR][sizeC];
		
		randomFill(matriz, sizeR * sizeC);
		
		System.out.println("Matriz:");
		System.out.println(prettyPrint(matriz));
		
		System.out.println("\nMatriz con la primera fila cambiada por la segunda:");
		cambiaFila(0, 1, matriz);
		System.out.println(prettyPrint(matriz));
	}
	
	private static void cambiaFila(int r1, int r2, int[][] arr) {
		if (r1 >= arr.length || r2 >= arr.length) {
			System.err.println("No existen las filas indicadas, el cambio no ha sido posible");
			return;
		}
		
		int[] swap = arr[r1];
		arr[r1] = arr[r2];
		arr[r2] = swap;
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
