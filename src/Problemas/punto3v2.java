package Problemas;

import java.util.Scanner;

public class punto3v2 {

	private static char[] cadena;
	private static Integer cadLarga =0;
	private static Integer separacionLarga =Integer.MAX_VALUE;
	private static Integer largo ;
	private static char ant =' ';

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		imprimirPregunta();
		String option = sc.nextLine();
		String data[] = option.split("<");
		cadena = data[0].toCharArray();
		Integer mitad =0;
		if (cadena.length%2!=0) {
			mitad = (cadena.length/2)+1;
		}
		else
		{
			mitad = cadena.length/2;
		}

		int[] results = new int[mitad];
		largo =0;
		
		
		for (int i = 2; i < mitad; i++) {
			largo =i;
			cadLarga  =0;
			sacarRio();
			results[i] = cadLarga;
		}
		
		String resp ="";
		for (int i = 0; i < results.length; i++) {
			System.out.println(results[i] + "-" + i);
		}
		System.out.println(resp);
		System.out.println(cadLarga);
	}
	public static void sacarRio()
	{
		Integer con =0;
		Integer valor =0;
		String separator = "";
		char sep = ' ';
		for (int i = 0; i < cadena.length; i++) {

			separator = (largo%10) +"";
			sep = separator.charAt(0);

			if(cadena[i] ==' '|| cadena[i] == ant) {
				con=0;
				valor = i;
				cadena[valor] =sep;
				valor = valor + largo;
				while (valor<cadena.length-1 && valor%i ==0) {
					if(cadena[valor]==' ' || cadena[valor] == ant) {
						con++;
						cadena[valor] =sep;
					}
					else if (cadena[valor -1]==' '||cadena[valor- 1] == ant) {
						con++;
						cadena[valor-1] =sep;
					}
					else if (cadena[valor +1]==' '|| cadena[valor+1] == ant) {
						con++;
						cadena[valor+1] =sep;
					}
					valor = valor + largo;
				}
				if (con+1>cadLarga){
					cadLarga = con+1;
				}
			}
		}
		ant =sep;
	}
	public static void imprimirPregunta() {

		System.out.println("---------ISIS 1105 - Diseño y Analisis de Algoritmos----------");
		System.out.println("---------------------Proyecto----------------------");
		System.out.println("Ingrese la cadena de caracteres a la que se le quiere encontrar en rio más largo");

	}


}
