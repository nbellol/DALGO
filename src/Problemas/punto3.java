package Problemas;

import java.util.ArrayList;
import java.util.Scanner;

public class punto3 {

	private static char[] cadena;
	private static Integer cadLarga =0;
	private static Integer separacionLarga =Integer.MAX_VALUE;
	//	private static Integer largo = 15;
	private static char ant =' ';


	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		imprimirPregunta();
		String option = sc.nextLine();
		String data[] = option.split("<");
		cadena = data[0].toCharArray();
		Integer con =0;
		Integer valor =0;
		String separator = "";
		char sep = ' ';
		Integer largo =0;
		ArrayList<Integer> espacios = new ArrayList<>();

		for (int i = 0; i < cadena.length; i++) {
			if(cadena[i] ==' ') {
				if (i%2 !=0) {
					espacios.add(i-1);
				}
				else {
					espacios.add(i);
				}

			}
		}
		for (int j = 3; j < (cadena.length/2); j++) {
			largo = j;
			if (espacios.contains(largo)) {
				for (int i = 0; i < cadena.length; i++) {
					con =0;
					if(cadena[i] ==' '||cadena[i]== ant) {

						separator = largo%10 +"";
						sep = separator.charAt(0);
						con =1;
						valor =i;
						cadena[valor]=sep;
						valor = valor+largo;
						
						while(valor<cadena.length-1) {
							
							if (cadena[valor]==' ' ||cadena[valor]== ant) {
								con++;
								cadena[valor]=sep;
							}
							else if (cadena[valor+1]==' '||cadena[valor+1]== ant) {
								con++;
								cadena[valor+1]= sep;
							}
							else if (cadena[valor-1]==' '||cadena[valor-1]== ant) {
								con++;
								cadena[valor-1]=sep;
							}
							valor = valor+largo;
						}
						if (con > cadLarga && largo< separacionLarga)
						{
							cadLarga = con;
							separacionLarga = largo;
						}
						ant = sep;
					}
				}
			}
			System.out.println(separacionLarga+ " - " + cadLarga);
		}

	}

	public static void imprimirPregunta() {

		System.out.println("---------ISIS 1105 - Diseño y Analisis de Algoritmos----------");
		System.out.println("---------------------Proyecto----------------------");
		System.out.println("Ingrese la cadena de caracteres a la que se le quiere encontrar en rio más largo");

	}
}
