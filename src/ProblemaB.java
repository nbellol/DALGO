
import java.util.Arrays;
import java.util.Scanner;

public class ProblemaB {
	public static char[] num;
	private static Long R;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		imprimirPregunta();
		String option = sc.nextLine();
		String data[] = option.split(" ");

		R = Long.parseLong(data[0]);
		num = data[1].toCharArray();

		Integer cont =0;
		Integer[] datos;
		datos = new Integer[num.length];

		String resp="";
		String t ="";

		for (int i = 0; i < num.length; i++) {
			datos[i] = Integer.parseInt(num[i]+"");
			if (i+1<num.length) {
				if (num[i]>=num[i+1]) {cont++;}
			}
		}
		if (cont== num.length-1) {
			System.out.println("*");
		}
		else {
			while (R>0) {
				permut(datos);
				R--;
			}
			for (int j = 0; j < datos.length; j++) {
				resp = resp + datos[j];
			}
			System.out.println(resp);
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
		
		Integer borde =posMin +1;

		temp= new int[dato.length -(borde)];
		if (temp.length != 1) {
			if (borde + temp.length != dato.length )
			{
				borde = borde -1;
			}
			for (int i = borde; i < dato.length; i++) {
				temp[i-(borde)] = dato[i];
			}
			Arrays.sort(temp);
			for (int i = borde; i < dato.length; i++) {
				dato[i] = temp[i-borde];
			}
		}

	}

	public static void imprimirPregunta() {
		System.out.println("---------ISIS 1105 - Dise�o y Analisis de Algoritmos----------");
		System.out.println("---------------------Proyecto----------------------");
		System.out.println("Ingrese los valores para el segundo problema, K-sima siguiente permutaci�n");
		System.out.println("de la forma <r k> donde 0 <= r <= 9 y k es entero ");
		System.out.println("Ej: 1 123542");
	}
}
