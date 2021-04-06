package learntasktwo.ptask;

public class BlackImpl implements Black{
    private String color;

    BlackImpl(){
        color = null;
    }
    BlackImpl(String color){
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean isBlack() {
        if(color.equals("black") || color.equals("Black")){
            System.out.println("black");
            return true;
        }

        System.out.println("it isn’t black");
        return false;
    }
}
