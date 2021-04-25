package ru.skillbench.tasks.basics.math;

import java.util.Arrays;
import java.util.Comparator;

public class ComplexNumberImpl implements ComplexNumber{
    private double re;
    private double im;

    public ComplexNumberImpl(){
        re = 0;
        im = 0;
    }


    public ComplexNumberImpl( double re, double im){
        this.re = re;
        this.im = im;
    }

    @Override
    public double getRe() {
        return re;
    }

    @Override
    public double getIm() {
        return im;
    }

    @Override
    public boolean isReal() {
        return (im == 0);
    }

    @Override
    public void set(double re, double im) {
        this.re = re;
        this.im = im;
    }

    @Override
    public void set(String value) throws NumberFormatException {
        int iPlace = value.indexOf("i");
        if( iPlace == -1){
            re = Double.parseDouble(value);
            im = 0;
            return;
        }
        if( iPlace != value.length()-1){
            throw new NumberFormatException();
        }
        int j = 1;
        for(; iPlace-j >= 0 && (Character.isDigit( value.charAt(iPlace-j)) || value.charAt(iPlace-j) == '.') ; j++);
        int imPart = iPlace-j+1;
        if(imPart == 0){
            re = 0;
            if( imPart == iPlace){
                im = Double.parseDouble( value.substring(0,iPlace) + "1");
            }else{
                im = Double.parseDouble( value.substring(0,iPlace) );
            }
            return;
        }else{
            if( imPart == iPlace){
                im = Double.parseDouble(value.substring(imPart-1,iPlace) + "1" );
            }
            else{
                im = Double.parseDouble(value.substring(imPart-1,iPlace));
            }

            if(imPart-1 != 0){
                re = Double.parseDouble(value.substring(0,imPart-1));
            }else{
                re = 0;
            }
            return;
        }
    }

    @Override
    public ComplexNumber copy() {
        ComplexNumber ret = new ComplexNumberImpl(re, im);
        return ret;
    }

    @Override
    public ComplexNumber clone() throws CloneNotSupportedException {
        return (ComplexNumber) super.clone();
    }

    @Override
    public String toString()
    {
        if (Double.compare(im, 0) == 0){
            return Double.toString(re);
        }
        if (Double.compare(re, 0) == 0){
            return Double.toString(im) + "i";
        }
        if (im > 0){
            return Double.toString(re) + "+" + Double.toString(im) + "i";
        }
        return Double.toString(re) + Double.toString(im) + "i";
    }

    @Override
    public boolean equals(Object other){
        if(other == this)
            return true;

        if ( other == null )
            return false;
        if(other instanceof  ComplexNumber)
            return (((ComplexNumber) other).getRe() == re) && (((ComplexNumber) other).getIm() == im);
        return false;
    }

    @Override
    public int compareTo(ComplexNumber other) {
        if(Math.hypot(re, im) - Math.hypot(other.getRe(), other.getIm()) > 0)
            return 1;
        else if(Math.hypot(re, im) - Math.hypot(other.getRe(), other.getIm()) < 0)
            return -1;
        else
            return 0;
    }

    @Override
    public void sort(ComplexNumber[] array) {
        Arrays.sort(array, new Comparator<ComplexNumber>(){

            @Override
            public int compare(ComplexNumber arg0, ComplexNumber arg1) {
                return arg0.compareTo(arg1);
            }

        });
    }


    @Override
    public ComplexNumber negate() {
        im *= (-1);
        re *= (-1);
        return this;
    }

    @Override
    public ComplexNumber add(ComplexNumber arg2) {
        re += arg2.getRe();
        im += arg2.getIm();
        return this;
    }

    @Override
    public ComplexNumber multiply(ComplexNumber arg2) {
        double temp = re;
        re = re * arg2.getRe() - im * arg2.getIm();
        im = temp * arg2.getIm() + im * arg2.getRe();
        return this;
    }

}