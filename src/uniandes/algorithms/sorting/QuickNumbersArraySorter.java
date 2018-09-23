package uniandes.algorithms.sorting;

/**
 * Implements the quick sort algorithm for number arrays
 */
public class QuickNumbersArraySorter implements NumbersArraySorter {

	@Override
	public void sort(double[] numbers) {
		// TODO Implement
        sort(numbers, 0, numbers.length - 1);
        assert isSorted(numbers);
		
	}

	
    // quicksort the subarray from a[lo] to a[hi]
    private  void sort(double[] numbers, int lo, int hi) { 
        if (hi <= lo) return;
        int j = partition(numbers, lo, hi);
        sort(numbers, lo, j-1);
        sort(numbers, j+1, hi);
        assert isSorted(numbers, lo, hi);
    }

    // partition the subarray a[lo..hi] so that a[lo..j-1] <= a[j] <= a[j+1..hi]
    // and return the index j.
    private  int partition(double[] numbers, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        double v = numbers[lo];
        while (true) { 

            // find item on lo to swap
            while (less(numbers[++i], v)) {
                if (i == hi) break;
            }

            // find item on hi to swap
            while (less(v, numbers[--j])) {
                if (j == lo) break;      // redundant since a[lo] acts as sentinel
            }

            // check if pointers cross
            if (i >= j) break;

            exch(numbers, i, j);
        }

        // put partitioning item v at a[j]
        exch( numbers, lo, j);

        // now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        return j;
    }

    /**
     * Rearranges the array so that {@code a[k]} contains the kth smallest key;
     * {@code a[0]} through {@code a[k-1]} are less than (or equal to) {@code a[k]}; and
     * {@code a[k+1]} through {@code a[n-1]} are greater than (or equal to) {@code a[k]}.
     *
     * @param  a the array
     * @param  k the rank of the key
     * @return the key of rank {@code k}
     * @throws IllegalArgumentException unless {@code 0 <= k < a.length}
     */
    public  double select(double[] numbers, int k) {
        if (k < 0 || k >= numbers.length) {
            throw new IllegalArgumentException("index is not between 0 and " + numbers.length + ": " + k);
        }
       
        int lo = 0, hi = numbers.length - 1;
        while (hi > lo) {
            int i = partition(numbers, lo, hi);
            if      (i > k) hi = i - 1;
            else if (i < k) lo = i + 1;
            else return numbers[i];
        }
        return numbers[lo];
    }



   /***************************************************************************
    *  Helper sorting functions.
    ***************************************************************************/
    
    // is v < w ?
    private  boolean less(double v, double w) {
        if (v == w) return false;   // optimization when reference equals
        return v < w;
    }
        
    // exchange a[i] and a[j]
    private  void exch(double[] numbers, int i, int j) {
        double swap = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = swap;
    }


   /***************************************************************************
    *  Check if array is sorted - useful for debugging.
    ***************************************************************************/
    private  boolean isSorted(double[] numbers) {
        return isSorted(numbers, 0, numbers.length - 1);
    }

    private  boolean isSorted(double[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }


   

}
