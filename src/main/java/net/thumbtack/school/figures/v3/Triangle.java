package net.thumbtack.school.figures.v3;


import net.thumbtack.school.colors.Color;
import net.thumbtack.school.colors.ColorException;

import java.util.Objects;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Triangle extends Figure {
    private Point2D point1;
    private Point2D point2;
    private Point2D point3;


    public Triangle(Point2D point1, Point2D point2, Point2D point3, String color) throws ColorException {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
        super.setColor(color);
    }
    public Triangle(Point2D point1, Point2D point2, Point2D point3, Color color) throws ColorException {
        this(point1,point2,point3,Color.toString(color));
    }

    public Point2D getPoint1() {
        return point1;
    }

    public void setPoint1(Point2D point1) {
        this.point1 = point1;
    }

    public Point2D getPoint2() {
        return point2;
    }

    public void setPoint2(Point2D point2) {
        this.point2 = point2;
    }

    public Point2D getPoint3() {
        return point3;
    }

    public void setPoint3(Point2D point3) {
        this.point3 = point3;
    }

    private double getLength(Point2D point1, Point2D point2) {
        return sqrt(pow(point2.getX() - point1.getX(), 2) + pow(point2.getY() - point1.getY(), 2));
    }

    private double getSide12() {
        return getLength(point1, point2);
    }

    private double getSide13() {
        return getLength(point1, point3);
    }

    private double getSide23() {
        return getLength(point2, point3);
    }

    public void moveRel(int dx, int dy) {
        point1.moveRel(dx, dy);
        point2.moveRel(dx, dy);
        point3.moveRel(dx, dy);
    }

    public double getArea() {
        double p = (getSide12() + getSide13() + getSide23()) / 2;
        return sqrt(p * (p - getSide12()) * (p - getSide23()) * (p - getSide13()));
    }

    public double getPerimeter() {
        return getSide12() + getSide13() + getSide23();
    }

    private int signSearch(Point2D point1, Point2D point2, int x, int y) {
        return (point1.getX() - x) * (point2.getY() - point1.getY()) - (point2.getX() - point1.getX()) * (point1.getY() - y);
    }

    public boolean isInside(int x, int y) {

        return (signSearch(point1, point2, x, y) <= 0 & signSearch(point2, point3, x, y) <= 0 & signSearch(point3, point1, x, y) <= 0)
                || (signSearch(point1, point2, x, y) >= 0 & signSearch(point2, point3, x, y) >= 0 & signSearch(point3, point1, x, y) >= 0);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Objects.equals(point1, triangle.point1) &&
                Objects.equals(point2, triangle.point2) &&
                Objects.equals(point3, triangle.point3)
                && Objects.equals(super.getColor(), triangle.getColor());
    }

    @Override
    public int hashCode() {

        return Objects.hash(point1, point2, point3, super.getColor());
    }


}
