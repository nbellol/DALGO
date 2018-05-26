package Problemas;

public class Punto1 
{
	public static int longitudSubArregloMasLargo (String cadena )
	{	
		//Preparación de los datos
		String[] numeros = cadena.split(" ");
		int n = Integer.parseInt(numeros[0]);
		int c = Integer.parseInt(numeros[1]);
		int answer = 0;
		int numCeros = 0;
		Integer[] posiciones;
		//Se sacan la cantidad de 0 que hay
		for(int i = 2; i < n + 2; i++)
		{
			if(numeros[i].equals("0"))
			{
				numCeros++;
			}
		}
		posiciones = new Integer[numCeros];
		//Se guardan las posiciones en las que hay 0
		for(int i = 2, j = 0; i < n + 2; i++)
		{
			if(numeros[i].equals("0"))
			{
				posiciones[j] = i - 2;
				j++;
			}
		}
		if(c >= numCeros)
		{
			return n;
		}
		//Se busca el rango con mayor diferencia

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
				current += numeros.length - posiciones[i] - 3;
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
		String test = "15 2 12 0 -3 0 0 1 2 3 4 0 4 5 23 0 100";
		System.out.println("Respuesta");
		System.out.println(longitudSubArregloMasLargo(test));
	}
	public static void imprimirPregunta() {
		System.out.println("---------ISIS 1105 - Diseño y Analisis de Algoritmos----------");
		System.out.println("---------------------Proyecto----------------------");
		System.out.println("Ingrese los valores para el primer problema, subcadena más larga con a lo sumo c cantidad de ceros");
		System.out.println("Primero ingrese el tamanio del arreglo, luego el número de ceros,");
		System.out.println("Seguido de la cadena que se quiere separada por espacios");
		System.out.println("(e.g. 15 3 12 0 -3 0 0 1 2 3 4 0 4 5 23 0 100 \n donde 10 es el tamaño, 3 la cantidad de ceros y el resto hace referencia al arreglo)");
	}
}
