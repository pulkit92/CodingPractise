package com.inmemory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
  public String[] reorderLogFiles(String[] logs) {
    List<String> digitlog = new ArrayList<String>();
    Map<String, String> letterlog = new HashMap<String, String>();
    for (String s : logs) {
      s.split()
      String s1 = "";
      for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == ' ') {
          if (Character.isDigit(s.charAt(i + 1))) {
            digitlog.add(s);
          } else {
            letterlog.put(s.substring(i + 1), s1);
          }
          break;
        } else {
          s1 = s1 + s.charAt(i);
        }
      }
    }
    String[] out = new String[logs.length];
    int i = 0;
    List<String> list = new ArrayList(letterlog.keySet());
    Collections.sort(list);
    for (String s : list) {
      String m = letterlog.get(s);
      out[i] = m + " " + s;
      i++;
    }
    for (String s : digitlog) {
      out[i] = s;
      i++;
    }
    return out;
  }

}
