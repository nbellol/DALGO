package Problemas;

import java.util.Arrays;
import java.util.Scanner;

public class problemaDalgo2 {
	public static char[] num;
	private static Long R;
	private static Long Valnum;
	private static Long Tope;
	private static Integer Temp = 0;
	private static long[] minimos;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		imprimirPregunta();
		String option = sc.nextLine();
		String data[] = option.split(" ");

		Valnum = Long.parseLong(data[1]);
		R = Long.parseLong(data[0]);
		num = data[1].toCharArray();
		minimos = new long[5040];

		Integer cont =0;
		Integer tam = num.length-7;
		Integer[] datos = new Integer[7];
		String resp="";
		String t ="";
		
		for (int i = 0; i < num.length; i++) {
			if(i < tam) {
				resp = resp +num[i];	
			}
			else {
				datos[i-tam] = Integer.parseInt(num[i]+"");
				t=t+datos[i-tam];
			}
			if (i+1<num.length) {
				if (num[i]>=num[i+1]) {cont++;}
			}
		}
		Tope = Long.parseLong(t);
		if (cont== num.length-1) {
			System.out.println("*");
		}
		else {

			permut(datos, 0, datos.length);
			Arrays.sort(minimos);
			if(R<= Temp) {
				System.out.println("PERMUTACION BUESCADA: " + resp + minimos[(int) ((5039-Temp)+R)]);
			}
			else {
				System.out.println("NO EXISTE ESA PERMUTACION");
			}
			
		}

	}

	public static void permut(Integer[] numeros, int start, int n) {
		int temp =0;
		if( start<n)
		{
			for (int i = start; i < n; i++) {
				temp = numeros[start];
				numeros[start]= numeros[i];
				numeros[i]= temp;

				permut(numeros,start+1,n);

				temp = numeros[start];
				numeros[start]= numeros[i];
				numeros[i]= temp;
			}
		}
		else {

			String resp = "";
			for (int j = 0; j < n; j++) {
				resp = resp +numeros[j];
			}
			
			Long actual = new Long(resp);
			if(actual >Tope) {
				minimos[Temp]=actual;
				Temp++;
			}

		}
	}

	public static void imprimirPregunta() {
		System.out.println("---------ISIS 1105 - Diseño y Analisis de Algoritmos----------");
		System.out.println("---------------------Proyecto----------------------");
		System.out.println("Ingrese los valores para el segundo problema, K-sima siguiente permutación");
		System.out.println("de la forma <r k> donde 0 <= r <= 9 y k es entero ");
		System.out.println("Ej: 1 123542");
	}
}
