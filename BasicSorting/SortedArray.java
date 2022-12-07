import java.util.Arrays;

public class SortedArray {


    // Instance Variables
    int passes;
	int comparisons;
	int exchanges;

    SortedArray(int[] inputArray, int sortOption) {
        

    }
    


    //// SORTING ALGORITHMS

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




}
