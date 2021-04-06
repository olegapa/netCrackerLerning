package learntasktwo.dice;

public interface Turnable {

    //Бросить кубики
    int doThrow();

    //Подсчитать результат
    int calculateScore(int[] res);
}
