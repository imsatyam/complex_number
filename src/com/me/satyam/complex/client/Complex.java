/**
 * FileName:    Complex.java
 * Author:      Satyam Shandilya
 * Description: This class is to verify the ComplexNumber data type class
 * Copyright(C) 2014. All Rights Reserved.
 * 
 * Data set for verification
 * 
 * a            = 10.0 + 12.0i
 * b            = -6.0 + 8.0i
 * Re(a)        = 10.0
 * Im(a)        = 12.0
 * a + b        = 4.0 + 20.0i
 * a - b        = 16.0 + 4.0i
 * a * b        = -156.0 + 8.0i
 * a / b        = 0.36 - 1.52i
 * Recip(a)     = 0.040983606557377046 - 0.04918032786885246i
 * conj(a)      = 10.0 - 12.0i
 * |a|          = 15.620499351813308
 * sin(a)       = -44271.02121683838 - 68281.45584765362i
 * cos(a)       = -68281.45585280907 + 44271.02121349579i
 * tan(a)       = 6.893008386299471E-11 + 0.9999999999691886i
 * exp(a)       = 18587.12035783348 - 11818.80502475621i
 */

package com.me.satyam.complex.client;

import com.me.satyam.complex.ComplexNumber;

public class Complex {
    public static void main(String[] args) {
        ComplexNumber a = new ComplexNumber(10.0, 12.0);
        ComplexNumber b = new ComplexNumber(-6.0, 8.0);

        System.out.println("a            = " + a);
        System.out.println("b            = " + b);
        System.out.println("Re(a)        = " + a.getReal());
        System.out.println("Im(a)        = " + a.getImaginary());
        System.out.println("a + b        = " + a.add(b));
        System.out.println("a - b        = " + a.subtract(b));
        System.out.println("a * b        = " + a.doMultiply(b));
        System.out.println("a / b        = " + a.doDivide(b));
        System.out.println("Recip(a)     = " + a.getReciprocal());
        System.out.println("conj(a)      = " + a.getConjugate());
        System.out.println("|a|          = " + a.absolute());
        System.out.println("sin(a)       = " + a.sin());
        System.out.println("cos(a)       = " + a.cos());
        System.out.println("tan(a)       = " + a.tan());
        System.out.println("exp(a)       = " + a.exp());
    }
}
