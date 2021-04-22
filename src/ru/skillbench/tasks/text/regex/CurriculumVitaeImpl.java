package ru.skillbench.tasks.text.regex;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CurriculumVitaeImpl implements CurriculumVitae{
    private String text;
    private static final String NAME_PATTERN =
            "([A-Z][\\.a-z]+.?) (\\.a-z]+.?)? (\\.a-z]+.?)";
    private String unhidenText;

    public CurriculumVitaeImpl(){
        text = null;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        if(text == null)
            throw new IllegalStateException();
        return text;
    }

    @Override
    public List<Phone> getPhones() {
        if(text == null)
            throw new IllegalStateException();

        List<Phone> phones = new LinkedList<>();
        Pattern pat = Pattern.compile(PHONE_PATTERN);
        Matcher m = pat.matcher(text);

        while(m.find()){
            String phNum = new String(m.group());
            int arCode;
            int ext;

            if(!phNum.contains(m.group(1)))
                arCode = -1;
            else arCode = Integer.parseInt(m.group(1));

            if(!phNum.contains(m.group(5))) ext = -1;
            else ext = Integer.parseInt(phNum.split("\\.")[1]);

            phones.add(new Phone(phNum, arCode, ext));
        }
        return phones;
    }

    @Override
    public String getFullName() {
        if(text == null)
            throw new IllegalStateException();
        Pattern pat = Pattern.compile(NAME_PATTERN);
        Matcher m = pat.matcher(text);

        if(!m.find())
            throw new IllegalStateException();

        return m.group();
    }

    @Override
    public String getFirstName() {
        if(text == null)
            throw new IllegalStateException();
        Pattern pat = Pattern.compile(NAME_PATTERN);
        Matcher m = pat.matcher(text);

        if(!m.find())
            throw new IllegalStateException();

        return m.group(1);
    }

    @Override
    public String getMiddleName() {
        if(text == null)
            throw new IllegalStateException();
        Pattern pat = Pattern.compile(NAME_PATTERN);
        Matcher m = pat.matcher(text);

        if(!m.find())
            throw new IllegalStateException();
        if(m.group().split(" ").length == 2)
            return null;
        return m.group(2);
    }

    @Override
    public String getLastName() {
        if(text == null)
            throw new IllegalStateException();
        Pattern pat = Pattern.compile(NAME_PATTERN);
        Matcher m = pat.matcher(text);

        if(!m.find())
            throw new IllegalStateException();
        if(m.group().split(" ").length == 2)
            return m.group(2);
        return m.group(3);
    }

    @Override
    public void updateLastName(String newLastName) {
        if(text == null)
            throw new IllegalStateException();
        Pattern pat = Pattern.compile(NAME_PATTERN);
        Matcher m = pat.matcher(text);

        if(!m.find())
            throw new IllegalStateException();

        if(m.group().split(" ").length == 2)
            text = new String(text.replace(m.group(2), newLastName));

        else text = new String(text.replace(m.group(3), newLastName));
    }

    @Override
    public void updatePhone(Phone oldPhone, Phone newPhone) {
        if(text == null)
            throw new IllegalStateException();

        if(!text.contains(oldPhone.toString()))
            throw new IllegalStateException();

        text = new String(text.replace(oldPhone.toString(), newPhone.toString()));

    }

    @Override
    public void hide(String piece) {
        if(text == null)
            throw new IllegalStateException();

        if(!text.contains(piece))
            throw new IllegalStateException();

        unhidenText = new String(text);
        text.
    }

    @Override
    public void hidePhone(String phone) {

    }

    @Override
    public int unhideAll() {
        return 0;
    }
}
