package learntaskone.adsress;

//Человек
public class Person {

    private final String name;
    private final Address adr;
    private final int[] birthday;

    Person(String name, Address newAdr, int[] birthday){
        this.name = name;
        adr = newAdr;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public Address getAdr() {
        return adr;
    }

    public int[] getBirthday() {
        return birthday;
    }

    //Возвращает true если date позже чем день рождение этого человека
    public boolean isDateLater(int[] date){
        if(date[2] > birthday[2])
            return true;
        else if(date[2] == birthday[2]) {
            if (date[1] > birthday[1])
                return true;
            else if(date[1] == birthday[1]){
                return date[0] > birthday[0];
            }
            else return false;
        }
        else return false;
    }

    // Печатает всю информацию о этом человеке
    public void printInfo(){
        System.out.print(name + ", born: " + birthday[0] + "." + birthday[1] + "." + birthday[2] + " lives: ");
        adr.printAdr();
    }
}
