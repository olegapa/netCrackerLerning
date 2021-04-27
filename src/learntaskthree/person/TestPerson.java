package learntaskthree.person;

public class TestPerson {
    public static void main(String[] args) {
        Person person = new Person(null, null, "Potekhin");

        long start = System.nanoTime();
        System.out.println(person.getFullName());
        System.out.println("Время выполнения метода через StringBuilder (наносекунды): " + (System.nanoTime() - start));

        start = System.nanoTime();
        System.out.println(person.getWholeName());
        System.out.println("Время выполнения метода через 3 if (наносекунды): " + (System.nanoTime() - start));

        //Тесты при разных аргументах (с разным количеством неуказанных) показали, что метод со StringBuilder
        //при неуказанных двух параметрах работает на порядок медленнее, чем метод с тремя if, но в остальных случаях -
        //на 2 порядка быстрее.
    }
}
