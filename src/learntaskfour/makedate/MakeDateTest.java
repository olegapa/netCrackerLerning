package learntaskfour.makedate;

import java.util.Calendar;

public class MakeDateTest {
    public static void main(String[] args) {
        MakeDate date = new MakeDate("<2001><12><3><23><59>");
        date.printCalendar();
        date.printDate();
    }
}
