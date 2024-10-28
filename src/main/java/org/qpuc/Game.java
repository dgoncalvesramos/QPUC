package org.qpuc;

import java.util.Scanner;

import static java.lang.System.exit;

public class Game {
    private boolean isRunning = true;
    private final Scanner scanner = new Scanner(System.in);
    private Character character ;
    private int nb_attempts;

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
                System.out.println("You choose normal difficulty. You have 5 clues for finding your character !");
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

    private void launchEasyDiffulcty(){
        nb_attempts=5;
        System.out.println("The character has been " + StringModifierService.removeLanguageTag(this.character.position_held.get(0)));
        handleResponse();
        System.out.println(this.character.getDate_of_birth());
        handleResponse();
    }

    private void handleResponse(){
        System.out.println("Who do you think the character is ?");
        Scanner sc = new Scanner(System.in);
        String input = StringModifierService.addUnderscoreBetweenBlanksAndPutItInUppercase(sc.nextLine());
        if(input.compareTo(this.character.getName()) == 0) {
            System.out.println("Congratulations ! You win after : " + nb_attempts + " attempts !");
            System.exit(0);
        }
        else{
            nb_attempts--;
        }
    }

    private void launchNormalDifficulty(){System.out.println("Not yet implemented");};
    private void launchHardDifficulty(){System.out.println("Not yet implemented");};
    private void launchCrazyDifficulty(){System.out.println("Not yet implemented");};

}
