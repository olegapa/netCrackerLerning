package ru.skillbench.tasks.javaapi.collections;

import java.util.Iterator;

public class TestFilter {
    public static void main(String[] args) {
        StringFilterImpl filt = new StringFilterImpl();

        filt.add("reflect");
        filt.add("effect");
        filt.add("that");
        filt.add("there");
        filt.add("than");

        Iterator<String> i = filt.getStringsByPattern("*ect");

        while (i.hasNext())
            System.out.println(i.next());
    }
}
