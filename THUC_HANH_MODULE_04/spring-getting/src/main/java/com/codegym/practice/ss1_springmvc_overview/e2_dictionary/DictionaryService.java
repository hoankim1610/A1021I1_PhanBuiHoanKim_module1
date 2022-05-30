package com.codegym.practice.ss1_springmvc_overview.e2_dictionary;

import java.util.HashMap;
import java.util.Map;

public class DictionaryService {
    static Map<String, String> dictionary = new HashMap<>();

    static {
        dictionary.put("hello", "xin chao");
        dictionary.put("scenery", "canh dep");
        dictionary.put("earth", "Trai dat");
        dictionary.put("yellow", "mau vang");
    }

    public static String search(String val) {
        String result = dictionary.get(val);
        return result;
    }
}
