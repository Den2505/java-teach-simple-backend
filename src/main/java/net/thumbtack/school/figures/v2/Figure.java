package net.thumbtack.school.figures.v2;

public abstract class Figure implements Colored {
    private int color;
    public abstract boolean equals(Object o);

    public abstract int hashCode();

    public abstract boolean isInside(int x, int y);

    public boolean isInside(Point2D point) {
        return isInside(point.getX(), point.getY());
    }

    public abstract void moveRel(int dx, int dy);

    public abstract double getArea();

    public abstract double getPerimeter();
    public int getColor(){return color;}
    public void setColor(int color){this.color = color;}
}
