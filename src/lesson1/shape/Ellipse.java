/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson1.shape;

/**
 *
 * @author Pinnacle F
 */
public class Ellipse extends AbstractShape{
    private double r1;
    private double r2;

    public Ellipse(double r1, double r2) {
        this.r1 = r1;
        this.r2 = r2;
    }

    @Override
    public double getArea() {
        return Math.PI * this.r1 * this.r2;
    }

    @Override
    public double getCircumference() {
        return 2 * Math.PI * Math.sqrt(0.5*(this.r1+this.r2));
    }

    
    
    

}
