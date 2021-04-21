package ru.skillbench.tasks.text.regex;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CurriculumVitaeImpl implements CurriculumVitae{
    private String text;


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

        m.find();
        return null;
    }

    @Override
    public String getFullName() {
        return null;
    }

    @Override
    public String getFirstName() {
        return null;
    }

    @Override
    public String getMiddleName() {
        return null;
    }

    @Override
    public String getLastName() {
        return null;
    }

    @Override
    public void updateLastName(String newLastName) {

    }

    @Override
    public void updatePhone(Phone oldPhone, Phone newPhone) {

    }

    @Override
    public void hide(String piece) {

    }

    @Override
    public void hidePhone(String phone) {

    }

    @Override
    public int unhideAll() {
        return 0;
    }
}
