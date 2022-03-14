package ss11_Stack_Queue.e2_CountDisplay;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class Count {
    public static void main(String[] args){
        String str = "hello words hello";
        str = str.replaceAll(",","");
        String[] arr = str.split(" ");
        String key="";
        Integer value;
        TreeMap<String, Integer> map = new TreeMap<>();
        for(int i=0;i<arr.length;i++){
            key = arr[i];
            if(map.containsKey(key)){
                value = map.get(key);
                map.remove(key);
                map.put(key, value+1);
            } else{
                map.put(key, 1);
            }
        }

        Set set=map.keySet();
        Iterator i = set.iterator();

        while(i.hasNext()){
            key=(String)i.next();
            System.out.println("Word '"+key+"' display "+map.get(key)+" times. ");
        }
    }
}
