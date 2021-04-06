package learntasktwo.extendedclass;

public class Test {
    public static void main(String[] args) {
        ExtendedClass e = new ExtendedClass((byte) 1, 2, 4.84, "corn");
        ExtendedClass e1 = new ExtendedClass((byte) 1, 2, 4.84, "corn");
        ExtendedClass e2 = new ExtendedClass((byte) 1, 2, 4.84, "kukuruza");

        System.out.println("hashcode e: " + e.hashCode() + "\nhashcode e1: " + e1.hashCode() + "\nhashcode e2: " + e2.hashCode());
        System.out.println("e.toString: " + e.toString());
        System.out.println(e.equals(e1));
        System.out.println(e.equals(e2));

    }
}
