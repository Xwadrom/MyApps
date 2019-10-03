package Shapes;

public class Circle implements Patterns {

    private double r;

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    @Override
    public double calculateArea() {//pole
        return Patterns.PI * r * r;
    }//pole

    @Override
    public double calculatePerimeter() {//obwod
        return 2 * Patterns.PI * r;
    }
}
