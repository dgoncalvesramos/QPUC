package org.qpuc;

import java.util.Scanner;

public class Game {
    private boolean isRunning = true;
    private final Scanner scanner = new Scanner(System.in);
    private Character character ;

    public void start() {
        this.character = new Character();
        System.out.println("****** Welcome to the QPUC Game ******\n" +
                "In this game you have to find a famous character based on clues !");
        while (isRunning) {
            System.out.println("Choose a difficulty : (1) Easy, (2) Normal, (3) Hard, (4) Crazy");
            String input = scanner.nextLine();
            handleInput(input);
        }

    }

    private void handleInput(String input) {
        switch (input) {
            case "1" -> {
                System.out.println("You choose easy difficulty. You have 5 clues for finding your character !");
                launchEasyDiffulcty();
                isRunning = false;
            }
            case "2" -> {
                System.out.println("You choose normal difficulty. You have 4 clues for finding your character !");
                launchNormalDifficulty();
                isRunning = false;
            }
            case "3" -> {
                System.out.println("You choose hard difficulty. You have 3 clues for finding your character !");
                launchHardDifficulty();
                isRunning = false;
            }
            case "4" -> {
                System.out.println("You choose crazy difficulty.You have 1 clue for finding your character !");
                launchCrazyDifficulty();
                isRunning = false;
            }
            default -> System.out.println("Invalid choice. Try again.");
        }
    }

    private void launchEasyDiffulcty(){System.out.println("Not yet implemented");}
    private void launchNormalDifficulty(){System.out.println("Not yet implemented");};
    private void launchHardDifficulty(){System.out.println("Not yet implemented");};
    private void launchCrazyDifficulty(){System.out.println("Not yet implemented");};

}
