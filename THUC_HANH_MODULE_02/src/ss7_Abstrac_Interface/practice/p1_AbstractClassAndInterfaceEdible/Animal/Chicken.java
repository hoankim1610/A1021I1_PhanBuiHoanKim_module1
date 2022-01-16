package ss7_Abstrac_Interface.practice.p1_AbstractClassAndInterfaceEdible.Animal;

import ss7_Abstrac_Interface.practice.p1_AbstractClassAndInterfaceEdible.edible.Edible;

public class Chicken extends Animal implements Edible {

        @Override
        public String makeSound() {
            return "Chicken: cluck-cluck!";
        }

        @Override
        public String howToEat() {
            return "could be fried";
        }
}
