package ss6_Inheritance.excercise.CircleAndCylinderClass;

public class Circle {
        private double radius = 1.0;
        private String color = "green";

        public Circle() {
        }

        public Circle(double radius, String color) {
            this.color = color;
            this.radius = radius;
        }

        public double getRadius() {
            return radius;
        }

        public String getColor() {
            return color;
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
            return "A Circle with radius = "
                    + getRadius()
                    + ", color  : "
                    + getColor()
                    + ", which is a subclass of "
                    + super.toString();
        }

        public static class CircleTest {
                public static void main(String[] args) {
                    Circle circle = new Circle();
                    System.out.println(circle);

                    circle = new Circle(3.5, "indigo");
                    System.out.println(circle);
                }
            }

        }

