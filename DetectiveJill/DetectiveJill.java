import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class DetectiveJill {

    public static void main() {
		// DECLARATION + INITIALIZATION
        int answerSet, solution, murder, weapon, location;
        Theory answer;
		Theory currentTheory;
        AssistantJack jack;
        Scanner keyboard = new Scanner(System.in);
        Random random = new Random();
		ArrayList<Theory> pastGuesses = new ArrayList<Theory>();

        // INPUT
        System.out.print("Which theory would like you like to test? (1, 2, 3[random]): ");
        answerSet = keyboard.nextInt();
        keyboard.close();

        // PROCESSING
        jack = new AssistantJack(answerSet);
		

        // do {
        //     weapon = random.nextInt(6) + 1;
        //     location = random.nextInt(10) + 1;
        //     murder = random.nextInt(6) + 1;
        //     solution = jack.checkAnswer(weapon, location, murder);
        // } while (solution != 0);

		// Start with random guesses
		weapon = random.nextInt(6) + 1;
        location = random.nextInt(10) + 1;
        murder = random.nextInt(6) + 1;
		
		currentTheory = new Theory(weapon, location, murder);
			
		solution = jack.checkAnswer(weapon, location, murder);


		
		


		// Process of elimination loop
		while (solution != 0) {
			// Add current (incorrect) theory to past guesses ArrayList
			currentTheory = new Theory(weapon, location, murder);
			pastGuesses.add(jack.getTimesAsked() - 1, currentTheory);

			

			switch(solution) {
				case 0:  // Theory is correct
					break;
				case 1:  // Weapon is incorrect
					if (weapon < 6) {  // Increment weapon by 1 if weapon is within range
						weapon++;
					} else {           // Otherwise, reset weapon
						
						weapon = 1;
					}
					break;
				case 2:  // Location is incorrect
					if (location < 10) {  // Increment location by 1 if location is within range
						location++;
					} else {           // Otherwise, reset location
						
						location = 1;
					}
					break;
				case 3:  // Murder is incorrect
					if (murder < 6) {  // Increment murder by 1 if murder is within range
						murder++;
					} else {           // Otherwise, reset murder
						
						murder = 1;
					}
					break;
				default:
					break;
			}

			
			solution = jack.checkAnswer(weapon, location, murder);
		}

		answer = new Theory(weapon, location, murder);

		

        // OUTPUT
        System.out.println("Total Checks = " + jack.getTimesAsked() + ", Solution " + answer);

        if (jack.getTimesAsked() > 20) {
            System.out.println("FAILED!! You're a horrible Detective...");
        } else {
            System.out.println("WOW! You might as well be called Batman!");
        }

		pastGuesses.add(answer);
		// Print all guesses
		for (int i = 0; i < pastGuesses.size(); i++) {
			System.out.println((i + 1) + ". " + pastGuesses.get(i).toString());
		}

		
    }
}