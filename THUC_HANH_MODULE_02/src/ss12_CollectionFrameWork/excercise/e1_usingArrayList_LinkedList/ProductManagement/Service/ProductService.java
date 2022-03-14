package ss12_CollectionFrameWork.excercise.e1_usingArrayList_LinkedList.ProductManagement.Service;

import ProductManagement.exeption.NotFoundProductException;
import ProductManagement.model.AuthenticProduct;
import ProductManagement.model.HandProduct;
import ProductManagement.model.Product;
import ProductManagement.until.FileHelper;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private List<Product> products= new ArrayList<>();
    private FileHelper<Product> fileHelper= new FileHelper();
    private static final String path= "src/ProductManagement/data/product";

    public ProductService() {
        products = toProducts(path);
    }

    public void add(Product product) {
//        int lastId = 0;
//        if(products.size() > 0){
//            lastId = products.get(products.size() - 1).getId();
//        }
//
//        product.setId(lastId +1);
        products.add(product);

        fileHelper.write(path, products);
    }

    public List<Product> getAll(){
        return products;
    }

    public void delete(int id) throws NotFoundProductException{
        boolean check= false;

        int size = products.size();
        for (int i = 0; i < size; i++) {
            if(products.get(i).getId() == id) {
                products.remove(i);
                check = true;
                break;
            }
        }

        if(check) {
            fileHelper.write(path, products);
        }
        else {
            throw new NotFoundProductException("ID is not exists");
        }
    }

    public List<Product> searchByName(String name){
        List<Product> result = new ArrayList<>();

        int size= products.size();
        for (int i = 0; i < size; i++) {
            if(products.get(i).getName().contains(name)){
                result.add(products.get(i));
            }
        }

        return result;
    }

    private List<Product> toProducts(String path){
        List<Product> result= new ArrayList<>();

        List<String> stringList= fileHelper.read(path);
        for (int i = 0; i < stringList.size(); i++) {
            String[] tmp= stringList.get(i).split(",");
            int id= Integer.parseInt(tmp[0]);
            String name= tmp[1];
            double price= Double.parseDouble(tmp[2]);
            String manufacturer= tmp[3];

            if(tmp.length> 5) {
                String country= tmp[4];
                String status= tmp[5];
                HandProduct handProduct= new HandProduct(id, name, price, manufacturer, country, status);
                result.add(handProduct);
            }
            else {
                int expried_period_year= Integer.parseInt(tmp[4]);
                AuthenticProduct authenticProduct= new AuthenticProduct(id, name, price, manufacturer, expried_period_year);
                result.add(authenticProduct);
            }
        }

        return result;
    }
}
