package Problemas;

public class Punto1 
{
	public static int longitudSubArregloMasLargo(Integer[] numeros, int c)
	{
		
		int answer = 0;
		int numCeros = 0;
		Integer[] posiciones;
		//Se sacan la cantidad de 0 que hay
		for(int i = 0; i < numeros.length; i++)
		{
			if(numeros[i] == 0)
			{
				numCeros++;
			}
		}
		posiciones = new Integer[numCeros];
		//Se guardan las posiciones en las que hay 0
		for(int i = 0, j = 0; i < numeros.length; i++)
		{
			if(numeros[i] == 0)
			{
				posiciones[j] = i;
				j++;
			}
		}
		if(c >= numCeros)
		{
			return numeros.length;
		}
		//Se busca la pareja con mayor diferencia
	
		for(int i = c - 1, a = 0; i < posiciones.length; i++, a++)
		{
			Integer current = posiciones[i] - posiciones[a] + 1;
			if(a - 1 > - 1)
			{
				current += posiciones[a] - posiciones[a - 1] - 1;
			}
			if(a - 1 <= - 1)
			{
				current += posiciones[a];
			}
			if(i + 1 < posiciones.length)
			{
				current += posiciones[i + 1] - posiciones[i] - 1;
			}
			if(i + 1 >= posiciones.length)
			{
				current += numeros.length - posiciones[i] - 1;
			}
			if( current > answer)
			{
				answer = current;
			}
			System.out.println(posiciones[a] + " y " + posiciones[i] + " da: " + current);
		}
		return answer;
	}
	public final static void main(String[] args)
	{
		Integer[] test = {12,0,-3,0,0,1,2,3,4,0,4,5,23,0,100};
		System.out.println(longitudSubArregloMasLargo(test, 4));
	}
	public static void imprimirPregunta() {
		System.out.println("---------ISIS 1105 - Diseño y Analisis de Algoritmos----------");
		System.out.println("---------------------Proyecto----------------------");
		System.out.println("Ingrese los valores para el primer problema, K-sima siguiente permutaci�n");
		System.out.println("Primero ingrese");
		System.out.println("Ej: 4 45676");
	}
}
