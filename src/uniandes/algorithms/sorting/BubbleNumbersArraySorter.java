package uniandes.algorithms.sorting;

/**
 * Implements the bubble sort algorithm for number arrays
 */
public class BubbleNumbersArraySorter implements NumbersArraySorter {

	@Override
	public void sort(double[] numbers) {
		// TODO Implement
		int tamañoArreglo = numbers.length;

		double temp = 0;

		for (int i = 0; i<tamañoArreglo; i++)
		{

			// se hace swap hasta el elemento más grande no ordenado 
			for(int j = 1; j<(tamañoArreglo-i) ; j++)
			{

				if(numbers[j-1] > numbers[j])
				{
					// se hace el swap
					temp = numbers[j-1];
					
					numbers[j-1]= numbers[j];
					
					numbers[j] = temp;
					
					
				}

			}

		}



	}

}
