package learnexone.adsress;

import java.util.ArrayList;
import java.util.List;

public class People {
    private final Person[] people;

    People(Person[] people){
        this.people = people;
    }

    //Поиск по адресу
    public List<Person> searchByAddress(Address adr){
        List<Person> ans = new ArrayList<>();

        for(Person i: people){
            if(i.getAdr().equals(adr))
                ans.add(i);
        }

        return ans;
    }
    //Поиск по имени (возвращает место проживания этого человека)
    public Address searchByName(String name){

        for(Person i: people){
            if(i.getName().equals(name))
                return i.getAdr();
        }
        return null;
    }

    //Ищет людей с днем рождения в указанном диапозоне
    public List<Person> searchByBirthdayRange(int[] date1, int[] date2){
        List<Person> ans = new ArrayList<>();

        for(Person i: people){
            if(!i.isDateLater(date1) && i.isDateLater(date2))
                ans.add(i);
        }

        return ans;
    }

    //Ищет самомго старого
    public Person findOldes(){
        Person ans = people[0];

        for(Person i: people){
            if(ans.isDateLater(i.getBirthday()))
                ans = i;
        }
        return ans;
    }

    //Ищет самого молодого
    public Person findYoungest(){
        Person ans = people[0];

        for(Person i: people){
            if(!ans.isDateLater(i.getBirthday()))
                ans = i;
        }
        return ans;
    }

    //Ищет людей, проживающих на указанной улице
    public List<Person> searchByStreet(String street){
        List<Person> ans = new ArrayList<>();

        for(Person i: people){
            if(i.getAdr().getStreet().equals(street))
                ans.add(i);
        }

        return ans;
    }
}
