package net.thumbtack.school.figures.v1;

import java.util.Objects;

public class Rectangle {
   private Point2D topLeft;
    private Point2D bottomRight;






    public Point2D getTopLeft() {
        return topLeft;
    }


    public Point2D getBottomRight() {
        return bottomRight;
    }

    public int getLength() {

        return bottomRight.getX()-topLeft.getX();
    }

    public int getWidth() {
        return bottomRight.getY()-topLeft.getY();
    }

    public Rectangle(Point2D leftTop, Point2D rightBottom){
        this.topLeft = leftTop;
        this.bottomRight = rightBottom;
    }
    public Rectangle(int xLeft, int yTop, int xRight, int yBottom){
        topLeft = new Point2D(xLeft,yTop);
        bottomRight = new Point2D(xRight,yBottom);
    }
    public Rectangle(int length, int width){
topLeft = new Point2D(0, 0-width);
bottomRight = new Point2D(length,0);
    }
    public Rectangle(){
        this(1,1);
    }
    public void moveRel(int dx, int dy){
        topLeft.moveRel(dx,dy);
        bottomRight.moveRel(dx,dy);

    }
    public void enlarge(int nx, int ny){
    bottomRight = new Point2D(nx*bottomRight.getX() - (nx-1)*topLeft.getX(),
           ny*bottomRight.getY()-(ny-1)*topLeft.getY());
    }
    public double getArea(){
        return getLength()*getWidth();
    }
    public double getPerimeter(){
        return 2*(getWidth()+getLength());
    }
    public boolean isInside(int x, int y){

        return x>=topLeft.getX() & x<=bottomRight.getX() & y>=topLeft.getY() & y<=bottomRight.getY();
    }
    public boolean isInside(Point2D point){
      return   isInside(point.getX(),point.getY());
    }
    private Point2D getBottomLeft(){
        return new Point2D(topLeft.getX(),bottomRight.getY());
    }
    private Point2D getTopRight(){
        return new Point2D(topLeft.getY(),bottomRight.getX());
    }
    public boolean isIntersects(Rectangle rectangle) {
        return isInside(rectangle.topLeft) || isInside(rectangle.bottomRight) || isInside(rectangle.getBottomLeft()) || isInside(rectangle.getTopRight()) || rectangle.isInside(topLeft) || rectangle.isInside(bottomRight) || rectangle.isInside(getBottomLeft()) || rectangle.isInside(getTopRight());
    }
    public boolean isInside(Rectangle rectangle){
        return isInside(rectangle.topLeft) & isInside(rectangle.bottomRight) & isInside(rectangle.getBottomLeft()) & isInside(rectangle.getTopRight());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rectangle)) return false;
        Rectangle rectangle = (Rectangle) o;
        return Objects.equals(getTopLeft(), rectangle.getTopLeft()) &&
                Objects.equals(getBottomRight(), rectangle.getBottomRight());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getTopLeft(), getBottomRight());
    }
}
