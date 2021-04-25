package ru.skillbench.tasks.text.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        String text = "Jhon Conner (916)125-4171, 495 926-93-47 ext.1846, 800 250 0890";

        CurriculumVitaeImpl curriculumVitae = new CurriculumVitaeImpl();
        curriculumVitae.setText(text);

        System.out.println(curriculumVitae.getText());
        System.out.println(curriculumVitae.getPhones().get(0));
        System.out.println(curriculumVitae.getFirstName());

        curriculumVitae.hidePhone("(916)125-4171");
        System.out.println(curriculumVitae.getText());
    }
}
