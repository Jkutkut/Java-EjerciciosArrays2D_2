package dam.ej06;

import java.util.Random;

public class Ejercicio6_nuevoEnunciado {

	public static final int SIZE = 3;
	
	public static void main(String[] args) {
		int[][] m1 = new int[SIZE][SIZE];
		
		randomFill(m1, SIZE);

		System.out.println("Matriz:");
		System.out.println(printSumas(m1));
		
		// Manera "normal":
		printSumasV0(m1);
	}

	private static void randomFill(int[][] matriz, int maxVal) {
		Random r = new Random();
		
		for (int i = 0, j; i < matriz.length; i++) {
			for (j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = r.nextInt(maxVal);
			}
		}
	}
	
	public static String printSumas(int arr[][]) {
		/**
		 * Ejemplo de ejecución:
		 * Matriz:
		 * | 2, 0, 0 | 2
		 * | 0, 1, 0 | 1
		 * | 2, 1, 0 | 3
		 *   4  2  0
		 */
		int i, j, sumaFila;
		String str = "";
		int[] sumaColumnas = new int[arr[0].length];
		for (i = 0; i < arr.length; i++) {
			sumaFila = 0; // Variable que suma los valores de la fila
			str += "| ";
			if (arr[i].length > 0) {
				str += arr[i][0];
				sumaFila   += arr[i][0]; // Suma aquí la fila
				sumaColumnas[0] += arr[i][0]; // Suma aquí la columna
				for (j = 1; j < arr[i].length; j++) {
					str += ", " + arr[i][j];
					sumaFila += arr[i][j]; // Suma aquí la fila
					sumaColumnas[j] += arr[i][j]; // Suma aquí la columna
				}
			}
			str += " | " + sumaFila + "\n"; // Como hemos terminado la fila, representamos ya la suma
			// No hace falta en este caso un array ya que la información ya no es necesaria a 
			// partir de aquí
		}
		// Ya tenemos calculadas las sumas de las columnas
		for (i = 0; i < arr[0].length; i++) { // Las representamos aquí
			str += "  " + sumaColumnas[i];
		}
		str += "\n";
		return str;
	}
	
	/**
	 * Manera menos bonita de imprimir las sumas
	 */
	public static void printSumasV0(int arr[][]) {
		int i, j, sumaFila;
		int[] sumaColumnas = new int[arr[0].length]; // Se puede usar SIZE en este caso, pero así funciona para cualquiera
		
		System.out.println("Suma de filas:");
		for (i = 0; i < arr.length; i++) {
			sumaFila = 0;
			for (j = 0; j < arr[i].length; j++) {
				sumaFila += arr[i][j];
				sumaColumnas[j] += arr[i][j];
			}
			System.out.println("  - Fila " + i + ": " + sumaFila);
		}
		
		System.out.println("\nSuma de Columnas:");
		for (i = 0; i < sumaColumnas.length; i++) {
			System.out.println("  - Columna " + i + ": " + sumaColumnas[i]);
		}
	}
}
