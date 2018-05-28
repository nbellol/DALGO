package Problemas;

import java.util.ArrayList;
import java.util.Scanner;

public class ProblemaC {
	private static char[] cadena;
	private static Integer largo ;
	private static Integer cadLarga =0;
	private static Integer separacionLarga =0;
	private static ArrayList<Integer> espacios = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		imprimirPregunta();
		String option = sc.nextLine();
		String data[] = option.split("<");
		cadena = data[0].toCharArray();
		int[] resp = new int[cadena.length/2];
		for (int i = 2; i < cadena.length/2; i++) {
			cadLarga = 0;
			largo = i;
			Rio();
			resp[i] = cadLarga;
		}
		Integer cap = cadena.length/27;
		cap = cap*4;
		System.out.println(cap);
		for (int i = cap+1; i < resp.length; i++) {
			if(resp[i]>cadLarga) {
				cadLarga=resp[i];
				separacionLarga = i;
				System.out.println(i+"-"+ resp[i]);
			}
		}
		System.out.println(separacionLarga +" "+cadLarga);
	}
	
	private static void Rio() {
		Integer con =0;
		Integer valor =0;
		for (int i = 2; i < cadena.length; i++) {
			if(cadena[i] ==' ') {
				con =1;
				valor = i;
				cadena[valor] = '-';
				valor = valor + largo;
				while(valor<cadena.length-1) {
					if(cadena[valor]==' ') {
						con++;
						cadena[valor]='-';
					}
					else if(cadena[valor-1]==' ') {
						con++;
						cadena[valor-1]='-';
					}
					else if(cadena[valor+1]==' ') {
						con++;
						cadena[valor+1]='-';
					}
					valor = valor +largo;
				}
				if(con>cadLarga) {
					cadLarga = con;
				}
			}
		}
		for (int i = 0; i < cadena.length; i++) {
			if(cadena[i]=='-') {
				cadena[i] = ' ';
			}
			
		}
	}
	
	
	public static void imprimirPregunta() {

		System.out.println("---------ISIS 1105 - Diseño y Analisis de Algoritmos----------");
		System.out.println("---------------------Proyecto----------------------");
		System.out.println("Ingrese la cadena de caracteres a la que se le quiere encontrar en rio más largo");

	}
}
