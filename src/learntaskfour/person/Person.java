package learntaskfour.person;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Person {
    private Calendar birthDay;

    //перечень возможных форматов
    public enum Format{
        SHORT, MEDIUM, LONG
    }

    //конструктор, принимающий календарь
    public Person(Calendar newBirthDay){
        birthDay = newBirthDay;
    }

    //конструктор, принимающий значения дня, месяца и года рождения
    public Person(int day, int month, int year){
        birthDay = new GregorianCalendar(year, month, day);
    }

    //метод toString
    public String toString(){
        return birthDay.getTime().toString();
    }

    //вывод даты в указаном формате
    private SimpleDateFormat getDateFormat(Format format){
        if(format == Format.SHORT)
            return new SimpleDateFormat("dd.MM.yy");

        if(format == Format.MEDIUM)
            return new SimpleDateFormat("dd-MMM-yy");

        if(format == Format.LONG)
            return new SimpleDateFormat("dd MMMM yyyy");

        return null;
    }

    public String toString(Format format){

        try {
            return getDateFormat(format).format(birthDay.getTime());
        }
        catch (NullPointerException e){
            System.out.println("Wrong format");
            return null;
        }

    }
}
