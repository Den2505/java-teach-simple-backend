package net.thumbtack.school.boxes;

import net.thumbtack.school.area.HasArea;
import net.thumbtack.school.figures.v3.Figure;

public class PairBox<T extends Figure, D extends Figure> implements HasArea {
    private T contentFirst;
    private D contentSecond;
    private static final double DOUBLE_EPS = 1E-6;
    public PairBox(T contentFirst,D contentSecond){
        this.contentFirst = contentFirst;
        this.contentSecond = contentSecond;
    }

    public T getContentFirst() {
        return contentFirst;
    }

    public void setContentFirst(T contentFirst) {
        this.contentFirst = contentFirst;
    }

    public D getContentSecond() {
        return contentSecond;
    }

    public void setContentSecond(D contentSecond) {
        this.contentSecond = contentSecond;
    }

    @Override
    public double getArea() {
        return getContentFirst().getArea()+getContentSecond().getArea();
    }
    public boolean isAreaEqual(PairBox box){
        return Math.abs(this.getArea() - box.getArea())<DOUBLE_EPS;
    }
    public static boolean isAreaEqual(PairBox box, PairBox box2){
        return box.isAreaEqual(box2);
    }
}
