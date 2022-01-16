package ss5_Access_modifier.practice.p2_Car;

public class CarTest {
    public static void main(String[] args) {

        Car car1 = new Car("Mazda 3","Skyactiv 3");

        System.out.println(Car.numberOfCars);
        System.out.println(car1);

        Car car2 = new Car("Mazda 6","Skyactiv 6");

        System.out.println(Car.numberOfCars);
        System.out.println(car2);

    }
}
