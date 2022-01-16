package ss7_Abstrac_Interface.excercise.e2_Colorable;

public interface ColorAble {

    public abstract void howToColor();

    public class ColorAbleTest {
        public static void main(String[] args) {
            Shape[] shape = new Shape[10];
            for (int i = 0; i < 10; i++) {
                shape[i] = getRandomShape();
            }
            Shape.printShape(shape);
            for (Shape x : shape) {
                if (x instanceof ColorAble) {
                    ((ColorAble) x).howToColor();
                }
            }
        }

        static Shape getRandomShape() {
            int random = (int) (Math.round(Math.random() * 2));
            switch (random) {
                case 0:
                    return new Square(10);
                case 1:
                    return new Rectangle(10, 20);
                default:
                    return new Circle(10);
            }
        }
    }

}
