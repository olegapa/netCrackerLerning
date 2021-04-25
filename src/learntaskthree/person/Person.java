package learntaskthree.person;

//Реализовал 2 варианта метода и проверил в классе Test какой быстрее
public class Person {
    private String firstName;
    private String secondName;
    private String lastName;

    // Конструктор, если поле "не указано" передаем null
    Person(String firstName, String secondName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.secondName = secondName;
    }

    //Реализация через StringBuilder, теоретически должна быть быстрой, ведь не конкатенируем строки, а значит не
    //создаем кучу новых (при конкатинации создаются новые экземпляры строк)
    String getFullName(){
        StringBuilder res = new StringBuilder();

        res.append(lastName);
        if(firstName != null)
            res.append(" ").append(firstName);
        if (secondName != null)
            res.append(" ").append(secondName);

        return res.toString();
    }

    //Реализация просто через ifы
    String getWholeName(){
        if(firstName == null && secondName == null)
            return lastName;

        if(firstName == null)
            return lastName + " " + secondName;

        if(secondName == null)
            return lastName + " " + firstName;

        return lastName + " " + firstName + " " + secondName;
    }

    //Тесты при разных аргументах (с разным количеством неуказанных) показали, что метод со StringBuilder
    //при неуказанных двух параметрах работает на порядок медленнее, чем метод с тремя if, но в остальных случаях -
    //на 2 порядка быстрее.


}
