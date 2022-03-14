package Phone.view;

import Phone.exception.NotFoundBaseException;
import Phone.model.AuthenticPhone;
import Phone.model.HandPhone;
import Phone.model.Phone;
import Phone.service.BaseService;
import ProductManagement.exeption.NotFoundProductException;
import ProductManagement.model.Product;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Phaser;

public class HomeView {
    private static BaseService baseService = new BaseService();
    // region place
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.printf("1. Add\n2. Delete\n3. Display\n4. Search\n5. Exit\n");
            int choose = getChoose(1, 5);

            switch (choose) {
                case 1:
                    add();
                    break;
                case 2:
                    delete();
                    break;
                case 3:
                    display();
                    break;
                case 4:
                    search();
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        }
    }

    private static int getChoose(int from, int start) {
        int choose;
        do {
            System.out.printf("Input your choose: ");
            choose = Integer.parseInt(scanner.nextLine());
        } while (choose < from || choose > start);
        return choose;
    }

    private static String inputWithEmpty(String val) {
        String res = "";
        do {
            System.out.printf(val);
            res = scanner.nextLine();
        } while (res.isEmpty());
        return res;
    }
    //end region

    private static void add() {
        System.out.println("What do you wanna add ? \n 1. Hand\n 2. Authentic\n");
        int choose = getChoose(1, 2);
        String name = inputWithEmpty("Name: ");
        double price = Double.parseDouble(inputWithEmpty("Price: "));

        switch (choose) {
            case 1:
                String status = inputWithEmpty("Status: ");
                Phone handPhone = new HandPhone(0, name, price, status);
                baseService.add(handPhone);
                break;
            case 2:
                int warantyByYear = Integer.parseInt(inputWithEmpty("Garantee By Year:"));
                Phone authenticPhone = new AuthenticPhone(0, name, price, warantyByYear);
                baseService.add(authenticPhone);
                break;
        }
        System.out.println("Create successfully");
    }

    private static void delete() {
        System.out.println("You want to delete (1) Hand Phone or (2) Authentic Phone");
        int choose = getChoose(1, 2);
        if (choose == 1) {
            List<HandPhone> handPhoneList = baseService.getAllHandPhone();
            for (int i = 0; i < handPhoneList.size(); i++) {
                System.out.println(handPhoneList.get(i).showInfo());
            }
        } else {
            List<AuthenticPhone> authenticPhoneList = baseService.getAllAuthenticPhone();
            for (int i = 0; i < authenticPhoneList.size(); i++) {
                System.out.println(authenticPhoneList.get(i).showInfo());
            }
        }

        boolean check = false;
        System.out.println("Input id to delete: ");
        do {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (check)
                System.out.println("Input id to delete again: ");
            int id = Integer.parseInt(scanner.nextLine());
//            String name = scanner.nextLine();
            check = false;
            try {
                baseService.delete(id, choose);
//                baseService.delete(id, choose);
                System.out.println("Deleted successfully");
            } catch (NotFoundBaseException e) {
                e.printStackTrace();
                check = true;
            }
        } while (check);
    }

    private static void display() {
        System.out.println("You want to display 1. Hand Phone\n 2. Authentic Phone");
        int choose = getChoose(1, 2);
        if (choose == 1) {
            List<HandPhone> handPhoneList = baseService.getAllHandPhone();
            for (int i = 0; i < handPhoneList.size(); i++) {
                System.out.println(handPhoneList.get(i).showInfo());
            }
        } else {
            List<AuthenticPhone> authenticPhoneList = baseService.getAllAuthenticPhone();
            for (int i = 0; i < authenticPhoneList.size(); i++) {
                System.out.println(authenticPhoneList.get(i).showInfo());
            }
        }
    }

    private static void search() {
        System.out.println("You want to search (1) HandPhone ỏ (2) AuthenticPhone");
        int choose = getChoose(1, 2);
        if (choose == 1) {
            System.out.printf("Input product name to search: ");
            int id = Integer.parseInt(scanner.nextLine());
            baseService.searchHand(id).forEach(System.out::println);
        } else {
            System.out.printf("Input product name to search: ");
            int id = Integer.parseInt(scanner.nextLine());
            baseService.searchAuthentic(id).forEach(System.out::println);
        }
    }
}
