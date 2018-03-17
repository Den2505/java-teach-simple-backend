package net.thumbtack.school.boxes;

import net.thumbtack.school.colors.Color;
import net.thumbtack.school.colors.ColorException;
import net.thumbtack.school.figures.v3.Figure;


public class NamedBox<T extends Figure> extends Box<T> {
    private String name;

    public NamedBox(T obj, String name) {
        super(obj);
        this.name = name;

    }

    public String getName() throws ColorException {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
