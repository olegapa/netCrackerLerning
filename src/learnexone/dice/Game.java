package learnexone.dice;

import java.util.Scanner;

public class Game {
    private static final int nPlayers = 4;

    public static int findBest(int[] arr){
        int max = arr[0], best = 0;
        for(int i = 1; i < arr.length; i++){
            if(arr[i] >= max)
                best = i;
        }
        return best;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numDice = in.nextInt();

        Player[] arr = new Player[nPlayers];
        arr[0] = new You(numDice);

        for (int i = 1; i < nPlayers; i++)
            arr[i] = new Computer(numDice);

        int[] scores = new int[nPlayers];
        for(int i = 0; !arr[i].isWon(); i++){
            scores[i] = arr[i].doThrow();

            if(i == nPlayers - 1){
                int best = findBest(scores);
                arr[best].claimWin();
                if(arr[best].isWon())
                    arr[best].win();
            }
        }
    }
}
