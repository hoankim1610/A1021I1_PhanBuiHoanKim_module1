package ss6_Inheritance.excercise.PointAndMoveablePoint;

import ss6_Inheritance.excercise.Point2DAndPoint3DClass.Point2D;

public class MoveAblePoint extends Point {
    private double xSpeed = 0;
    private double ySpeed = 0;


    public MoveAblePoint(double x, double y, double xSpeed, double ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MoveAblePoint() {
    }

    public MoveAblePoint(double[] a) {
        super(a[0], a[1]);
    }

    public MoveAblePoint(double xSpeed, double ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public double getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(double xSpeed) {
        this.xSpeed = xSpeed;
    }

    public double getySpeed() {
        return ySpeed;
    }

    public void setySpeed(double ySpeed) {
        this.ySpeed = ySpeed;
    }

    public Point move() {
        this.setX(this.getX() + this.xSpeed);
        this.setY(this.getY() + this.ySpeed);
        return this;
    }

    public void setSpeed(double xSpeed, double ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public double[] getSpeed() {
        double[] out = {this.xSpeed, this.ySpeed};
        return out;
    }

    @Override
    public String toString() {
        return super.toString() +
                "+ speed: (" + this.xSpeed + "," + this.ySpeed + ")" + "\n";
    }

}
