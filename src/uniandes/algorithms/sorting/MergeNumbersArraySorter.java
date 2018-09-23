package uniandes.algorithms.sorting;

/**
 * Implements the merge sort algorithm for number arrays
 */
public class MergeNumbersArraySorter implements NumbersArraySorter {

	@Override
	public void sort(double[] numbers) {
		// TODO Implement
		System.out.println(numbers.length+"");
		for(int i = 0; i< numbers.length;i++) System.out.println(numbers[i]);
		numbers = mergeSort(numbers);

	}

	public double[] mergeSort(double[] numbersUnsorted)
	
	{
		int tamañoArreglo =numbersUnsorted.length;

		// si el arreglo solo tiene un elemento no se debe ordenar
		if(tamañoArreglo <= 1) return numbersUnsorted;

		// se crean los dos arrglos de partición
		double[] izq = new double[tamañoArreglo/2];

		double[] der = new double[tamañoArreglo-tamañoArreglo/2];

		// se llena el arreglo izq con la información orginial
		for(int i = 0; i< izq.length; i++) izq[i] = numbersUnsorted[i];

		for(int i = 0; i< der.length; i++) der[i] = numbersUnsorted[i+ tamañoArreglo/2];


		return merge(mergeSort(izq),mergeSort(der));

	}

	public double[] merge(double[] izq , double [] der)
	
	{
		double [] newArr = new double[izq.length+der.length];

		int i = 0, j = 0;

		for(int k = 0; k<newArr.length; k++)
		{
			if (i >= izq.length) newArr[k] = der[j++];
			
			else if (j >= der.length) newArr[k] = izq[i++];
			
			else if (izq[i] <= der[j])  newArr[k] = izq[i++];
			
			else newArr[k] = der[j++];
		}

		return newArr;
	}
}
