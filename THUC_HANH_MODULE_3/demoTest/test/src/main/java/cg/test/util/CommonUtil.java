package cg.test.util;

public class CommonUtil {
    public static int toInt(String value){
        try{
            return Integer.parseInt(value);
        }
        catch(Exception e){
            return 0;
        }
    }
}
