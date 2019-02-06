/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lesson1.Shape;

/**
 *
 * @author Pinnacle F
 */
public class Rectangle extends AbstractShape {

    private double l1;
    private double l2;

    public Rectangle(double l1, double l2) {
        this.l1 = l1;
        this.l2 = l2;
    }

    @Override
    public double getArea() {
        return this.l1 * this.l2;
    }

    @Override
    public double getCircumference() {
        return (this.l1 * 2) + (this.l2 * 2);
    }

}
