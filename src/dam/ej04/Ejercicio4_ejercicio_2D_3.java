package dam.ej04;

import java.util.Scanner;

public class Ejercicio4_ejercicio_2D_3 {

	static Scanner sc;
	private static String[] nombres;
	private static int[] dificultad;
	private static int[] tiempo;
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);

		System.out.print("Número de recetas -> ");
		int n = Integer.parseInt(sc.nextLine());

		getRecetas(n);
		printRecetas();
	}

	private static void getRecetas(int n) {
		nombres = new String[n];
		dificultad = new int[n];
		tiempo = new int[n];
		
		for (int i = 0; i < n; i++) {
			System.out.println("Producto " + (i + 1) + ":");
			System.out.print("  - Nombre: ");
			nombres[i] = sc.nextLine();
			System.out.print("  - Dificultad: ");
			dificultad[i] = Integer.parseInt(sc.nextLine());
			System.out.print("  - Tiempo de ejecución (min): ");
			tiempo[i] = Integer.parseInt(sc.nextLine());
		}
	}
	
	private static void printRecetas() {
		System.out.println("\nLista de recetas");
		int recetaE = 0;
		for (int i = 0; i < nombres.length; i++) {
			printReceta(i);
			if (dificultad[i] > dificultad[recetaE] ||
				dificultad[i] == dificultad[recetaE] && tiempo[i] > tiempo[recetaE]) {
				recetaE = i;
			}
		}
		
		System.out.println("\nLa receta con dificultad alta que tiene más tiempo de ejecución es:");
		printReceta(recetaE);
	}

	private static void printReceta(int i) {
		System.out.println("Receta " + (i + 1) + ":");
		System.out.println("  - Nombre: " + nombres[i]);
		System.out.println("  - Dificultad: " + dificultad[i]);
		System.out.println("  - Tiempo: " + tiempo[i] + " min");
	}
}
