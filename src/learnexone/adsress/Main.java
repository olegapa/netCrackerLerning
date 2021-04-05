package learnexone.adsress;

import java.util.List;

//Тесты!
public class Main {
    public static void main(String[] args) {
        Address a1 = new Address("Park Avenue", 5, 8);
        Address a2 = new Address("Park Avenue", 3, 4);
        Address a3 = new Address("Park Avenue", 5, 8);
        Address a4 = new Address("Fulton Street", 1, 1);
        Address a5 = new Address("Dyer Avenue", 1, 2);

        int[] bd1 = {3, 5, 1987};
        int[] bd2 = {4, 8, 2001};
        int[] bd3 = {19, 10, 1990};
        int[] bd4 = {1, 1, 2021};
        int[] bd5 = {22, 4, 1870};

        Person p1 = new Person("Homer Simpson", a1, bd1);
        Person p2 = new Person("Richest Reach", a2, bd2);
        Person p3 = new Person("Marge Simpson", a3, bd3);
        Person p4 = new Person("Roran Stronghammer", a4, bd4);
        Person p5 = new Person("Leonid", a5, bd5);

        Person[] people = {p1, p2, p3, p4, p5};

        People them = new People(people);

        System.out.println("youngest:");
        them.findOldes().printInfo();

        System.out.println("\noldest:");
        them.findYoungest().printInfo();

        System.out.println("\nin Park Avenue lives:");
        List<Person> l1 = them.searchByStreet("Park Avenue");
        for(Person i: l1)
            i.printInfo();

        System.out.println("\nin Park Avenue, 5, 8 lives:");
        List<Person> l2 = them.searchByAddress(a1);
        for(Person i: l2)
            i.printInfo();

        System.out.println("\n in range of 1.1.2000 - 1.1.2026 born: ");
        int[] dat1 = {1, 1, 2000};
        int[] dat2 = {1, 1, 2026};
        List<Person> l3 = them.searchByBirthdayRange(dat1, dat2);
        for(Person i: l3)
            i.printInfo();

        System.out.println("\n Roran Stronghammer lives: ");
        them.searchByName("Roran Stronghammer").printAdr();
    }
}
