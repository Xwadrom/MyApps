package Shapes;

public class Triangle implements Patterns {
    private double a;
    private double b;
    private double c;

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }


    @Override
    public double calculateArea() {//pole
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public double calculatePerimeter() {//obwod
        return a + b + c;
    }//obwo
}
