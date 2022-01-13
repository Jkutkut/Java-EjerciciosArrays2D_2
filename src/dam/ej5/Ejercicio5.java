package dam.ej5;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio5 {
	
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
		System.out.flush(); // Para forzar que se imprima antes que el posible error.
		
		vertices(matriz);
	}

	private static void vertices(int[][] matriz) {
		if (matriz.length == 0 || matriz[0].length == 0) {
			System.err.println("Al tener uno de sus tamaños igual a 0, no hay vértices");
			return;
		}
		else if (matriz.length == 1 || matriz[0].length == 1) {
			System.out.println("Considero que en una matriz 1xM o Nx1, hay 4 vértices (aunque estén representando la misma celda");
		}
		int[][] vertices = {
				{matriz[0][0],			matriz[0][matriz[0].length - 1]},
				{matriz[matriz.length - 1][0],	matriz[matriz.length - 1][matriz[0].length - 1]},
		};
		System.out.println("Los vértices del array son:");
		System.out.println(prettyPrint(vertices));
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
