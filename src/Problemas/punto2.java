package Problemas;

import java.util.Arrays;
import java.util.Scanner;

public class punto2 {
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
		Integer tam;
		Integer[] datos;
		if (num.length<7 ) {
			tam = 0;
			datos = new Integer[num.length];
		}
		else {
			tam = num.length-7;
			datos = new Integer[7];
		}

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
			while (R>0) {
				permut(datos);
				for (int j = 0; j < datos.length; j++) {
					resp = resp + datos[j];
				}
				System.out.println(resp);
				resp = resp +"\n";
				R--;
			}
			
		}
	}

	private static void permut(Integer[] dato) {
		Integer min = 0;
		Integer posMin =0;
		int[] temp = new int[dato.length];
		for (int i = dato.length-1; i >= 0; i--) {
			if(dato[i-1]>dato[i]) {
				temp[i] = dato[i];
			}
			else {
				temp[i] = dato[i];
				min = dato[i-1];
				posMin = i-1;
				break;
			}
		}
		Integer minDmax =10;
		Integer posminDmax=0;
		for (int i = posMin+1; i < temp.length; i++) {
			if (temp[i]< minDmax && temp[i]>min) {
				minDmax = temp[i];
				posminDmax = i;
			}
		}
		dato[posMin] = minDmax;
		dato[posminDmax] = min;

		temp= new int[dato.length -(min)];
		for (int i = min; i < dato.length; i++) {
			temp[i-(min)] = dato[i];
		}
		Arrays.sort(temp);
		for (int i = min; i < dato.length; i++) {
			dato[i] = temp[i-min];
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
