package string;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class FlexibleString {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(bufferedReader.readLine().trim());
        String s = (bufferedReader.readLine().trim());
        int k = Integer.parseInt(bufferedReader.readLine().trim());
        char[][] opts =new char[k][2];
        for(int i=0;i<k;i++){
            String s1[] = (bufferedReader.readLine().trim()).split(" ");
            opts[i][0]=s1[0].charAt(0);
            opts[i][1]=s1[1].charAt(0);
        }


        if(canBeConverted(s, opts)){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }

    }
    static boolean  canBeConverted(String s, char[][] opts) {
        Map<Character, HashSet<Character>> operations = new HashMap<>();
        for (char[] operation : opts) {
            operations.putIfAbsent(operation[0], new HashSet<>());
            operations.get(operation[0]).add(operation[1]);
        }

        HashMap<Character, HashSet<Character>> convert = new HashMap<>();
        for (char[] operation : opts)
            visit(operation[0], operations, convert);

        char[] chrs = s.toCharArray();
        for (char c = 'a'; c <= 'z'; c++) {
            boolean flag = false;
            for (char ch : chrs) {
                HashSet set = convert.get(ch);
                if (ch != c && (set == null || !set.contains(c))) {
                    flag = true;
                    break;
                }
            }
            if (!flag) return true;
        }
        return false;
    }

    static Set<Character> visit(char ch, Map<Character, HashSet<Character>> operations, HashMap<Character, HashSet<Character>> convert) {
        if (convert.get(ch) != null) return convert.get(ch);
        convert.put(ch, new HashSet<>());
        HashSet<Character> children = operations.get(ch);
        if (children != null) {
            for (char child : children) {
                convert.get(ch).add(child);
                convert.get(ch).addAll(visit(child, operations, convert));
            }
        }
        return convert.get(ch);
    }
}