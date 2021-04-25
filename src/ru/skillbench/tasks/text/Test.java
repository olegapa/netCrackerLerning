package ru.skillbench.tasks.text;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {


        String str = new String("BEGIN:VCARD\r\n"+"FN:Chuck Norris\r\nORG:Hollywood\r\nBDAY:10-04-1940\r\nTEL;TYPE=WORK:1234567890"+"\r\nEND:VCARD");

        Scanner scanner = new Scanner(str);

        ContactCardImpl im = new ContactCardImpl();
        System.out.println(im.getInstance(str).getPhone("WORK"));
    }
}
