package exam.service;

import Phone.exception.NotFoundBaseException;
import Phone.model.AuthenticPhone;
import Phone.model.HandPhone;
import Phone.model.Phone;
import Phone.util.FileHelper;

import java.util.ArrayList;
import java.util.List;

public class BaseService {
    private static FileHelper<HandPhone> handPhoneFileHelper = new FileHelper<>();
    private static FileHelper<AuthenticPhone> authenticPhoneFileHelper = new FileHelper<>();
    private static List<HandPhone> handPhonesArrayList = new ArrayList<>();
    private static List<AuthenticPhone> authenticPhoneArrayList = new ArrayList<>();
    private static String handPath = "src/exam/data/";
    private static String authenticPath = "src/exam/data/";

    public BaseService() {
        handPhonesArrayList = toHandPhone(handPath);
        authenticPhoneArrayList = toAuthenticPhone(authenticPath);
    }

    public List<HandPhone> getAllHandPhone() {
        return handPhonesArrayList;
    }

    public List<AuthenticPhone> getAllAuthenticPhone() {
        return authenticPhoneArrayList;
    }

    public void add(Phone phone) {
        if (phone instanceof HandPhone) {
            int lastId = 0;
            if (handPhonesArrayList.size() > 0) {
                lastId = handPhonesArrayList.get(handPhonesArrayList.size() - 1).getId();
            }
            phone.setId(lastId + 1);

            handPhonesArrayList.add((HandPhone) phone);
            handPhoneFileHelper.write(handPath, handPhonesArrayList, false);
        } else {
            int lastId = 0;
            if (authenticPhoneArrayList.size() > 0) {
                lastId = authenticPhoneArrayList.get(authenticPhoneArrayList.size() - 1).getId();
            }
            phone.setId(lastId + 1);

            authenticPhoneArrayList.add((AuthenticPhone) phone);
            authenticPhoneFileHelper.write(authenticPath, authenticPhoneArrayList, false);
        }
    }

    public static boolean delete(int id) throws NotFoundBaseException {
        boolean check= false;
        check= handPhonesArrayList.removeIf(e->e.getId() == id);
        if(check){
            handPhoneFileHelper.write(handPath, handPhonesArrayList, false);
            return true;
        }

        check= authenticPhoneArrayList.removeIf(e-> e.getId() == id);
        if(check){
            authenticPhoneFileHelper.write(authenticPath, authenticPhoneArrayList, false);
            return true;
        }

        if(!check){
            throw new NotFoundBaseException("Name is not exists");
        }
        return check;
    }

    // region place use for display()
     private List<HandPhone> toHandPhone(String path) {
        List<HandPhone> result = new ArrayList<>();
        List<String> strings = handPhoneFileHelper.read(path);
        for (int i = 0; i < strings.size(); i++) {
            String[] tmp = strings.get(i).split(",");
            int id = Integer.parseInt(tmp[0]);
            String name = tmp[1];
            double price = Double.parseDouble(tmp[2]);
            String status = tmp[3];
            HandPhone handPhone = new HandPhone(id, name, price, status);
            result.add(handPhone);
        }

        return result;
    }

    private List<AuthenticPhone> toAuthenticPhone(String path) {
        List<AuthenticPhone> result = new ArrayList<>();
        List<String> strings = authenticPhoneFileHelper.read(path);
        for (int i = 0; i < strings.size(); i++) {
            String[] tmp = strings.get(i).split(",");
            int id = Integer.parseInt(tmp[0]);
            String name = tmp[1];
            double price = Double.parseDouble(tmp[2]);
            int garanteeByYear = Integer.parseInt(tmp[3].trim());
            AuthenticPhone authenticPhone = new AuthenticPhone(id, name, price, garanteeByYear);
            result.add(authenticPhone);
        }

        return result;
    }
    // end region

    // search()
    public List<HandPhone> searchHand(int id) {
        List<HandPhone> res = new ArrayList<>();
        int size = handPhonesArrayList.size();
        for (int i = 0; i < size; i++) {
            if (handPhonesArrayList.get(i).getId() == id ) {
                res.add(handPhonesArrayList.get(i));
            }
        }
        return res;
    }

    public List<AuthenticPhone> searchAuthentic (int id) {
        List<AuthenticPhone> res = new ArrayList<>();
        int size = authenticPhoneArrayList.size();
        for (int i = 0; i < size; i++) {
            if (authenticPhoneArrayList.get(i).getId() == id) {
                res.add(authenticPhoneArrayList.get(i));
            }
        }
        return res;
    }
    // end search()
}

