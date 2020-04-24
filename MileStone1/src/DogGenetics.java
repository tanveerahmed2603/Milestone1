
import java.util.Random;
import java.util.Scanner;

public class DogGenetics {

	static String[] breedNames = { "St. Bernard", "Chihuahua", "Dramatic RedNosed Asian Pug", "Common Cur",
			"King Doberman" };
	static int[] breedPercent = new int[breedNames.length];
	static int totalPercent = 0;
	static Scanner input = new Scanner(System.in);

	public static int generateRandomNumber() {
		Random random = new Random();
		return random.nextInt(100) + 1;
	}

	public static void printDogInfo(String[] breedNames, int[] breedPercent) {
		for (int index = 0; index < breedNames.length; index++) {
			System.out.println(breedPercent[index] + "% " + breedNames[index]);
		}
		System.out.println("Wow, that's QUITE the dog!");
	}

	public static void initializeDogGenetics() {
		for (int index = 0; index < breedNames.length; index++) {

			if (totalPercent < 100) {
				int number = generateRandomNumber();
				totalPercent += number;
				while (totalPercent > 100) {
					totalPercent -= number;
					number = generateRandomNumber();
					totalPercent += number;
				}
				breedPercent[index] = number;
			} else {
				break;
			}
		}
	}

	public static void main(String[] args) {

		System.out.println("What is your dog's name?");
		String dogName = input.next();
		System.out.println(
				"Well then, I have this highly reliable report on " + dogName + " prestigious background right here.");
		/*
		 * multiple times generate random numbers for all the values of the breeds in
		 * array add them up in the totalPrecent run the loop until totalPrecent is not
		 * ! = 100 each time we generate a number we need to subtract 100 - totalPrecent
		 * to make sure we don't get out of bounds, if we do we need to re-generate the
		 * number again (so use a while loop here)
		 */

		initializeDogGenetics();
		printDogInfo(breedNames, breedPercent);

	}
}
