package net.thumbtack.school.figures.v2;

import java.util.Objects;

import static java.lang.Math.PI;
import static java.lang.Math.pow;

public class Circle extends Figure {
    private Point2D center;
    private int radius;


    public Circle(Point2D center, int radius, int color) {
        this.center = center;
        this.radius = radius;
        super.setColor(color);
    }

    public Circle(int xCenter, int yCenter, int radius, int color) {
        this.radius = radius;
        center = new Point2D(xCenter, yCenter);
        super.setColor(color);
    }

    public Circle(int radius, int color) {
        center = new Point2D(0, 0);
        this.radius = radius;
        super.setColor(color);
    }

    public Circle(int color) {
        this(1, color);
    }

    public Point2D getCenter() {
        return center;
    }

    public void setCenter(Point2D center) {
        this.center = center;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void moveRel(int dx, int dy) {
        center.moveRel(dx, dy);
    }

    public void enlarge(int n) {
        radius *= n;
    }

    public double getArea() {
        return PI * radius * radius;
    }

    public double getPerimeter() {
        return 2 * PI * radius;
    }

    public boolean isInside(int x, int y) {
        return (pow((x - center.getX()), 2) + pow((y - center.getY()), 2)) <= pow(radius, 2);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Circle)) return false;
        Circle circle = (Circle) o;
        return radius == circle.radius &&
                Objects.equals(center, circle.center)
                && Objects.equals(super.getColor(), circle.getColor());
    }

    @Override
    public int hashCode() {

        return Objects.hash(center, radius, super.getColor());
    }
}
