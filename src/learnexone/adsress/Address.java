package learnexone.adsress;

public class Address {
    private final String street;
    private final int house, flat;

    Address(String street, int house, int flat){
        this.street = street;
        this.house = house;
        this.flat = flat;
    }

    public String getStreet() {
        return street;
    }

    public int getHouse() {
        return house;
    }

    public int getFlat() {
        return flat;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;

        if(obj instanceof Address)
            return ((Address) obj).street.equals(street) && (((Address) obj).house == house) && (((Address) obj).flat == flat);
        return false;
    }

    public void printAdr(){
        System.out.println(street + ", house: " + house + ", flat: " + flat);
    }
}
