package dam.ej03;

import java.util.Scanner;

public class Ejercicio3_ejercicio_2D_3 {

	static Scanner sc;
	private static String[] nombres;
	private static int[] precios;
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);

		System.out.print("Número de artículos -> ");
		int n = Integer.parseInt(sc.nextLine());

		getProductos(n);
		printProductos();
	}

	private static void getProductos(int n) {
		nombres = new String[n];
		precios = new int[n];
		
		for (int i = 0; i < n; i++) {
			System.out.println("Producto " + (i + 1) + ":");
			System.out.print("  - Nombre: ");
			nombres[i] = sc.nextLine();
			System.out.print("  - Precio: ");
			precios[i] = Integer.parseInt(sc.nextLine());
		}
	}
	
	private static void printProductos() {
		System.out.println("\nLista de productos");
		for (int i = 0; i < nombres.length; i++) {
			System.out.println("Producto " + (i + 1) + ":");
			System.out.println("  - Nombre: " + nombres[i]);
			System.out.println("  - Precio: " + precios[i] + "um");
		}
	}
}
