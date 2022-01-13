package dam.ej10;

import java.util.Random;

public class Ejercicio10 {

	public static final int SIZE = 4;
	public static final int DIGITS = 2;
	
	public static void main(String[] args) {
		int[][] m1 = new int[SIZE][SIZE];
		
		randomFill(m1, SIZE * SIZE);

		System.out.println("Matriz:");
		System.out.println(prettyPrint(m1));
		System.out.println("El determinante de la matriz es: " + determinanteMatriz(m1));
	}
	
	private static int determinanteMatriz(int[][] m) {
		if (!noEsCuadrada(m)) {
			System.err.println("La matriz no es cuadrada. Valor retornado = 0");
			return 0;
		}
		String[][] debugOperaciones = new String[2][m.length]; // TODO debug
		String[] debugValor = new String[m.length]; // TODO debug
		
		int result = 0;
		for (int dir = 1, i, j, row, col, val; dir >= -1; dir-=2) {
			for (i = 0; i < m.length; i++) {
				val = 1;
				for (j = 0; j < m.length; j++) {
					row = (j) % m.length;
					if (dir == 1) {
						col = (i+j) % m.length;
					}
					else {
						col = m.length - i - j - 1;
						col = (col < 0) ? col + m.length : col;
					}
					
					val *= m[row][col];
					debugValor[j] = Integer.toString(m[row][col]); // TODO debug
				}
				result += val * dir;
				debugOperaciones[(dir == 1)? 0 : 1][i] = String.join("*", debugValor); // TODO debug
			}
		}
		System.out.printf("Determinante = %s - ( %s ) = %d\n",
				String.join(" + ", debugOperaciones[0]),
				String.join(" + ", debugOperaciones[1]),
				result
		); // TODO debug
		return result;
	}
	
	private static boolean noEsCuadrada(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			if (m[i].length != m.length) {
				return false;
			}
		}
		return true;
	}

	private static void randomFill(int[][] matriz, int maxVal) {
		Random r = new Random();
		
		for (int i = 0, j; i < matriz.length; i++) {
			for (j = 0; j < matriz[i].length; j++) {
//				matriz[i][j] = r.nextInt(maxVal);
				matriz[i][j] = r.nextInt(2 * maxVal) -maxVal;
			}
		}
	}
	
	public static String prettyPrint(int arr[][]) {
		String str = "";
		for (int i = 0, j; i < arr.length; i++) {
			str += "  { ";
			if (arr[i].length > 0) {
				str += String.format("%" + DIGITS + "d", arr[i][0]);
				for (j = 1; j < arr[i].length; j++) {
					str += ", " + String.format("%" + DIGITS + "d", arr[i][j]);
				}
			}
			str += " }\n";
		}
		str += "}";
		return str;
	}
}
