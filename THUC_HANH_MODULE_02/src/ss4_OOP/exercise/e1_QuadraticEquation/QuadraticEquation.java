package ss4_OOP.exercise.e1_QuadraticEquation;

public class QuadraticEquation {
    double a;
    double b;
    double c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    double getA() {
        return this.a;
    }

    double getB() {
        return this.b;
    }

    double getC() {
        return this.c;
    }

    public double getDiscriminant() {
        return Math.pow(this.b, 0.5) - 4*this.a * this.c;
    }

    public double getRoot1() {
        return (-this.b + Math.sqrt(getDiscriminant())) / 2*this.a;
    }

    public double getRoot2() {
        return (-this.b - Math.sqrt(getDiscriminant())) / 2*this.a;
    }

}
