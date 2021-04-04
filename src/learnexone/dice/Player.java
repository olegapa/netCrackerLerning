package learnexone.dice;

import java.util.Random;
public abstract class Player implements Turnable{
    private int wins;
    private int nDice;

    Player(){
        wins = 0;
        nDice = 0;
    }

    public boolean isWon(){
        return wins == 7;
    }
    abstract void win();

    public void claimWin(){
        wins++;
    }

    public int getnDice() {
        return nDice;
    }

    public void setnDice(int nDice) {
        this.nDice = nDice;
    }

    abstract void DropInfo();

    abstract void printTotalScore(int totalScore);

    @Override
    public int doThrow() {
        int[] res = new int[nDice];
        Random random = new Random();

        for(int i = 0; i < nDice; i++)
            res[i] = random.nextInt(6)+1;

        int totalScore = calculateScore(res);
        DropInfo();
        for (int i: res)
            System.out.print(i + " ");
        printTotalScore(totalScore);

        return totalScore;
    }

    @Override
    public int calculateScore(int[] res) {
        int score = 0;

        for(int i: res)
            score += i;
        return score;
    }
}
