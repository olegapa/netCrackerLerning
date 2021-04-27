package learntaskthree.phonenumber;

public class TestPhone {
    public static void main(String[] args) {
        PhoneNumber phone1 = new PhoneNumber("+79175655655");
        PhoneNumber phone2 = new PhoneNumber("89175655655");

        phone1.changeFormat();
        phone2.changeFormat();

        System.out.println(phone1.getNumber() + "\n" + phone2.getNumber());
    }
}
