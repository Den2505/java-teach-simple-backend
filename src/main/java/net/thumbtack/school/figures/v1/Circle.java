package net.thumbtack.school.figures.v1;

import java.util.Objects;

import static java.lang.Math.PI;
import static java.lang.Math.abs;
import static java.lang.Math.pow;

public class Circle {
    private Point2D center;
   private int radius;
    public Circle(Point2D center, int radius){
        this.center = center;
        this.radius = radius;
    }
    public Circle(int xCenter, int yCenter, int radius){
    this.radius = radius;
    center = new Point2D(xCenter,yCenter);
    }
    public Circle(int radius){
        center = new Point2D(0,0);
        this.radius = radius;
    }
    public Circle(){
        this(1);
    }
    public Point2D getCenter(){
        return center;
    }
    public int getRadius(){
        return radius;
    }
    public void setCenter(Point2D center){
        this.center = center;
    }
    public void setRadius(int radius){
        this.radius = radius;
    }
    public void moveRel(int dx, int dy){
        center.moveRel(dx,dy);
    }
    public void enlarge(int n){
        radius*=n;
    }
    public double getArea(){
        return PI*radius*radius;
    }
    public double getPerimeter(){
        return 2*PI*radius;
    }
    public boolean isInside(int x, int y){
       return (pow((x-center.getX()),2)+pow((y-center.getY()),2))<=pow(radius,2);
    }
    public boolean isInside(Point2D point){
        return isInside(point.getX(),point.getY());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Circle)) return false;
        Circle circle = (Circle) o;
        return getRadius() == circle.getRadius() &&
                Objects.equals(getCenter(), circle.getCenter());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getCenter(), getRadius());
    }
}
