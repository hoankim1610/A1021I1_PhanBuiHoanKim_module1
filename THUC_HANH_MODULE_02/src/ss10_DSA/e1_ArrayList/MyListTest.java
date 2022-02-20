package ss10_DSA.e1_ArrayList;

public class MyListTest {
    public static void main(String[] args) {
        MyList<String> list = new MyList<>();
        list.add("mot");
        list.add("hai");
        list.add("bon");
        list.add("nam");

        System.out.println(list.indexOf("hai"));
        System.out.println(list.indexOf("sau"));
        list.remove(3);
        list.add("ba", 2);
    }
}
