import java.util.Scanner;

public class HealthyHearts {
	public static void main(String[] args) {
		/*
		 * What is your age? 50 Your maximum heart rate should be 170 beats per minute
		 * Your target HR Zone is 85 - 145 beats per minute
		 */
		Scanner input = new Scanner(System.in);
		System.out.print("What is your age?");
		int age = input.nextInt();

		int maxHeartRate = 220 - age;

		int minHrZone = ((maxHeartRate * 50) / 100);
		int maxHrZone = ((maxHeartRate * 85) / 100);

		System.out.println("Your maximum heart rate should be " + maxHeartRate + " beats per minute");
		System.out.println("Your target HR Zone is " + Math.round(minHrZone) + " - " + Math.round(maxHrZone)
				+ " beats per minute");

	}

}
