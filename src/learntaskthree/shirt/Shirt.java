package learntaskthree.shirt;

public class Shirt {
    private String id, description, color, size;

    //конструктор, принимающий аргументы
    public Shirt(String id, String description, String color, String size) {
        this.id = id;
        this.description = description;
        this.color = color;
        this.size = size;
    }

    //конструктор, принимающий строку
    public Shirt(String info){
        id = info.split(",")[0].trim();
        description = info.split(",")[1].trim();
        color = info.split(",")[2].trim();
        size = info.split(",")[3].trim();
    }

    public String toString(){
        return "Id of shirt: " + id + "\nDescription: " + description + "\nColor: " + color + "\nSize: " + size + "\n";
    }
}
