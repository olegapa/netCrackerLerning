package learnexone.adsress;

import java.util.ArrayList;
import java.util.List;

public class People {
    private final Person[] people;

    People(Person[] people){
        this.people = people;
    }

    public List<Person> searchByAddress(Address adr){
        List<Person> ans = new ArrayList<>();

        for(Person i: people){
            if(i.getAdr().equals(adr))
                ans.add(i);
        }

        return ans;
    }

    public Address searchByName(String name){

        for(Person i: people){
            if(i.getName().equals(name))
                return i.getAdr();
        }
        return null;
    }

    public List<Person> searchByBirthdayRange(int[] date1, int[] date2){
        List<Person> ans = new ArrayList<>();

        for(Person i: people){
            if(!i.isDateLater(date1) && i.isDateLater(date2))
                ans.add(i);
        }

        return ans;
    }

    public Person findOldes(){
        Person ans = people[0];

        for(Person i: people){
            if(ans.isDateLater(i.getBirthday()))
                ans = i;
        }
        return ans;
    }

    public Person findYoungest(){
        Person ans = people[0];

        for(Person i: people){
            if(!ans.isDateLater(i.getBirthday()))
                ans = i;
        }
        return ans;
    }

    public List<Person> searchByStreet(String street){
        List<Person> ans = new ArrayList<>();

        for(Person i: people){
            if(i.getAdr().getStreet().equals(street))
                ans.add(i);
        }

        return ans;
    }
}
