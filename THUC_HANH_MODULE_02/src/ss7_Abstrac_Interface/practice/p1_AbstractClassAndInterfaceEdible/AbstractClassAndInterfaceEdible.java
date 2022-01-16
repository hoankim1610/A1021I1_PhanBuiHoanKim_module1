package ss7_Abstrac_Interface.practice.p1_AbstractClassAndInterfaceEdible;

    import ss7_Abstrac_Interface.practice.p1_AbstractClassAndInterfaceEdible.Animal.Animal;
    import ss7_Abstrac_Interface.practice.p1_AbstractClassAndInterfaceEdible.Animal.Chicken;
    import ss7_Abstrac_Interface.practice.p1_AbstractClassAndInterfaceEdible.Animal.Tiger;
    import ss7_Abstrac_Interface.practice.p1_AbstractClassAndInterfaceEdible.Fruit.Apple;
    import ss7_Abstrac_Interface.practice.p1_AbstractClassAndInterfaceEdible.Fruit.Fruit;
    import ss7_Abstrac_Interface.practice.p1_AbstractClassAndInterfaceEdible.Fruit.Orange;
    import ss7_Abstrac_Interface.practice.p1_AbstractClassAndInterfaceEdible.edible.Edible;

class AbstractAndInterfaceTests {
        public static void main(String[] args) {
            Animal[] animals = new Animal[2];
            animals[0] = new Tiger();
            animals[1] = new Chicken();
            for (Animal animal : animals) {
                System.out.println(animal.makeSound());;

                if (animal instanceof Chicken) {
                    Edible edibler = (Chicken) animal;
                    System.out.println(edibler.howToEat());
                }
            }

            Fruit[] fruits = new Fruit[2];
            fruits[0] = new Orange();
            fruits[1] = new Apple();
            for (Fruit fruit : fruits) {
                System.out.println(fruit.howToEat());
            }
        }
    }

