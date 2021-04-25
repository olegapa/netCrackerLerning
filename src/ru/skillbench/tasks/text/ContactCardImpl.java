package ru.skillbench.tasks.text;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Period;
import java.util.*;

public class ContactCardImpl implements ContactCard{
    private String fN, org, gender;
    private Calendar bDay;
    private final Map<String, String> tel;

    public ContactCardImpl(){
        fN = null;
        org = null;
        gender = null;
        bDay = null;
        tel = new HashMap<>();
    }

    @Override
    public ContactCard getInstance(Scanner scanner) {

        scanner.useDelimiter("\r\n");
        if(!scanner.next().equals("BEGIN:VCARD"))
            throw new NoSuchElementException();


        String temp = scanner.next();
        String[] splited = temp.split(":");

        if(!splited[0].startsWith("FN"))
            throw new NoSuchElementException();

        if(temp.charAt(2) != ':')
            throw new InputMismatchException();

        fN = new String(splited[1]);

        temp = scanner.next();
        splited = temp.split(":");
        if(!splited[0].startsWith("ORG"))
            throw new NoSuchElementException();
        if(temp.charAt(3) != ':')
            throw new InputMismatchException();


        org = new String(splited[1]);

        while (scanner.hasNext()){
            temp = scanner.next();
            splited = temp.split(":");
            if(temp.startsWith("END")){
                if(!temp.equals("END:VCARD"))
                    throw new InputMismatchException();
                return this;
            }

            else if(temp.startsWith("BDAY")){
                if(temp.charAt(4) != ':')
                    throw new InputMismatchException();

                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                String[] tempDate = splited[1].split("-");

                try {
                    if(tempDate.length!=3 || Integer.parseInt(tempDate[0])>31 || (Integer.parseInt(tempDate[0])<1) || (Integer.parseInt(tempDate[1])>12) || (Integer.parseInt(tempDate[1])<1) || (Integer.parseInt(tempDate[2])>2021)){
                        throw new InputMismatchException();
                    }
                    Date date = sdf.parse(splited[1]);
                    bDay = sdf.getCalendar();
                }
                catch (ParseException e) {
                    throw new InputMismatchException();
                }
            }

           else  if(temp.startsWith("GENDER")){
                if(temp.charAt(6) != ':')
                    throw new InputMismatchException();

                if(splited[1].compareTo("M")==0){
                    gender="M";
                } else if (splited[1].compareTo("F")==0){
                    gender="F";
                } else {
                    throw new InputMismatchException();
                }
            }

            else if(temp.startsWith("TEL")){
                if(splited[1].length() != 10 || temp.charAt(3) != ';')
                    throw new InputMismatchException();

                String[] r = temp.split(";");

                String type = r[1].split("=")[1].split(":")[0];

                for(int i = 0; i < 10; i++){
                    char c = splited[1].charAt(i);
                    if(!((c >= '0') && (c <= '9')))
                        throw new InputMismatchException();
                }

                String numb = splited[1];

                tel.put(type, numb);
            }

            else
                throw new InputMismatchException();

        }

        throw new NoSuchElementException();
    }

    @Override
    public ContactCard getInstance(String data) {
        return this.getInstance(new Scanner(data));
    }

    @Override
    public String getFullName() {
        return fN;
    }

    @Override
    public String getOrganization() {
        return org;
    }

    @Override
    public boolean isWoman() {
        if (gender == null)
            throw new NoSuchElementException();
        return gender.equals("F");
    }

    @Override
    public Calendar getBirthday() {
        if(bDay == null){
            throw new NoSuchElementException();
        }
        return bDay;
    }

    @Override
    public Period getAge() {
        if(bDay==null){
            throw new NoSuchElementException();
        }
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int byear = bDay.get(Calendar.YEAR);
        //System.out.println(year + " "+ byear);
        return Period.ofYears(year - byear);
    }

    @Override
    public int getAgeYears() {
        if(bDay==null){
            throw new NoSuchElementException();
        }
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int byear = bDay.get(Calendar.YEAR);
        int day = Calendar.getInstance().get(Calendar.DAY_OF_YEAR);
        int bday = bDay.get(Calendar.DAY_OF_YEAR);
        if(day<bday){
            return year - byear-1;
        }
        return year - byear;
    }

    @Override
    public String getPhone(String type) {
        if(tel.containsKey(type)) {
            String s = tel.get(type);
            return "(" +s.charAt(0)+s.charAt(1)+s.charAt(2)+") "+s.charAt(3)+s.charAt(4)+s.charAt(5)+ "-" +s.charAt(6)+s.charAt(7)+s.charAt(8)+s.charAt(9);
        }
        throw new NoSuchElementException();
    }
}
