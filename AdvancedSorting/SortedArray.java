import java.util.Arrays;

public class SortedArray {		// Takes in an int array and a sorting option. Produces object which contains sorted array + performance stats
	
	// Default Variables
	public static final int[] INT_ARRAY = { 40, 35, 80, 75, 60, 90, 70, 75, 50, 22 };


    // Instance Variables
	int passes;
	int comparisons;
	int exchanges;
	String sortName;
	int[] sortedIntArray;

	// Full Constructor
    SortedArray(int[] inputArray, int sortOption) throws IllegalArgumentException {
		int[] arrayToSort = Arrays.copyOf(inputArray, inputArray.length); // Deep copies input array

		if (arrayToSort == null) {
			throw new IllegalArgumentException("Null input array");
		}
        
		switch (sortOption) {          // Passes inputArray to sorting algorithm depending on option
			case 1:  // Merge Sort
				sortName = "Merge Sort";
				mergeSort(arrayToSort, 0, arrayToSort.length - 1);
				sortedIntArray = arrayToSort;
				break;
			case 2:  // Heap Sort
				sortName = "Heap Sort";
				heapSort(arrayToSort);
				sortedIntArray = arrayToSort;
				break;
			case 3:  // Quick Sort
				sortName = "Quick Sort";
				quicksort(arrayToSort, 0, arrayToSort.length - 1);
				sortedIntArray = arrayToSort;
				break;
			default:
				throw new IllegalArgumentException("Invalid Sorting Option");
		}

    }

	// Sort Option Only Constructor, uses default array
	SortedArray(int sortOption) {
		int[] arrayToSort = Arrays.copyOf(INT_ARRAY, INT_ARRAY.length); // Deep copies input array

		switch (sortOption) {          // Passes inputArray to sorting algorithm depending on option
			case 1:  // Merge Sort
				sortName = "Merge Sort";
				mergeSort(arrayToSort, 0, arrayToSort.length - 1);
				sortedIntArray = arrayToSort;
				break;
			case 2:  // Heap Sort
				sortName = "Heap Sort";
				heapSort(arrayToSort);
				sortedIntArray = arrayToSort;
				break;
			case 3:  // Quick Sort
				sortName = "Quick Sort";
				quicksort(arrayToSort, 0, arrayToSort.length - 1);
				sortedIntArray = arrayToSort;
				break;
			default:
				throw new IllegalArgumentException("Invalid Sorting Option");
		}
	}

	// Getters
	public int getPasses() {
		return this.passes;
	}

	public int getComparisons() {
		return this.comparisons;
	}

	public int getExchanges() {
		return this.exchanges;
	}

	public int[] getSortedArray() {
		return this.sortedIntArray;
	}

	public String getSortType() {
		return this.sortName;
	}

	// toString
	public String toString() {
		return Arrays.toString(this.sortedIntArray);
	}
    


    //////// SORTING ALGORITHMS /////////


	//// Merge Sort
	public void mergeSort(int[] array, int left, int right) {
		comparisons++;
		if (right <= left) return;  										// Comparison
		int mid = (left+right)/2;											// Exchange
		exchanges++;
		mergeSort(array, left, mid);
		mergeSort(array, mid+1, right);
		merge(array, left, mid, right);
		passes++;
	}

	// Merge method
	void merge(int[] array, int left, int mid, int right) {
		// calculating lengths
		int lengthLeft = mid - left + 1;
		int lengthRight = right - mid;
	
		// creating temporary subarrays
		int leftArray[] = new int [lengthLeft];
		int rightArray[] = new int [lengthRight];
	
		// copying our sorted subarrays into temporaries
		for (int i = 0; i < lengthLeft; i++)
			leftArray[i] = array[left+i];							// Exchange
			exchanges++;
		for (int i = 0; i < lengthRight; i++)
			rightArray[i] = array[mid+i+1];							// Exchange
			exchanges++;
	
		// iterators containing current index of temp subarrays
		int leftIndex = 0;
		int rightIndex = 0;
	
		// copying from leftArray and rightArray back into array
		for (int i = left; i < right + 1; i++) {
			// if there are still uncopied elements in R and L, copy minimum of the two
			comparisons++;
			if (leftIndex < lengthLeft && rightIndex < lengthRight) {					// Comparison
				comparisons++;
				if (leftArray[leftIndex] < rightArray[rightIndex]) {					// Comparison
					array[i] = leftArray[leftIndex];									// Exchange
					leftIndex++;
					exchanges++;
				}
				else {
					array[i] = rightArray[rightIndex];									// Exchange
					rightIndex++;
					exchanges++;
				}
			}
			// if all the elements have been copied from rightArray, copy the rest of leftArray
			else if (leftIndex < lengthLeft) {	
				comparisons++;										// Comparison
				array[i] = leftArray[leftIndex];										// Exchange
				leftIndex++;
				exchanges++;
			}
			// if all the elements have been copied from leftArray, copy the rest of rightArray
			else if (rightIndex < lengthRight) {
				comparisons++;										// Comparison
				exchanges++;
				array[i] = rightArray[rightIndex];										// Exchange
				rightIndex++;
			}
		}
	}


	//// Heap Sort
	public void heapSort(int[] array) {
		if (array.length == 0) {
			return;
		}
		
		int length = array.length;
		
		// Moving from the first element that isn't a leaf towards the root
		for (int i = length / 2 - 1; i >= 0; i--) {
			heapify(array, length, i);
			passes++;
		}
		
		for (int i = length - 1; i >= 0; i--) {
			int tmp = array[0];
			array[0] = array[i];
			array[i] = tmp;
			heapify(array, i, 0);
			passes++;
		}
	}


	private void heapify(int[] array, int length, int i) {
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		int largest = i;
		
		comparisons++;
		if (left < length && array[left] > array[largest]) {					// Comparison
			largest = left;														// Exchange
			exchanges++;
		}

		comparisons++;
		if (right < length && array[right] > array[largest]) {					// Comparison
			largest = right;													// Exchange
			exchanges++;
		}
		comparisons++;
		if (largest != i) {														// Comparison
			int tmp = array[i];
			array[i] = array[largest];
			array[largest] = tmp;												// Exchange
			exchanges++;
			heapify(array, length, largest);
		}
	}

	


	//// Quick Sort
	public void quicksort(int[] arr, int low, int high){
		comparisons++;
		if(low < high){												// Comparison
			int p = partition(arr, low, high);
			quicksort(arr, low, p-1);
			quicksort(arr, p+1, high);
			passes++;
		}
	}

	private int partition(int[] arr, int low, int high){
		int p = low, j;												// Exchange
		exchanges++;
		for(j=low+1; j <= high; j++) {
			comparisons++;
			if(arr[j] < arr[low]) {									// Comparison
				swap(arr, ++p, j);									// Exchange
				exchanges++;
			}	
		}
		
				
	
		swap(arr, low, p);											// Exchange
		exchanges++;
		return p;
	}

	private void swap(int[] arr, int low, int pivot){
		int tmp = arr[low];
		arr[low] = arr[pivot];									
		arr[pivot] = tmp;
	}

	




}
