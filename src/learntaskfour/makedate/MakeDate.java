package learntaskfour.makedate;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MakeDate {
    private Calendar calendar;
    private Date data;

    //конструктор, принимающий строку и формирующий
    public MakeDate(String input){
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(input);

        int[] info = new int[5];
        for(int i = 0; matcher.find() || i < 5; i++){
            info[i] = Integer.parseInt(matcher.group());
        }

        //Месяц -1 т.к. в Calendar.JANUARY = 0, т.е. смещение значений на 1
        calendar = new GregorianCalendar(info[0], info[1] - 1, info[2]);
        calendar.set(Calendar.HOUR, info[3]);
        calendar.set(Calendar.MINUTE, info[4]);

        data = calendar.getTime();
    }

    //печатает экземпляр класса Calendar
    public void printCalendar(){
        SimpleDateFormat format= new SimpleDateFormat("yyyy MMMM dd HH:mm");
        System.out.println(format.format(calendar.getTime()));
    }

    //печатает объект класса Date
    public void printDate(){
        SimpleDateFormat format= new SimpleDateFormat("yyyy MMMM dd HH:mm");
        System.out.println(format.format(data));
    }

}
