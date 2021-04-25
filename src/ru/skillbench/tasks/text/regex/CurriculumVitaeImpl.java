package ru.skillbench.tasks.text.regex;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CurriculumVitaeImpl implements CurriculumVitae{
    private String text;
    private static final String NAME_PATTERN =
            "([A-Z][a-z.]+) ([A-Z][a-z.]+) *([A-Z][a-z.]+)?";
    private Map<String, String> hiddenText;

    public CurriculumVitaeImpl(){
        text = null;

        hiddenText = new HashMap<>();
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
            String phNum = m.group();
            int arCode;
            int ext = -1;

            if(!phNum.contains(m.group(1)))
                arCode = -1;
            else arCode = Integer.parseInt(m.group(1).replaceAll("\\D", ""));

            Pattern patternExt = Pattern.compile("ext\\.?\\s*([0-9]+)");
            Matcher matcherExt = patternExt.matcher(m.group());

            if(matcherExt.find()) {
                String extensionTmp = "" + matcherExt.group();

                patternExt = Pattern.compile("[0-9]+");
                matcherExt = patternExt.matcher(extensionTmp);
                try {
                    matcherExt.find();
                    ext = Integer.parseInt(matcherExt.group());

                } catch (NumberFormatException | IllegalStateException e1) {
                    System.out.println("NumberFormatException | IllegalStateException");
                }
            }

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
            throw new NoSuchElementException();

        return m.group();
    }

    @Override
    public String getFirstName() {
        if(text == null)
            throw new IllegalStateException();
        Pattern pat = Pattern.compile(NAME_PATTERN);
        Matcher m = pat.matcher(text);

        if(!m.find())
            throw new NoSuchElementException();

        return m.group(1);
    }

    @Override
    public String getMiddleName() {
        if(text == null)
            throw new IllegalStateException();
        Pattern pat = Pattern.compile(NAME_PATTERN);
        Matcher m = pat.matcher(text);

        if(!m.find())
            throw new NoSuchElementException();
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
            throw new NoSuchElementException();
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
            throw new NoSuchElementException();

        if(m.group().split(" ").length == 2)
            text = text.replace(m.group(2), newLastName);

        else text = text.replace(m.group(3), newLastName);
    }

    @Override
    public void updatePhone(Phone oldPhone, Phone newPhone) {
        if(text == null)
            throw new IllegalStateException();

        if(!text.contains(oldPhone.toString()))
            throw new IllegalArgumentException();

        text = text.replace(oldPhone.toString(), newPhone.toString());
    }

    @Override
    public void hide(String piece) {
        if(text == null)
            throw new IllegalStateException();

        Pattern pat = Pattern.compile(piece);
        Matcher m = pat.matcher(text);
        if(!m.find())
            throw new IllegalArgumentException();

        String hide = piece.replaceAll("\\w", "X");
        hiddenText.put(piece, hide);
        setText(m.replaceAll(hide));
    }

    @Override
    public void hidePhone(String phone) {
        if(text == null)
            throw new IllegalStateException();

        if(!text.contains(phone))
            throw new IllegalArgumentException();

        String hide = phone.replaceAll("\\d", "X");
        hiddenText.put(phone, hide);

        setText(text.replaceAll(phone, hide));
    }

    @Override
    public int unhideAll() {
        if(text == null)
            throw new IllegalStateException();

        int res = hiddenText.size();

        Set<String> keys = hiddenText.keySet();
        for(String k: keys){
            setText(text.replaceAll(hiddenText.get(k), k));
        }

        hiddenText.clear();
        return res;
    }
}
