package learntaskthree.sqlinstruction;

import java.util.Scanner;

public class Instruction {
    //Часть инструкции до where
    public final static String INSERT = "INSERT INTO T_GroupSelected (id_Student, firstName, lastName, id_Group) \n" +
            "VALUES (SELECT id_student, firstName, lastName, id_Group \nFROM T_Student\n";

    public static void main(String[] args) {
        //читаем аргументы с клавиатуры
        Scanner scanner = new Scanner(System.in);

        //ввод номера группы
        System.out.println("Type id_Group:");
        String group = new String(scanner.nextLine());
        //ввод количества долгов
        System.out.println("Type value of dolgCount:");
        int minDolgCount = scanner.nextInt();

        //формирование полной инструкции
        String instruction = new String(INSERT + "WHERE dolgCount > " + minDolgCount + " and in_Group = '" + group + "')");

        //тестируем, выводя инструкцию на экран
        System.out.println(instruction);
    }
}
