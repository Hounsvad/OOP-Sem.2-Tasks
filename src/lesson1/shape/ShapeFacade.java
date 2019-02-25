/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson1.shape;

/**
 *
 * @author erso
 */
public class ShapeFacade {

    //Singleton Stuff:
    private static ShapeFacade instance = null;
    
    public static ShapeFacade getInstance() {
        if (instance == null) {
            instance = new ShapeFacade();
        }
        return instance;
    }
    
    private ShapeFacade() {
    }
    //---------------------------

    // enum som kendes af GUI'en
    public enum SHAPES {
        CIRCLE,
        ELLIPSE,
        RECTANGLE,
        SQUARE
    };

    // Facadens public metoder
    public String getShapeInfo(SHAPES shape, double... parametre) {
        switch (shape) {
            case CIRCLE:
                return new Circle(parametre[0]).toString();
            case ELLIPSE:
                return new Ellipse(parametre[0], parametre[1]).toString();
            case RECTANGLE:
                return new Rectangle(parametre[0], parametre[1]).toString();
            case SQUARE:
                return new Square(parametre[0]).toString();
            default:
                throw new AssertionError();
        }
    }
    
}
