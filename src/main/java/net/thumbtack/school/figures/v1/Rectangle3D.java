package net.thumbtack.school.figures.v1;

import java.util.Objects;

public class Rectangle3D extends Rectangle {
    private int height;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Rectangle3D(Point2D leftTop, Point2D rightBottom, int height) {
        super(leftTop, rightBottom);
        this.height = height;
    }

    public Rectangle3D(int xLeft, int yTop, int xRight, int yBottom, int height) {
        super(xLeft, yTop, xRight, yBottom);
        this.height = height;
    }

    public Rectangle3D(int length, int width, int height) {
        super(length, width);
        this.height = height;
    }

    public Rectangle3D() {
        this(1, 1, 1);
    }

    public double getVolume(){
       return super.getArea()*height;
    }
    public boolean isInside(int x, int y, int z){

        return super.isInside(x,y) && z<=height;
    }
    public boolean isInside(Point3D point){
        return this.isInside(point.getX(),point.getY(),point.getZ());
    }
    public boolean isIntersects(Rectangle3D rectangle){
        return super.isIntersects(new Rectangle(rectangle.getTopLeft(),rectangle.getBottomRight()));
    }
    public boolean isInside(Rectangle3D rectangle){
        return super.isInside(new Rectangle(rectangle.getTopLeft(),rectangle.getBottomRight()))
                && rectangle.getHeight()<=this.height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rectangle3D)) return false;
        if (!super.equals(o)) return false;
        Rectangle3D that = (Rectangle3D) o;
        return height == that.height;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), height);
    }
}



