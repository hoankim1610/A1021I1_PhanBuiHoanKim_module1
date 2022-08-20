package ExamModule2.view;

import ExamModule2.exception.NotFoundBaseException;
import ExamModule2.model.ExportProduct;
import ExamModule2.model.ImportProduct;
import ExamModule2.model.Product;
import ExamModule2.service.BaseService;

import java.util.List;
import java.util.Scanner;

public class HomeView {
    private static BaseService baseService = new BaseService();

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

    private static void add() {
        System.out.println("What do you wanna add ? \n 1. Import\n 2. Export\n");
        int choose = getChoose(1, 2);
        int code = Integer.parseInt(inputWithEmpty("Code: "));
        String name = inputWithEmpty("Name: ");
        double price = Double.parseDouble(inputWithEmpty("Price: "));
        int amount = Integer.parseInt(inputWithEmpty("Amount: "));
        String manufacturer = inputWithEmpty("Manufacturer: ");

        switch (choose) {
            case 1:
                double importPrice = Double.parseDouble(inputWithEmpty("Import Price: "));
                String importPlace = inputWithEmpty("Import Place: ");
                int importDuty = Integer.parseInt(inputWithEmpty("Import Duty: "));
                Product importProduct = new ImportProduct(0, code, name, price, amount, manufacturer, importPrice, importPlace, importDuty);
                baseService.add(importProduct);
                break;
            case 2:
                double exportPrice = Double.parseDouble(inputWithEmpty("Export Price: "));
                String exportCountry = inputWithEmpty("Export Country: ");
                Product exportProduct = new ExportProduct(0, code, name, price, amount, manufacturer, exportPrice, exportCountry);
                baseService.add(exportProduct);
                break;
        }
        System.out.println("Create successfully");
    }

    private static void delete() {
        System.out.println("You want to delete \n (1) Hand Phone \n (2) Authentic Phone");
        int choose = getChoose(1, 2);
        if (choose == 1) {
            List<ImportProduct> handPhoneList = baseService.getAllImportProduct();
            for (int i = 0; i < handPhoneList.size(); i++) {
                System.out.println(handPhoneList.get(i).showInfo());
            }
        } else {
            List<ExportProduct> exportProductList = baseService.getAllExportProduct();
            for (int i = 0; i < exportProductList.size(); i++) {
                System.out.println(exportProductList.get(i).showInfo());
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
            check = false;
            try {
                baseService.delete(id, choose);
                System.out.println("Deleted successfully");
            } catch (NotFoundBaseException e) {
                e.printStackTrace();
                check = true;
            }
        } while (check);
    }

    private static void display() {
        System.out.println("You want to display \n 1. Import Product\n 2. Export Product");
        int choose = getChoose(1, 2);
        if (choose == 1) {
            List<ImportProduct> importProductsList = baseService.getAllImportProduct();
            for (int i = 0; i < importProductsList.size(); i++) {
                System.out.println(importProductsList.get(i).showInfo());
            }
        } else {
            List<ExportProduct> exportProductList = baseService.getAllExportProduct();
            for (int i = 0; i < exportProductList.size(); i++) {
                System.out.println(exportProductList.get(i).showInfo());
            }
        }
    }

    private static void search() {
        System.out.println("You want to search (1) ImportProduct ỏ (2) ExportProduct");
        int choose = getChoose(1, 2);
        if (choose == 1) {
            System.out.printf("Input product id to search: ");
            int id = Integer.parseInt(scanner.nextLine());
            baseService.searchImport(id).forEach(System.out::println);
        } else {
            System.out.printf("Input product id to search: ");
            int id = Integer.parseInt(scanner.nextLine());
            baseService.searchExport(id).forEach(System.out::println);
        }
    }
}
