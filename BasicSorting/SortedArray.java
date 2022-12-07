import java.util.Arrays;

public class SortedArray {


    // Instance Variables
    int passes;
	int comparisons;
	int exchanges;

    SortedArray(int[] inputArray, int sortOption) {
        

    }
    


    //// SORTING ALGORITHMS



    //////// SORTING ALGORITHMS /////////


	//// Selection Sort
	public int[] selectionSort(int[] inputArray) {
		for (int i = 0; i < inputArray.length; i++) {
			int min = inputArray[i];
			int minId = i;
			for (int j = i+1; j < inputArray.length; j++) {
				comparisons += 1;			 // Increment comparisons
				if (inputArray[j] < min) {   // Comparison
					min = inputArray[j];
					minId = j;
				}
			}
			// Exchange
			int temp = inputArray[i];
			inputArray[i] = min;
			inputArray[minId] = temp;
			exchanges += 1; 		// Increment exchanges
		}

		return inputArray;
	}


	//// Bubble Sort
	public int[] bubbleSort(int[] inputArray) {
		boolean sorted = false;
		int temp;
		while (!sorted) {
			sorted = true;
			for (int i = 0; i < inputArray.length - 1; i++) {
				comparisons += 1;						   // Increment comparisons
				if (inputArray[i] > inputArray[i + 1]) {   // Comparison
					temp = inputArray[i];
					inputArray[i] = inputArray[i + 1];  // Exchange
					inputArray[i + 1] = temp;           // Exchange
					exchanges += 1;                     // Increment exchanges
					sorted = false;
				}
			}
			// Pass Complete
			passes += 1;   // Increment passes
		}
		return inputArray;
	}


	//// Insertion Sort
	public int[] insertionSort(int[] inputArray) {
		for (int i = 1; i < inputArray.length; i++) {
			int current = inputArray[i];
			int j = i - 1;
			while(j >= 0 && current < inputArray[j]) {  // Comparison
				comparisons += 1;
				inputArray[j+1] = inputArray[j];    // Exchange
				j--;								// Exchange
				exchanges += 1;    // Increment exchanges
			}
			// j is either -1
			// or it's at the first element where current >= a[j]
			inputArray[j+1] = current;

			// Pass complete
			passes += 1;    // Increment passes
		}
		return inputArray;
	}




}
