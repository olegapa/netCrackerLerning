package learntaskfour.person;

import java.util.Calendar;

public class PersonTest {
    public static void main(String[] args) {
        Person p = new Person(1, Calendar.JANUARY, 2001);

        System.out.println(p.toString());
        System.out.println(p.toString(Person.Format.SHORT));
        System.out.println(p.toString(Person.Format.MEDIUM));
        System.out.println(p.toString(Person.Format.LONG));
    }

}
