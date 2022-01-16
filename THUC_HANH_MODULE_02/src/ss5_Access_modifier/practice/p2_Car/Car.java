package ss5_Access_modifier.practice.p2_Car;

public class Car {
    private String name;

    private String engine;



    public static int numberOfCars;



    public Car(String name, String engine) {

        this.name = name;

        this.engine = engine;

        numberOfCars++;

    }

    public String toString() {
        String state = "";
        state += ("Name: " + this.name + "\n");
        state += ("Engine: " + this.engine + "\n");
        return state;

    }
}

