package ss7_Abstrac_Interface.practice.p2_Comparable;

import java.util.Arrays;

public class ComparableCircle extends Circle
        implements Comparable<ComparableCircle>{

    public ComparableCircle() {
    }

    public ComparableCircle(double radius) {
        super(radius);
    }

    public ComparableCircle(double radius, String color, boolean filled) {
        super(radius, color, filled);
    }

    @Override
    public int compareTo(ComparableCircle o) {
        if (getRadius() > o.getRadius()) return 1;
        else if (getRadius() < o.getRadius()) return -1;
        else return 1;
    }

    public static class ComparableCircleTest {
        public static void main(String[] args) {
            ComparableCircle[] circles = new ComparableCircle[3];
            circles[0] = new ComparableCircle(3.6);
            circles[1] = new ComparableCircle();
            circles[2] = new ComparableCircle(3.5, "indigo", false);

            System.out.println("Pre-sorted:");
            for (ComparableCircle circle : circles) {
                System.out.println(circle);
            }

            Arrays.sort(circles);

            System.out.println("After-sorted:");
            for (ComparableCircle circle : circles) {
                System.out.println(circle);
            }
        }
    }
}