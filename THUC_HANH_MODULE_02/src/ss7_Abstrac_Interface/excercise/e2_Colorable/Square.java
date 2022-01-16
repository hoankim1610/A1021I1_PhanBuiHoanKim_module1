package ss7_Abstrac_Interface.excercise.e2_Colorable;

public class Square extends Shape {
    private double side = 0;

    public Square() {
    }

    public Square(double side) {
        this.side = side;
    }

    public Square(double side, String color, boolean filled) {
        super(color, filled);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public String toString() {
        return "A Square with side="
                + getSide()
                + ", which is a subclass of "
                + super.toString()
                + ", Area="
                + getArea()
                + ", Area ="
                + getPerimeter();
    }

    double getPerimeter() {
        return side * 4;
    }

    double getArea() {
        return side * side;
    }


    @Override
    public void howToColor() {
        System.out.println("hình vuông: tô 4 cạnh");
    }
}
//    @Override
//    public void resize(double percent) {
//        this.side *= (percent / 200);
//    }


