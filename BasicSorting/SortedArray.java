import java.util.Arrays;

public class SortedArray {


    // Instance Variables
    int passes;
	int comparisons;
	int exchanges;

    SortedArray(int[] inputArray, int sortOption) {
        

    }
    


    //// SORTING ALGORITHMS


	// Selection Sort
	public static int[] selectionSort(int[] inputArray) {
		for (int i = 0; i < inputArray.length; i++) {
			int min = inputArray[i];
			int minId = i;
			for (int j = i+1; j < inputArray.length; j++) {
				if (inputArray[j] < min) {
					min = inputArray[j];
					minId = j;
				}
			}
			// swapping
			int temp = inputArray[i];
			inputArray[i] = min;
			inputArray[minId] = temp;
		}

		return inputArray;
	}


	// Bubble Sort
	public static int[] bubbleSort(int[] inputArray) {
		boolean sorted = false;
		int temp;
		while (!sorted) {
			sorted = true;
			for (int i = 0; i < inputArray.length - 1; i++) {
				if (inputArray[i] > inputArray[i + 1]) {   // Comparison
					temp = inputArray[i];
					inputArray[i] = inputArray[i + 1];
					inputArray[i + 1] = temp;
					sorted = false;
				}
			}
		}
		return inputArray;
	}

	// Insertion Sort

	public static int[] insertionSort(int[] inputArray) {
		for (int i = 1; i < inputArray.length; i++) {
			int current = inputArray[i];
			int j = i - 1;
			while(j >= 0 && current < inputArray[j]) {
				inputArray[j+1] = inputArray[j];
				j--;
			}
			// j is either -1
			// or it's at the first element where current >= a[j]
			inputArray[j+1] = current;
		}
		return inputArray;
	}




}
