package learntaskthree.phonenumber;

public class PhoneNumber {
    private String number;

    public PhoneNumber(String newNumber){
        number = newNumber;
    }

    //возращает номер телефона
    public String getNumber() {
        return number;
    }

    //меняет формат номера
    public void changeFormat(){
        String res;
        if (number.charAt(0) == '8'){
            number = new String("+7" + number.substring(1, 4) + "-" + number.substring(4, 7) + "-" + number.substring(7, 11));
        }
        else {
            number = new String(number.substring(0, 5) + "-" + number.substring(5, 8) + "-" +number.substring(8, 12));
        }
    }
}
