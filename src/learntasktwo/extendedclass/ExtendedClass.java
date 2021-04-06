package learntasktwo.extendedclass;

public class ExtendedClass {
    private byte b;
    private int i;
    private double d;
    private String s;

    //Конструктор
    ExtendedClass(byte b, int i, double d, String s){
        this.b = b;
        this.i = i;
        this.d = d;
        this.s = s;
    }

    //Хеш-код считаем как сумму хещ-кодов соответсвующих полей
    @Override
    public int hashCode() {
        return 2*s.hashCode() + Integer.hashCode(i) + Double.hashCode(d) + Byte.hashCode(b);
    }

    @Override
    public boolean equals(Object obj) {
        //Чтобы не тратить время, если сравниваем с собой
        if(this == obj)
            return true;

        if(obj == null)
            return false;

        //Сравниваем по эллементу. Для double используем метод compare для корректного сравнивания даблов
        if(obj instanceof ExtendedClass)
            return ((ExtendedClass) obj).b == b && ((ExtendedClass) obj).i == i &&
                    (Double.compare(d, ((ExtendedClass) obj).d) == 0) && s.equals(((ExtendedClass) obj).s);
        return false;
    }


    //Конкатинация строк
    @Override
    public String toString() {
        return Byte.toString(b) + "\t" + Integer.toString(i) + "\t" + Double.toString(d)+ "\t" + s;
    }
}
