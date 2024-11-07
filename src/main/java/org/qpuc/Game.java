package org.qpuc;

import org.apache.jena.base.Sys;

import java.util.Scanner;

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
        nb_attempts=1;
        if(!this.character.getPosition_held().isEmpty())
            System.out.println("The character has been " + StringModifierService.removeLanguageTag(this.character.getPosition_held().get(0)));
        else if(!this.character.getOccupation().isEmpty())
            System.out.println("The character has been " + StringModifierService.removeLanguageTag(this.character.getOccupation().get(0)));
        else
            System.out.println("The character has died " + this.character.getDate_of_death());
        handleResponse();
        System.out.println("The character is a " + StringModifierService.removeLanguageTag(this.character.getSexe_or_gender().get(0)));
        handleResponse();
        System.out.println("The character was born the " + this.character.getDate_of_birth());
        handleResponse();
        if(this.character.getPosition_held().size() >= 2)
            System.out.println("The character has been " + StringModifierService.removeLanguageTag(this.character.getPosition_held().get(1)));
        else
            System.out.println("The character is born in " + StringModifierService.removeLanguageTag(this.character.getCountry_of_citizenship().get(0)));
        handleResponse();
        if(!this.character.getSpouce().isEmpty())
            System.out.println("The character has been married to " + StringModifierService.removeLanguageTag(this.character.getSpouce().get(0)));
        else if(this.character.getPosition_held().size() >= 3)
            System.out.println("The character has been " + StringModifierService.removeLanguageTag(this.character.getPosition_held().get(2)));
        else
            System.out.println("The character father is " + StringModifierService.removeLanguageTag(this.character.getFather().get(0)));
        handleResponse();
        System.out.println("You lost, the character was : " + this.character.getName());

    }

    private void handleResponse(){
        System.out.println("Who do you think the character is ?");
        Scanner sc = new Scanner(System.in);
        String input = StringModifierService.addUnderscoreBetweenBlanksAndPutItInUppercase(sc.nextLine());
        if(input.compareTo(this.character.getName()) == 0) {
            System.out.println("Congratulations ! You win after : " + nb_attempts + " attempt(s) !");
            System.exit(0);
        }
        else{
            nb_attempts++;
        }
    }

    private void launchNormalDifficulty() {
        nb_attempts=1;
        System.out.println("The character is a " + StringModifierService.removeLanguageTag(this.character.getSexe_or_gender().get(0)));
        handleResponse();
        System.out.println("The character was born the " + this.character.getDate_of_birth());
        handleResponse();
        if(!this.character.getPosition_held().isEmpty())
            System.out.println("The character has been " + StringModifierService.removeLanguageTag(this.character.getPosition_held().get(0)));
        else if(!this.character.getOccupation().isEmpty())
            System.out.println("The character has been " + StringModifierService.removeLanguageTag(this.character.getOccupation().get(0)));
        else
            System.out.println("The character is born in " + StringModifierService.removeLanguageTag(this.character.getCountry_of_citizenship().get(0)));
        handleResponse();
        if(this.character.getDate_of_death() != null)
            System.out.println("The character has died " + this.character.getDate_of_death());
        else if (!this.character.getConvicted_of().isEmpty())
            System.out.println("The character has been convicted of " + StringModifierService.removeLanguageTag(this.character.getConvicted_of().get(0)));
        else if(this.character.getPosition_held().size() >=2)
            System.out.println("The character has been " + StringModifierService.removeLanguageTag(this.character.getPosition_held().get(1)));
        else if(this.character.getOccupation().size() >= 2)
            System.out.println("The character nickname is " + StringModifierService.removeLanguageTag(this.character.getOccupation().get(1)));
        else
            System.out.println("The character is alive !");
        handleResponse();
        if(!this.character.getNickname().isEmpty())
            System.out.println("The character nickname is " + StringModifierService.removeLanguageTag(this.character.getNickname().get(0)));
        else if (this.character.getPosition_held().size() >= 3)
            System.out.println("The character has been " + StringModifierService.removeLanguageTag(this.character.getPosition_held().get(2)));
        else if(!this.character.getFather().isEmpty())
            System.out.println("The character father is  " + StringModifierService.removeLanguageTag(this.character.getFather().get(0)));
        else
            System.out.println("The character has been married to " + StringModifierService.removeLanguageTag(this.character.getSpouce().get(0)));
        handleResponse();
        System.out.println("You lost, the character was : " + this.character.getName());
    }

    private void launchHardDifficulty(){System.out.println("Not yet implemented");};
    private void launchCrazyDifficulty(){System.out.println("Not yet implemented");};

}
