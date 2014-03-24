/**
 * Filename:    ComplexNumber.java
 * Author:      Satyam Shandilya
 * Description: This class can be used as a data type for complex numbers.
 *              This data type is immutable.
 * Copyright(c) 2014. All Rights Reserved.
 */

package com.me.satyam.complex;

public class ComplexNumber {
    
    private static final String EMPTY       = "";
    private static final String IMAGINARY_I = "i";
    private static final String PLUS        = " + ";
    private static final String MINUS       = " - ";
    
    /**
     * Declare real and imaginary variables. 
     * To make the object immutable, use final keyword.
     */
    private final double real;
    private final double imaginary;
    
    /* Constructor */
    public ComplexNumber(double re, double img){
        real =  re;
        imaginary = img;
    }
    
    /**
     * Getter method for real part
     * @return double
     */
    public double getReal(){
        return this.real;
    }
    
    /**
     * Getter method for imaginary part
     * @return double
     */
    public double getImaginary(){
        return this.imaginary;
    }
     
    /**
     * This method is to find the phase of a Complex Number.
     * If A = a + bi
     * Then, |A| = Math.sqrt(re*re + im*im)
     * @return double
     */
    public double absolute(){
        return Math.hypot(this.real, this.imaginary);
    }
   
    /**
     * This method is to find the absolute of a Complex Number.
     * If A = a + bi
     * Then, tan (fi) = b/a    where fi is called the complex phase.
     * @return double
     */
    public double phase(){
        return Math.atan2(this.imaginary, this.real);
    }
    
    /**
     * This method is to find the conjugate of a Complex Number.
     * If A = a + bi
     * Then, Conjugate(A) = a - bi
     * @return ComplexNumber
     */
    public ComplexNumber getConjugate(){
        return new ComplexNumber(this.real, -this.imaginary);
    }
    
    /**
     * This method is to find the reciprocal of a Complex Number.
     * If A = a + bi
     * Then, Reciprocal(A) = Conjugate(A)/|A| * |A|
     * @return ComplexNumber
     */
     public ComplexNumber getReciprocal() {
        double scale = (this.real * this.real) + (this.imaginary * this.imaginary);
        return new ComplexNumber(this.real/scale, -this.imaginary/scale);
    }
    
    /**
     * This method is to add two complex numbers.
     * If A = a + bi, B = c + di
     * Then, A + B = (a + c) + (b + d)i
     * @param aComplex
     * @return ComplexNumber
     */
    public ComplexNumber add(ComplexNumber aComplex){
        double re = this.real + aComplex.real;
        double img = this.imaginary + aComplex.imaginary;
        return new ComplexNumber(re, img);
    }
    
    /**
     * This method is to subtract two complex numbers.
     * If A = a + bi, B = c + di
     * Then, A - B = (a - c) + (b - d)i
     * @param aComplex
     * @return ComplexNumber
     */
    public ComplexNumber subtract(ComplexNumber aComplex){
        double re = this.real - aComplex.real;
        double img = this.imaginary - aComplex.imaginary;
        return new ComplexNumber(re, img);
    }
    
    /**
     * This method is to multiply two complex numbers.
     * If A = a + bi, B = c + di
     * Then, A * B = ac + (ad + bc)i - bd
     * @param aComplex
     * @return ComplexNumber
     */
    public ComplexNumber doMultiply(ComplexNumber aComplex){
        double re = this.real * aComplex.real - this.imaginary * aComplex.imaginary;
        double img = this.real * aComplex.imaginary + this.imaginary * aComplex.real;
        return new ComplexNumber(re, img);
    }
    
    /**
     * This method is to multiply complex number with a double quantity.
     * If A = a + bi
     * Then, x * A = ax + bxi
     * @param doubleValue
     * @return ComplexNumber
     */
    public ComplexNumber doMultiply(double doubleValue){
        double re = this.real * doubleValue;
        double img = this.imaginary * doubleValue;
        return new ComplexNumber(re, img);
    }
    
    /**
     * This method is to divide a complex number with another complex number
     * If A = a + bi, B = c + di
     * Then, A / B = A * Reciprocal(B)
     * @param aComplex
     * @return ComplexNumber
     */
    public ComplexNumber doDivide(ComplexNumber aComplex){
        return this.doMultiply(aComplex.getReciprocal());
    }
    
    /**
     * This method is to exponential value of a complex number
     * If A = a + bi
     * Then, e^(a+bi) = e^a(cos b + i sin b)
     * @return ComplexNumber
     */
    public ComplexNumber exp() {
        return new ComplexNumber(Math.exp(this.real) * Math.cos(this.imaginary), Math.exp(this.real) * Math.sin(this.imaginary));
    }

    /**
     * This method is to sine value of a complex number
     * If A = a + bi
     * Then, sin(a+bi)= sin a . cosh b + i . (cos a) . (sinh b)
     * @return ComplexNumber
     */
    public ComplexNumber sin() {
        return new ComplexNumber(Math.sin(this.real) * Math.cosh(this.imaginary), Math.cos(this.real) * Math.sinh(this.imaginary));
    }

   /**
     * This method is to cosine value of a complex number
     * If A = a + bi
     * Then, cos(a+bi) = cos a . cosh b − i . (sin a) . (sinh b)
     * @return ComplexNumber
     */
    public ComplexNumber cos() {
        return new ComplexNumber(Math.cos(this.real) * Math.cosh(this.imaginary), -Math.sin(this.real) * Math.sinh(this.imaginary));
    }

    /**
     * This method is to tangent value of a complex number
     * If A = a + bi
     * Then, tan(a + bi) = sin(a + bi) / cos(a + bi)
     * @return ComplexNumber
     */
    public ComplexNumber tan() {
        return sin().doDivide(cos());
    }
    
    /**
     * This method is to hyperbolic sine value of a complex number
     * If A = a + bi
     * Then, sinh(a+bi)= sinh a . cos b + i . (cosh a) . (sin b)
     * @return ComplexNumber
     */
    public ComplexNumber sinh() {
        return new ComplexNumber(Math.sinh(this.real) * Math.cos(this.imaginary), Math.cosh(this.real) * Math.sin(this.imaginary));
    }

   /**
     * This method is to cosine value of a complex number
     * If A = a + bi
     * Then, cosh(a+bi) = cosh a . cos b + i . (sinh a) . (sinh b)
     * @return ComplexNumber
     */
    public ComplexNumber cosh() {
        return new ComplexNumber(Math.cosh(this.real) * Math.cos(this.imaginary), Math.sinh(this.real) * Math.sin(this.imaginary));
    }
    
    /**
     * toString method of this data type
     * @return string
     */
    @Override
    public String toString() {
        if (this.imaginary == 0){
            return this.real + EMPTY;
        }
        else if (this.real == 0){ 
            return this.imaginary + IMAGINARY_I;
        }
        else if (this.imaginary <  0){
            return this.real + MINUS + (-this.imaginary) + IMAGINARY_I;
        }
        else{
            return this.real + PLUS + this.imaginary + IMAGINARY_I;
        }
    }
    
}
