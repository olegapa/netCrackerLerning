package ru.skillbench.tasks.text;

import java.io.PrintStream;

public class CounterTest {
    public static void main(String[] args) {
       // String s1 = "<[commodo, odio, accumsan, nonummy, erat, facilisis, euismod, vero, vel, ea, molestie, feugiat, ut, wisi, volutpat, enim, exerci, consequat, ad, lobortis, in, velit, dignissim, vulputate, iriure, et, esse, eu, at, ex, eum, nostrud, ullamcorper, laoreet, qui, minim, veniam, hendrerit, autem, nisl, tincidunt, aliquam, magna, aliquip, nibh, illum, quis, iusto, eros, tation]>";
        String s1 ="GNU LESSER GENERAL PUBLIC LICENSE\n" +
                "                       Version 3, 29 June 2007\n" +
                "\n" +
                " Copyright (C) 2007 Free Software Foundation, Inc. <https://fsf.org/>\n" +
                " Everyone is permitted to copy and distribute verbatim copies\n" +
                " of this license document, but changing it is not allowed.\n" +
                "\n" +
                "\n" +
                "  This version of the GNU Lesser General Public License incorporates\n" +
                "the terms and conditions of version 3 of the GNU General Public\n" +
                "License, supplemented by the additional permissions listed below.\n" +
                "\n" +
                "  0. Additional Definitions.\n" +
                "\n" +
                "  As used herein, \"this License\" refers to version 3 of the GNU Lesser\n" +
                "General Public License, and the \"GNU GPL\" refers to version 3 of the GNU\n" +
                "General Public License.";
        WordCounterImpl ex1 = new WordCounterImpl();
        ex1.setText(s1);

        PrintStream stream = new PrintStream(System.out);
        ex1.print(ex1.getWordCountsSorted(), stream);
    }
}
