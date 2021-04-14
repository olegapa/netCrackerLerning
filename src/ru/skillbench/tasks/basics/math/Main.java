package ru.skillbench.tasks.basics.math;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        double[] v = {2, 3, 1, 0, -1};
        ArrayVectorImpl vector = new ArrayVectorImpl();
        vector.set(5, 5);
        vector.set(65, 1);

        System.out.print(Arrays.toString(vector.get()) + vector.getSize());
    }
}
