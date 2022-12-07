import java.util.Arrays;
import java.util.Scanner;

class Main {
	public static void main(String[] args) {

		final int[] intArray = { 40, 35, 80, 75, 60, 90, 70, 75, 50, 22 };

		Scanner input = new Scanner(System.in);
		int choiceEntry;

		///////// MAIN MENU loop
		do {
			System.out.println("**************************** MAIN MENU ****************************");
			System.out.print("Default array: ");

			System.out.println(Arrays.toString(intArray));

			System.out.println("\nOptions: ");
			System.out.println("1. Sort with BubbleSort");
			choiceEntry = input.nextInt();
			switch (choiceEntry) {
				case 1: // Bubble Sort
					System.out.println(Arrays.toString(bubbleSort(intArray)));
					break;
				case 2:
					// ..something else
					break;
				case 3:
					// .. exit program
					break;
				case 4: 
					// Exit menu loop
					break;
				default:
					System.out.println("Choice must be a value between 1 and 4.");
			}
		} while (choiceEntry != 4);
		input.close();

	}

	//// SORTING ALGORITHMS

	// Bubble Sort
	public static int[] bubbleSort(int[] inputArray) {
		boolean sorted = false;
		int temp;
		while (!sorted) {
			sorted = true;
			for (int i = 0; i < inputArray.length - 1; i++) {
				if (inputArray[i] > inputArray[i + 1]) {
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