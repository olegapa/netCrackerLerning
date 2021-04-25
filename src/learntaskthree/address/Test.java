package learntaskthree.address;

public class Test {
    public static void main(String[] args) {
        Address a1 = new Address();
        a1.setAddrComma("Russia, Moscow district, Moscow, Raspletina street 9, 42");
        System.out.println(a1.getFullAddress());

        Address a2 = new Address();
        a2.setAddrToken("Russia, Moscow district, Moscow, Raspletina street 9, 42");
        System.out.println(a1.getFullAddress());

        Address a3 = new Address();
        a1.setAddrToken("USA; California; Los Angeles; random house; 2");
        System.out.println(a1.getFullAddress());

        Address a4 = new Address();
        a1.setAddrToken("USA; California-Los Angeles         ,random house. 2");
        System.out.println(a1.getFullAddress());
    }
}
