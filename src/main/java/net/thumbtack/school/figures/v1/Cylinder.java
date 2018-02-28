package net.thumbtack.school.figures.v1;

import java.util.Objects;

public class Cylinder extends Circle {
    private int height;
    public Cylinder(Point2D center, int radius, int height){
        super(center,radius);
        this.setHeight(height);
    }
    public Cylinder(int xCenter, int yCenter, int radius, int height){
super(xCenter,yCenter,radius);
this.setHeight(height);
    }
    public Cylinder(int radius, int height){
        super(radius);
        this.setHeight(height);
    }
    public Cylinder(){
        this(1,1);
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    public double getVolume()  {
        return super.getArea() * height;
    }
    public boolean isInside(int x, int y, int z){
      return   super.isInside(x,y) && z<=height;
    }
    public boolean isInside(Point3D point){
      return   isInside(point.getX(),point.getY(),point.getZ());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cylinder)) return false;
        if (!super.equals(o)) return false;
        Cylinder cylinder = (Cylinder) o;
        return height == cylinder.height;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), height);
    }
}
