package learnexone.dice;

public class Computer extends Player
                    implements Turnable{
    private final int model;
    private static int counter = 0;
    Computer(int numDice){
        super();
        setnDice(numDice);
        model = counter++;
    }

    @Override
    void win() {
        System.out.println("Oh no, bot" + model + "won the game. Leave your money and gg.");
        System.exit(0);
    }

    @Override
    void DropInfo() {
        System.out.println("Bot" + model + "dropped: ");
    }

    @Override
    void printTotalScore(int totalScore) {
        System.out.println("\t And his total score is: " + totalScore);
    }
}
