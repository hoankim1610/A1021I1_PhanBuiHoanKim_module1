package ss6_Inheritance.excercise.PointAndMoveablePoint;

public class Test {
    public static void main(String[] args) {
        Point unknownPoint = new Point(20,30);
        System.out.println(unknownPoint.toString());
        unknownPoint.setXY(10,20);
        System.out.println(unknownPoint.toString());
        unknownPoint = new MoveAblePoint(unknownPoint.getX(),
                unknownPoint.getY(),
                10,
                20);
        System.out.println(unknownPoint.toString());
        ((MoveAblePoint) unknownPoint).move();
        System.out.println(unknownPoint.toString());
        MoveAblePoint anotherPoint = new MoveAblePoint(20,20);
        System.out.println(anotherPoint.toString());
        anotherPoint.move();
        System.out.println(anotherPoint.toString());
    }
}
