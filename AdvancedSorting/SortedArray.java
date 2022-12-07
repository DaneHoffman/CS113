import java.util.Arrays;

public class SortedArray {		// Takes in an int array and a sorting option. Produces object which contains sorted array + performance stats
	
	// Default Variables
	public static final int[] INT_ARRAY = { 40, 35, 80, 75, 60, 90, 70, 75, 50, 22 };


    // Instance Variables
	int passes;
	int comparisons;
	int exchanges;
	String sortType;
	int[] sortedIntArray;

	// Full Constructor
    SortedArray(int[] inputArray, int sortOption) throws IllegalArgumentException {
		int[] arrayToSort = Arrays.copyOf(inputArray, inputArray.length); // Deep copies input array

		if (arrayToSort == null) {
			throw new IllegalArgumentException("Null input array");
		}
        
		switch (sortOption) {          // Passes inputArray to sorting algorithm depending on option
			case 1:  // Selection Sort
				sortType = "Selection Sort";
				this.sortedIntArray = selectionSort(arrayToSort);
				break;
			case 2:  // Bubble Sort
				sortType = "Bubble Sort";
				this.sortedIntArray = bubbleSort(arrayToSort);
				break;
			case 3:  // Insertion Sort
				sortType = "Insertion Sort";
				this.sortedIntArray = insertionSort(arrayToSort);
				break;
			default:
				throw new IllegalArgumentException("Invalid Sorting Option");
		}

    }

	// Sort Option Only Constructor, uses default array
	SortedArray(int sortOption) {
		int[] arrayToSort = Arrays.copyOf(INT_ARRAY, INT_ARRAY.length); // Deep copies input array

		switch (sortOption) {          // Passes inputArray to sorting algorithm depending on option
			case 1:  // Selection Sort
				sortType = "Selection Sort";
				this.sortedIntArray = selectionSort(arrayToSort);
				break;
			case 2:  // Bubble Sort
				sortType = "Bubble Sort";
				this.sortedIntArray = bubbleSort(arrayToSort);
				break;
			case 3:  // Insertion Sort
				sortType = "Insertion Sort";
				this.sortedIntArray = insertionSort(arrayToSort);
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
		return this.sortType;
	}

	// toString
	public String toString() {
		return Arrays.toString(this.sortedIntArray);
	}
    


    //////// SORTING ALGORITHMS /////////


	//// Selection Sort
	public int[] selectionSort(int[] arrayToSort) {
		for (int i = 0; i < arrayToSort.length; i++) {
			int min = arrayToSort[i];
			int minId = i;
			for (int j = i+1; j < arrayToSort.length; j++) { // Pass Start
				comparisons += 1;			 // Increment comparisons
				if (arrayToSort[j] < min) {   // Comparison
					min = arrayToSort[j];
					minId = j;
				}
			}
			// Pass Complete
			passes += 1;

			// Exchange
			int temp = arrayToSort[i];
			arrayToSort[i] = min;
			arrayToSort[minId] = temp;
			exchanges += 1; 		// Increment exchanges
		}

		return arrayToSort;
	}


	//// Bubble Sort
	public int[] bubbleSort(int[] arrayToSort) {
		boolean sorted = false;
		int temp;
		while (!sorted) {
			sorted = true;
			for (int i = 0; i < arrayToSort.length - 1; i++) {
				comparisons += 1;						   // Increment comparisons
				if (arrayToSort[i] > arrayToSort[i + 1]) {   // Comparison
					temp = arrayToSort[i];
					arrayToSort[i] = arrayToSort[i + 1];  // Exchange
					arrayToSort[i + 1] = temp;           // Exchange
					exchanges += 1;                     // Increment exchanges
					sorted = false;
				}
			}
			// Pass Complete
			passes += 1;   // Increment passes
		}
		return arrayToSort;
	}


	//// Insertion Sort
	public int[] insertionSort(int[] arrayToSort) {
		for (int i = 1; i < arrayToSort.length; i++) {
			int current = arrayToSort[i];
			int j = i - 1;
			while(j >= 0 && current < arrayToSort[j]) {  // Comparison
				comparisons += 1;
				arrayToSort[j+1] = arrayToSort[j];    // Exchange
				j--;								// Exchange
				exchanges += 1;    // Increment exchanges
			}
			// j is either -1
			// or it's at the first element where current >= a[j]
			arrayToSort[j+1] = current;

			// Pass complete
			passes += 1;    // Increment passes
		}
		return arrayToSort;
	}




}
