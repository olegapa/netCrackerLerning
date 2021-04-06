package learntasktwo.ptask;

public class Main {
    public static void main(String[] args) {
        BlackImpl x = new BlackImpl();

        x.setColor("black");

        x.isBlack();

        x.setColor("scarlet");

        x.isBlack();
    }


}
