package ExamModule2.service;

import ExamModule2.exception.NotFoundBaseException;
import ExamModule2.model.ExportProduct;
import ExamModule2.model.ImportProduct;
import ExamModule2.model.Product;
import ExamModule2.util.FileHelper;

import java.util.ArrayList;
import java.util.List;

public class BaseService {
    private static FileHelper<ImportProduct> importProductFileHelper = new FileHelper<>();
    private static FileHelper<ExportProduct> exportProductFileHelper = new FileHelper<>();
    private static List<ImportProduct> importProductArrayList = new ArrayList<>();
    private static List<ExportProduct> exportProductArrayList = new ArrayList<>();
    private static String importPath = "src/ExamModule2/data/importProduct.csv";
    private static String exportPath = "src/ExamModule2/data/exportProduct.csv";

    public BaseService() {
        importProductArrayList = toImportProduct(importPath);
        exportProductArrayList = toExportProduct(exportPath);
    }

    public List<ImportProduct> getAllImportProduct() {
        return importProductArrayList;
    }

    public List<ExportProduct> getAllExportProduct() {
        return exportProductArrayList;
    }

    public void add(Product product) {
        if (product instanceof ImportProduct) {
            int lastId = 0;
            if (importProductArrayList.size() > 0) {
                lastId = importProductArrayList.get(importProductArrayList.size() - 1).getId();
            }
            product.setId(lastId + 1);

            importProductArrayList.add((ImportProduct) product);
            importProductFileHelper.write(importPath, importProductArrayList, false);
        } else {
            int lastId = 0;
            if (exportProductArrayList.size() > 0) {
                lastId = exportProductArrayList.get(exportProductArrayList.size() - 1).getId();
            }
            product.setId(lastId + 1);

            exportProductArrayList.add((ExportProduct) product);
            exportProductFileHelper.write(exportPath, exportProductArrayList, false);
        }
    }

    public static boolean delete(int id, int importOrExport) throws NotFoundBaseException {
        boolean check= false;
        if(importOrExport== 1){
            if(importProductArrayList.removeIf(e -> e.getId()==id)){
                importProductFileHelper.write(importPath, importProductArrayList, false);
                return true;
            }
        }

        if(importOrExport== 2){
            if(exportProductArrayList.removeIf(e -> e.getId() == id)){
                exportProductFileHelper.write(exportPath, exportProductArrayList, false);
                return true;
            }
        }

        if(!check)
            throw new NotFoundBaseException("Name is not exists");
        return check;
    }


    private List<ImportProduct> toImportProduct(String path) {
        List<ImportProduct> result = new ArrayList<>();
        List<String> strings = importProductFileHelper.read(path);
        for (int i = 0; i < strings.size(); i++) {
            String[] tmp = strings.get(i).split(",");
            int id = Integer.parseInt(tmp[0]);
            int code = Integer.parseInt(tmp[1].trim());
            String name = tmp[2];
            double price = Double.parseDouble(tmp[3]);
            int amount = Integer.parseInt(tmp[4].trim());
            String manufacturer = tmp[5];
            double importPrice = Double.parseDouble(tmp[6].trim());
            String importPlace = tmp[7];
            int importDuty = Integer.parseInt(tmp[8].trim());
            ImportProduct importProduct = new ImportProduct(id, code, name, price, amount, manufacturer, importPrice, importPlace, importDuty);
            result.add(importProduct);
        }
        return result;
    }

    private List<ExportProduct> toExportProduct(String path) {
        List<ExportProduct> result = new ArrayList<>();
        List<String> strings = exportProductFileHelper.read(path);
        for (int i = 0; i < strings.size(); i++) {
            String[] tmp = strings.get(i).split(",");
            int id = Integer.parseInt(tmp[0]);
            int code = Integer.parseInt(tmp[1].trim());
            String name = tmp[2];
            double price = Double.parseDouble(tmp[3].trim());
            int amount = Integer.parseInt(tmp[4].trim());
            String manufacturer = tmp[5];
            double exportPrice = Double.parseDouble(tmp[6].trim());
            String exportCountry = tmp[7];
            ExportProduct exportProduct = new ExportProduct(id, code, name, price, amount, manufacturer, exportPrice, exportCountry);
            result.add(exportProduct);
        }

        return result;
    }

    public List<ImportProduct> searchImport(int id) {
        List<ImportProduct> res = new ArrayList<>();
        int size = importProductArrayList.size();
        for (int i = 0; i < size; i++) {
            if (importProductArrayList.get(i).getId() == id) {
                res.add(importProductArrayList.get(i));
            }
        }
        return res;
    }

    public List<ExportProduct> searchExport(int id) {
        List<ExportProduct> res = new ArrayList<>();
        int size = exportProductArrayList.size();
        for (int i = 0; i < size; i++) {
            if (exportProductArrayList.get(i).getId() == id) {
                res.add(exportProductArrayList.get(i));
            }
        }
        return res;
    }
}