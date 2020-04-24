

import java.util.Random;
import java.util.Scanner;

public class paper_rock_scissors_game {

    static Scanner input = new Scanner(System.in);
    static int roundTies = 0;
    static int userWins = 0;
    static int computerWins = 0;

    private enum Winner {
        USER, COMPUTER, TIE, DEFAULT
    }

    public static int getUserChoice() {
        System.out.println("What's your choice? Input 1 for Rock, 2 for Paper, 3 for Scissors");
        int userChoice = input.nextInt();
        while (userChoice < 1 || userChoice > 3) {
            System.out.println("---------------------------- ERROR! ----------------------------");
            System.out.println("Invalid choice of operation! --> Input 1 for Rock, 2 for Paper, 3 for Scissors");
            System.out.println("----------------------------------------------------------------");
            userChoice = input.nextInt();
        }
        return userChoice;
    }

    public static int getComputerChoice() {
        Random random = new Random();
        // nextInt generates a number from 0 to bound (in our case 3, exclusively)
        // so it would generate either 0, 1 or 2 and then we add 1 to have 1 2 and 3 as values generated
        return random.nextInt(3) + 1;
    }

    public static Winner playRound(int userChoice, int computerChoice) {
        // 1 - Rock
        // 2 - Paper
        // 3 - Scissors

        if (userChoice == computerChoice) {
            roundTies++;
            return Winner.TIE;
        } else {
            if (userChoice == 1) {
                if (computerChoice == 2) {
                    computerWins++;
                    return Winner.COMPUTER;
                }
                if (computerChoice == 3) {
                    userWins++;
                    return Winner.USER;
                }
            }
            if (userChoice == 2) {
                if (computerChoice == 1) {
                    userWins++;
                    return Winner.USER;
                }
                if (computerChoice == 3) {
                    computerWins++;
                    return Winner.COMPUTER;
                }
            }
            if (userChoice == 3) {
                if (computerChoice == 1) {
                    computerWins++;
                    return Winner.COMPUTER;
                }
                if (computerChoice == 2) {
                    userWins++;
                    return Winner.USER;
                }
            }
        }
        return Winner.DEFAULT;
    }

    public static String convertIntChoiceToString(int choice) {
        if (choice == 1) {
            return "Rock";
        } else if (choice == 2) {
            return "Paper";
        } else if (choice == 3) {
            return "Scissors";
        } else {
            return "";
        }
    }

    public static void playGame() {
        System.out.println("-------------------------------------------");
        System.out.println("How many rounds do you want to play? ");
        int rounds = input.nextInt();
        if (rounds < 1 || rounds > 10) {
            System.out.println("Error, number of rounds out of valid range!");
            System.exit(0);
        } else {
            int roundCounter = 0;
            while (roundCounter < rounds) {
                int userChoice = getUserChoice();
                int computerChoice = getComputerChoice();
                Winner roundWinner = playRound(userChoice, computerChoice);
                System.out.println("-----------------ROUND " + (roundCounter + 1) + "-----------------");
                System.out.println("User choice: " + convertIntChoiceToString(userChoice));
                System.out.println("Computer choice: " + convertIntChoiceToString(computerChoice));
                if (roundWinner == Winner.COMPUTER) {
                    System.out.println("Winner: COMPUTER!");
                } else if (roundWinner == Winner.USER) {
                    System.out.println("Winner: USER");
                } else {
                    System.out.println("It's a tie!");
                }
                roundCounter++;
            }
            System.out.println("******************** END OF "+roundCounter+" ROUNDS ********************");
            System.out.println("Number of user wins: " + userWins);
            System.out.println("Number of computer wins: " + computerWins);
            System.out.println("Number of ties: " + roundTies);
            if (userWins > computerWins) {
                System.out.println("Overall winner: USER!");
            } else if (computerWins > userWins) {
                System.out.println("Overall winner: COMPUTER!");
            } else {
                System.out.println("It's a tie!");
            }
            System.out.println("******************** END OF THE ROUNDS ********************");
            System.out.println("Would you like to play again? ");
            String userAnswer = input.next();
            if (userAnswer.equalsIgnoreCase("Yes")) {
                playGame();
            } else {
                System.out.println("Thanks for playing!");
                System.exit(0);
            }
        }


    }

    public static void main(String[] args) {
        playGame();
    }
}
