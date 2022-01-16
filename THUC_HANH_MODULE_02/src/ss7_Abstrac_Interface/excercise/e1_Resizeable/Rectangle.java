package ss7_Abstrac_Interface.excercise.e1_Resizeable;

public class Rectangle extends Shape {
    private double width = 1.0;
    private double length = 1.0;

    public Rectangle() {
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getArea() {
        return width * this.length;
    }

    public double getPerimeter() {
        return 2 * (width + this.length);
    }

    @Override
    public String toString() {
        return "A Rectangle with width="
                + getWidth()
                + " and length="
                + getLength()
                + ", which is a subclass of "
                + super.toString()
                + ", Area ="
                + getArea()
                + ", Area ="
                + getPerimeter();
    }

    @Override
    public void resize(double percent) {
        this.length *= (percent / 200);
        this.width += (percent / 200);
    }

//    public static class ComparableCircleTest {
//        public static void main(String[] args) {
//            ComparableCircle[] circles = new ComparableCircle[3];
//            circles[0] = new ComparableCircle(3.6);
//            circles[1] = new ComparableCircle();
//            circles[2] = new ComparableCircle(3.5, "indigo", false);
//
//            System.out.println("Pre-sorted:");
//            for (ComparableCircle circle : circles) {
//                System.out.println(circle);
//            }
//
//            Arrays.sort(circles);
//
//            System.out.println("After-sorted:");
//            for (ComparableCircle circle : circles) {
//                System.out.println(circle);
//            }
//        }
//    }

}
