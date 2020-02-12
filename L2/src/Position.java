/*
 * Jesse Sierra, Chet Witte, David Gonzalez-Salzwedel
 * SE 2811
 * Winter 2019-2020
 * Lab 2b - Bee Simulator
 * Due: 4 Jan 2020
 */

/**
 * A Basic position class used to keep track of Bees and Flowers.
 */
public class Position {
    private static int xMaxValue = 900;
    private static int yMaxValue = 700;
    private static int xMinValue = 0;
    private static int yMinValue = 0;

    private double currentX;
    private double currentY;

    public Position( double x, double y){
        currentX = x;
        currentY = y;
    }

    public double getCurrentX(){
        return currentX;
    }

    public double getCurrentY(){
        return currentY;
    }

    public boolean setCurrentX(double x){
        if (x <= xMaxValue){
            if (x > 0){
                currentX = x;
                return true;
            } else {
                currentX = xMinValue;
                return false;
            }
        }else{
            currentX = xMaxValue;
            return false;
        }
    }

    public boolean setCurrentY(double y){
        if (y <= yMaxValue){
            if (y > 0){
                currentY = y;
                return true;
            } else {
                currentY = yMinValue;
                return false;
            }
        } else{
            currentY = yMaxValue;
            return false;
        }
    }
}
