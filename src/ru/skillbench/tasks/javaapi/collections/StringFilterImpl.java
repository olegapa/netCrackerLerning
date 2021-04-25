package ru.skillbench.tasks.javaapi.collections;

import java.util.*;

public class StringFilterImpl implements StringFilter{

    private Set<String> strings;

    interface Filter{
        boolean isSuitable(String str);
    }

    private Iterator<String> getIter(Filter filter){
        Set<String> suitable = new HashSet<>();

        for(String i: strings){
            if(filter.isSuitable(i))
                suitable.add(i);
        }

        return suitable.iterator();
    }
    public StringFilterImpl(){
        strings = new HashSet<>();
    }

    @Override
    public void add(String s) {
        strings.add(s);
    }


    @Override
    public boolean remove(String s) {
        return strings.remove(s);
    }

    @Override
    public void removeAll() {
        strings.clear();
    }

    @Override
    public Collection<String> getCollection() {
        return strings;
    }

    @Override
    public Iterator<String> getStringsContaining(String chars) {

        Filter cond = str -> {
            if(chars == null) return true;
            if(chars.length() == 0) return true;

            String ch = chars.toLowerCase();

            if(str == null)
                return false;

            return str.contains(ch);
        };

        return getIter(cond);
    }

    @Override
    public Iterator<String> getStringsStartingWith(String begin) {
        Filter cond = str -> {
            if(begin == null) return true;
            if(begin.length() == 0) return true;

            String beg = begin.toLowerCase();

            if(str == null) return false;

            return str.startsWith(beg);
        };

        return getIter(cond);
    }

    @Override
    public Iterator<String> getStringsByNumberFormat(String format) {
        Filter cond = str -> {
            if(format == null) return true;
            if(format.length() == 0) return true;
            if(str == null) return false;

            String form = format.toLowerCase();

            if(form.length() != str.length())
                return false;
            for(int i = 0; i < form.length(); i++){
                if(form.charAt(i) == '#') {
                    if(!Character.isDigit(str.charAt(i)))
                        return false;
                }
                else {
                    if(form.charAt(i) != str.charAt(i))
                        return false;
                }
            }
            return true;
        };

        return getIter(cond);
    }

    @Override
    public Iterator<String> getStringsByPattern(String pattern) {
        Filter cond = str -> {
            if(pattern == null) return true;
            if(pattern.length() == 0) return true;
            if(str == null) return false;

            String pat = pattern.toLowerCase();

            int count = 0;
            for(int i = 0; i < pat.length(); i++){
                if(pat.charAt(i) == '*') {
                    if(i == pat.length() - 1)
                        return true;
                    while(count < str.length() && str.charAt(count) != pat.charAt(i+1))
                        count++;
                }
                else {
                    if(str.charAt(count) != pat.charAt(i))
                        return false;
                    count++;
                }
                if(count == str.length() && i != pat.length()-1)
                    return false;
                
            }
            if(count != str.length())
                return false;
            return true;
        };

        return getIter(cond);
    }
}
