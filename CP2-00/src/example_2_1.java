import java.io.*;
class Point{
    protected double x,y;

    public Point() {x = 0.0; y = 0.0;}

    public double distance() {return Math.sqrt(x*x + y*y);}

    public final void move(double dx, double dy) {x += dx; y += dy;}

    public void draw() {System.out.println("Point is drawn at " + x + "," + y);}
}

class Circle extends Point{
    private double r;
    public Circle(double radius) { x = 1.0; y = 1.0; r =radius; }
    public double diameter() { return 2.0*r; }

    @Override
    public void draw(){
        System.out.println("Circle is drawn at " + x + "," + y);
    }
}

public class example_2_1 {
    public static void main(String[] args){
        Point p = new Point();
        Circle c = new Circle(10.0);
        p.move(12.0, 5.0);
        c.move(3.0, 4.0);
        p = c;
        p.draw();
        c.draw();
        System.out.println(c.diameter());
    }
}
