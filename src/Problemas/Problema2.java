package Problemas;

import java.util.Scanner;

public class Problema2 {
	
	public static char[] num;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean fin = false;
		while (!fin) {
			imprimirPregunta();
			String option = sc.nextLine();
			String data[] = option.split(" ");
			String resp = kSimaPerm(data[0],data[1]);
			
			System.out.println(resp);
		}
	}

	private static String kSimaPerm(String r, String numero) {
		String resp ="";
		Integer valor = Integer.parseInt(numero);
		Integer valorR = Integer.parseInt(r);
		Integer cont =0;
		boolean veces = false;
		num = numero.toCharArray();
		
		for (int i = 0; i < num.length-1; i++) {
			if (num[i]>=num[i+1]) {cont++;}
		}
		
		for (int i = num.length -1; i> 0 && !veces; i--) {
			if ( num[i] >  num[i-1] && num[i]> num[i-2]) {
				switchValues(i, i-2);
				if(darNumero()>valor) {
					valorR--;
				}
				if (valorR == 0) {
					veces = true;
				}
				
			}
		System.out.println(darNumero());	
		}
		if (cont== num.length-1) {
			resp ="*";
		}
		else {
			resp = darNumero()+"";
		}
		return resp;
	}
	private static void switchValues (Integer valor1, Integer valor2) {
		char i1 = num[valor1];
		char i2 = num[valor2];
		num[valor1] = i2;
		num[valor2] = i1;
	}
	private static Integer darNumero(){
		String nuevo ="";
		for (int i = 0; i < num.length; i++) {
			nuevo= nuevo + num[i];
		}
		return Integer.parseInt(nuevo);
	}
	public static void imprimirPregunta() {
		System.out.println("---------ISIS 1105 - Diseño y Analisis de Algoritmos----------");
		System.out.println("---------------------Proyecto----------------------");
		System.out.println("Ingrese los valores para el segundo problema, K-sima siguiente permutación");
		System.out.println("de la forma <r k> donde 0 <= r <= 9 y k es entero ");
		System.out.println("Ej: 4 45676");
	}

}
