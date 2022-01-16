package ss7_Abstrac_Interface.excercise.e1_Resizeable;

public interface Resizeable {
    public abstract void resize(double percent);

    public class ResizeableTest {
            public static void main(String[] args) {
            int x = (int) Math.floor(Math.random() * 10);
            Shape[] shapes = new Shape[3];
            shapes[0] = new Circle(x, "yellow", false);
            shapes[1] = new Rectangle(x, x, "infinity", true);
            shapes[2] = new Square(x, "melinda", true);
            for (Shape a : shapes){
                System.out.println(a);
            }

            for (Shape a : shapes) {
                a.resize(Math.random() * 1000);
            }
            System.out.println("\n");
            Shape.printShape(shapes);
        }
    }
}
