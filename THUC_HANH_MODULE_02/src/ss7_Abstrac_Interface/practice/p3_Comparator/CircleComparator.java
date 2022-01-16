package ss7_Abstrac_Interface.practice.p3_Comparator;

import java.util.Arrays;
import java.util.Comparator;

public class CircleComparator implements Comparator<Circle> {
    @Override
    public int compare(Circle c1, Circle c2) {
        if (c1.getRadius() > c2.getRadius()) return 1;
        else if (c1.getRadius() < c2.getRadius()) return -1;
        else return 0;
    }

    public static class CircleComparatorTest {
        public static void main(String[] args) {
            Circle[] circles = new Circle[3];
            circles[0] = new Circle(3.6);
            circles[1] = new Circle();
            circles[2] = new Circle(3.5, "indigo", false);

            System.out.println("Pre-sorted:");
            for (Circle circle : circles) {
                System.out.println(circle);
            }

            Comparator circleComparator = new CircleComparator();
            Arrays.sort(circles, circleComparator);

            System.out.println("After-sorted:");
            for (Circle circle : circles) {
                System.out.println(circle);
            }
        }
    }

}
