package ru.skillbench.tasks.basics.math;


import java.util.Arrays;

public class ArrayVectorImpl implements ArrayVector{
    private double[] v;

    public ArrayVectorImpl(){
        v = null;
    }

    public ArrayVectorImpl(double... elements){
        v = new double[elements.length];
        System.arraycopy(elements, 0, v, 0, elements.length);
    }

    @Override
    public void set(double... elements) {
        v = elements;
    }

    @Override
    public double[] get() {
        return v;
    }

    @Override
    public ArrayVector clone() {
        return new ArrayVectorImpl(v);
    }

    @Override
    public int getSize() {
        return v.length;
    }

    public void set(int index, double value) {
        if(index < 0)
            return;
        else if(index < v.length)
            v[index] = value;
        else{
            v = Arrays.copyOf(v, index+1);
            v[index] = value;
        }
    }
    @Override
    public double get(int index) throws ArrayIndexOutOfBoundsException {
        if(index < 0 || index >= v.length)
            throw new ArrayIndexOutOfBoundsException();

        return v[index];
    }

    @Override
    public double getMax() {
        double max = v[0];
        for (double i: v){
            if(max < i)
                max = i;
        }
        return max;
    }

    @Override
    public double getMin() {
        double min = v[0];
        for (double i: v){
            if(min > i)
                min = i;
        }
        return min;
    }

    private void swap(int l, int r){
        double temp = v[l];
        v[l] = v[r];
        v[r] = temp;
    }

    @Override
    public void sortAscending() {
        double[] temp = new double[v.length];

        for(int j = 0; j < v.length-1; j++) {
            double min = v[j];
            int mInd = j;
            for (int i = j; i < v.length; i++) {
                if (v[i] < min) {
                    min = v[i];
                    mInd = i;
                }
            }
            swap(j, mInd);
        }
    }

    @Override
    public void mult(double factor) {
        for(int i = 0; i < v.length; i++)
            v[i] *= factor;
    }

    @Override
    public ArrayVector sum(ArrayVector anotherVector) {
        for(int i = 0; i < v.length; i++)
            v[i] += anotherVector.get(i);
        return this;
    }

    @Override
    public double scalarMult(ArrayVector anotherVector) {
        double res = 0;
        for(int i = 0; i < v.length; i++)
            res += v[i]*anotherVector.get(i);
        return res;
    }

    @Override
    public double getNorm() {
        return Math.sqrt(scalarMult(this));
    }
}
