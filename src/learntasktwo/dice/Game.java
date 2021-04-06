package learntasktwo.dice;

import java.util.Scanner;

abstract public class Game {
    //Количество игроков
    private static final int nPlayers = 3;
    //Массив игроков
    private static Player[] players;

    //Ищем победителя в раунде
    public static int findBest(int[] arr){
        int max = arr[0], best = 0;
        for(int i = 1; i < arr.length; i++){
            if(arr[i] >= max)
                best = i;
        }
        return best;
    }

    //Сыграть раунд
    public static int nextTurn(int firstPlays){
        int[] scores = new int[nPlayers];

        for (int i = firstPlays; ; ){
            scores[i] = players[i].doThrow();

            i++;

            if(i == nPlayers)
                i = 0;
            if(i == firstPlays )
                return findBest(scores);

        }
    }

    //Мейн
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input number of dice:");
        int numDice = in.nextInt();

        if(numDice <= 0){
            System.out.println("Can't play this figure of dices");
            System.exit(-1);
        }
        players = new Player[nPlayers];
        players[0] = new You(numDice);

        for (int i = 1; i < nPlayers; i++)
            players[i] = new Computer(numDice);

        //Победитель в раунде
        int best = 0;

        while(!players[best].isWon()) {
            best = nextTurn(best);
            players[best].claimWin();
        }
        players[best].win();


    }
}
