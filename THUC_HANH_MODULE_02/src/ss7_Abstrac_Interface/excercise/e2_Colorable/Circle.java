package ss7_Abstrac_Interface.excercise.e2_Colorable;

public class Circle extends Shape implements ColorAble {
    private double radius = 1.0;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    @Override
    public String toString() {
        return "A Circle with radius="
                + getRadius()
                + ", which is a subclass of "
                + super.toString()
                + ", Area ="
                + getArea()
                + ", Area ="
                + getPerimeter();
    }

    @Override
    public void howToColor() {
        System.out.println("hình tròn: tô hết vòng tròn");
    }
}

//    @Override
//    public void resize(double percent) {
//        this.radius *= (percent / 200);
//    }

//    public static class CircleTest {
//        public static void main(String[] args) {
//            Circle circle = new Circle();
//            System.out.println(circle);
//
//            circle = new Circle(3.5);
//            System.out.println(circle);
//
//            circle = new Circle(3.5, "indigo", false);
//            System.out.println(circle);
//        }
//    }

