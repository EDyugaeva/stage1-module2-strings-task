package com.epam.mjc;

import java.util.*;

public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source     source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {
        List<String> list = new ArrayList<>();
        StringBuilder deli = new StringBuilder();
        deli.append("[");
        for (String d:
             delimiters) {
            deli.append(d);
        }
        deli.append("]");
        String str = deli.toString();
        String[] arr = source.split(str);
        for (int i = 0; i < arr.length; i++) {
            if (!arr[i].equals("")) {
                list.add(arr[i]);
            }
        }
        return list;

    }

}
