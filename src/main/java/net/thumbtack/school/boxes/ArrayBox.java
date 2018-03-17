package net.thumbtack.school.boxes;

import net.thumbtack.school.figures.v3.Figure;

public class ArrayBox<T extends Figure> {
    private T[] content;

    public ArrayBox(T[] content) {
        setContent(content);
    }

    public T getElement(int i) {
        return getContent()[i];
    }

    public void setElement(T value, int i) {
        getContent()[i] = value;
    }

    public boolean isSameSize(ArrayBox box) {
        return this.getLength() == box.getLength();
    }

    public T[] getContent() {
        return content;
    }

    public int getLength() {
        return getContent().length;
    }

    public void setContent(T[] content) {
        this.content = content;
    }
}
