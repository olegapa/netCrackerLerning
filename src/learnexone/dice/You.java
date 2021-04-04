package learnexone.dice;

import java.util.Scanner;

public class You extends Player
        implements Turnable{
    private final String name;

    You(int numDice){
        super();
        setnDice(numDice);
        System.out.println("Welcome to casino, type your nickname:");

        Scanner scn = new Scanner(System.in);
        name = scn.nextLine();

        System.out.println("Ok, " + name + ", you throw first. Pres enter to throw");


    }

    @Override
    void win() {
        System.out.println("CONGRATULATIONS! You won the game");
        System.exit(0);
    }

    @Override
    void DropInfo() {
        System.out.println(name + ", you dropped: ");
    }

    @Override
    void printTotalScore(int totalScore) {
        System.out.println("\tWow, you total scor is: " + totalScore);
    }
}
