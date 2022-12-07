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

			System.out.println("\nChoose a sorting algorithm: ");
			System.out.println("1. Selection Sort");
			System.out.println("2. Bubble Sort");
			System.out.println("3. Insertion Sort");
			System.out.println("4. Exit Program\n");

			System.out.print("Enter: ");
			choiceEntry = input.nextInt();

			if (choiceEntry >= 1 && choiceEntry <= 3) {

				// Pass option to SortedArray class 
				SortedArray sortedArray = new SortedArray(intArray, choiceEntry);

				System.out.println("\n\n------------------------------------------------");
				System.out.println("Array sorted with " + sortedArray.getSortType() + ": " + sortedArray.toString());
				System.out.println("------------------------------------------------");
				System.out.println("Performance: ");
				System.out.println("--------------");
				System.out.println("Passes:" + sortedArray.getPasses());
				System.out.println("Comparisons:" + sortedArray.getComparisons());
				System.out.println("Exchanges:" + sortedArray.getExchanges());

				

			} else if (choiceEntry != 4) {
				System.out.println("Choice must be a value between 1 and 4.");
			} 

		} while (choiceEntry != 4);
		input.close();

		

	}



}