import java.util.Scanner;
/*
 * Esta clase presenta la solucion al Problema a donde se encontrar� el 
 * subarreglo mas largo con un numero maximo de ceros donde se recibe un
 * arreglo numerico y un c que representa el numero maximo de  ceros que 
 * puede tener el arreglo 
 * 
 * authors
 * @nbellol - n.bello - 201630593
 * @ngaitan98 - n.gaitan -201631098
 */
public class ProblemaA 
{
	//---------------------------------------------------------------------------------------------
	// Metodos
	//---------------------------------------------------------------------------------------------
	/*
	 * En este metodo se obtiene longituf sub arregla mas Largo
	*/
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

		for(int i = c - 1, a = 0; i < numCeros; i++, a++)
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
			if(i + 1 < numCeros)
			{
				current += posiciones[i + 1] - posiciones[i] - 1;
			}
			if(i + 1 >= numCeros)
			{
				current += n - posiciones[i] - 1;
			}
			if( current > answer)
			{
				answer = current;
			}
		}
		return answer;
	}
	//---------------------------------------------------------------------------------------------
	// Metodo MAIN
	//---------------------------------------------------------------------------------------------
	/*
	 * aqui se resuelve el problema A
	 */
	public final static void main(String[] args)
	{
		imprimirPregunta();
		String test = (new Scanner(System.in)).nextLine();
		System.out.println("Respuesta:");
		System.out.println(longitudSubArregloMasLargo(test));
	}
	 /*
	  * Este metodo Imprime la pregunta para el usuario
	  */
	public static void imprimirPregunta() {
		System.out.println("---------ISIS 1105 - Diseño y Analisis de Algoritmos----------");
		System.out.println("-------------------------  Proyecto  -------------------------");
		System.out.println("Ingrese los valores para el primer problema, subcadena más larga con a lo sumo c cantidad de ceros");
		System.out.println("Primero ingrese el tamanio del arreglo, luego el número de ceros, finalizando con los datos del arreglo");
		System.out.println("Por ejemplo: 15 3 12 0 -3 0 0 1 2 3 4 0 4 5 23 0 100\nDonde 10 es el tamaño, 3 la cantidad de ceros y el resto hace referencia al arreglo");
	}
}
