package net.thumbtack.school.boxes;

import net.thumbtack.school.area.HasArea;
import net.thumbtack.school.figures.v3.Figure;

public class Box<T extends Figure> implements HasArea {
    private static final double DOUBLE_EPS = 1E-6;
    private T content;

    public Box(T obj) {
        setContent(obj);
    }

    @Override
    public double getArea() {
        return content.getArea();
    }

    public boolean isAreaEqual(Box box) {
        return Math.abs(this.getArea() - box.getArea()) <= DOUBLE_EPS;
    }

    public static boolean isAreaEqual(Box box, Box box2) {
        return box.isAreaEqual(box2);
    }

    public T getContent() {
        return content;
    }

    public void setContent(T obj) {
        this.content = obj;
    }
}
