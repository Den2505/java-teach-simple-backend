package net.thumbtack.school.figures.v3;

import net.thumbtack.school.area.HasArea;
import net.thumbtack.school.colors.Color;
import net.thumbtack.school.colors.ColorErrorCode;
import net.thumbtack.school.colors.ColorException;
import net.thumbtack.school.colors.Colored;

public abstract class Figure implements Colored,HasArea {
    private Color color;

    public abstract boolean equals(Object o);

    public abstract int hashCode();

    public abstract boolean isInside(int x, int y);

    public boolean isInside(Point2D point) {
        return isInside(point.getX(), point.getY());
    }

    public abstract void moveRel(int dx, int dy);

    public abstract double getArea();

    public abstract double getPerimeter();

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) throws ColorException {
        if (color == null) {
            throw new ColorException(ColorErrorCode.NULL_COLOR);
        } else
            this.color = color;
    }

    public void setColor(String color) throws ColorException {
        this.color = Color.colorFromString(color);
    }
}
