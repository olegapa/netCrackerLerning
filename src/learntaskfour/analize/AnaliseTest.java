package learntaskfour.analize;

public class AnaliseTest {
    public static void main(String[] args) {
        Analise analise = new Analise("one two three four, one;;;;; two two --- two", "okpq");


        System.out.print("Word frequency analise:\t");
        analise.printWordFreqAnalise();
        System.out.print("Char frequency analise:\t");
        analise.printCharFreqAnalise();

        System.out.println("Simple output of chars that summary contains in both strings");
        analise.simpleOutput(analise.charsSum());

        System.out.println("Simple output of chars that contains only in both strings");
        analise.simpleOutput(analise.charsInBoth());

        System.out.println("Simple output of chars that contains only in first string");
        analise.simpleOutput(analise.charsInFirstOnly());
        System.out.println("Reversed output of chars that contains only in first string");
        analise.reversedOutput(analise.charsInFirstOnly());
        System.out.println("Spatial output of chars that contains only in first string");
        analise.specialOutput(analise.charsInFirstOnly(), 3);

    }
}
