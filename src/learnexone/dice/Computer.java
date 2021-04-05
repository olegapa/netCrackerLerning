package learnexone.dice;

public class Computer extends Player
                    implements Turnable{

    //Номер "модели" бота
    private final int model;
    private static int counter = 1;

    //Устанавливает количество костей на руке и номер модели
    Computer(int numDice){
        super();
        setnDice(numDice);
        model = counter++;
    }

    @Override
    public void claimWin() {
        super.claimWin();
        System.out.println("Bot" + model + " won this round, he have " + getWins() + " wins now\n");
    }

    @Override
    void win() {
        System.out.println("Oh no, bot" + model + " won the game. Leave your money and gg.");
        System.exit(0);
    }

    @Override
    void DropInfo() {
        System.out.println("Bot" + model + " dropped: ");
    }

    @Override
    void printTotalScore(int totalScore) {
        System.out.println("\t And his total score is: " + totalScore);
    }
}
