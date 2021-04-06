package learntasktwo.dice;

import java.util.Random;

//Абстрактный класс, описывающий игрока
public abstract class Player implements Turnable {
    private int wins;
    private int nDice;

    // wins - количество побед, nDice - количество кубиков, устанавливается в main.
    Player(){
        wins = 0;
        nDice = 0;
    }

    public int getWins() {
        return wins;
    }

    //Проверка, набрал ли игрок 7 очков.
    public boolean isWon(){
        return wins == 7;
    }

    //Метод, вызывающийся в случае победы игрока.
    abstract void win();

    //Метод вызывающийся, в случае победы в партии. Увиличивает счетчик побед
    public void claimWin(){
        wins++;
    }

    //Геттер
    public int getnDice() {
        return nDice;
    }

    //Сеттер
    public void setnDice(int nDice) {
        this.nDice = nDice;
    }

    //Печатает, кто бросил кости в этот ход
    abstract void DropInfo();

    //Печатает сумму чисел на костях.
    abstract void printTotalScore(int totalScore);

    //Бросок костей
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

    //Подсчет сумыы
    @Override
    public int calculateScore(int[] res) {
        int score = 0;

        for(int i: res)
            score += i;
        return score;
    }
}
