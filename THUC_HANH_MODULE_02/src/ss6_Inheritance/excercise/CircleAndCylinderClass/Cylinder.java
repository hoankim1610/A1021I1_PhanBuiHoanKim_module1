package ss6_Inheritance.excercise.CircleAndCylinderClass;

public class Cylinder extends Circle {
    private double height = 1.0;

    public Cylinder() {
    }

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume() {
        return Math.PI * getRadius() * getRadius() * height;
    }

    @Override
    public String toString() {
        return "A Cylinder with height = "
                + getHeight()
                + ", volume = "
                + getVolume()
                + ", which is a subclass of "
                + super.toString();
    }

    public static class CylinderTest {
        public static void main(String[] args) {
            Cylinder cylinder = new Cylinder();
            System.out.println(cylinder);

            cylinder = new Cylinder(4.0, "yellow", 5);
            System.out.println(cylinder);
        }
    }

}
