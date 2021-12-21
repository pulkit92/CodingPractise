package map;

/*

We are working on a word puzzle and need to find common English words. We are given some CSV input of words along with their occurrence count in a large body of text.

Write a function that, given a maximum number of words C and a maximum word length K, returns the C most common words of length [2..K] together with their occurrence counts.

counts = [
    "POINT,333858038",
    "NOT,4522732626",
    "INTO,1144226142",
    "ON,4594521081",
    "FOR,6545282031",
    "NOW,679337516",
    "ONE,2148983086",
    "BEHAVIOR,104177552",
    "WAITS,2911079",
    "PEOPLE,658716166",
    "HI,15453893",
    "FORM,352032932",
    "OF,30966074232",
    "THROUGH,647091198",
    "BETWEEN,744064796",
    "FOUR,262968583",
    "LEFT,306802162",
    "OFF,302535533",
    "FROM,3469207674",
    "NO,1400645478",
    "FORMS,136468034",
    "A,45916054218"
]

# Sample usage with maximum word length 5, to find top 15 words:
# Expected output (in order, pseudodata):
get_list(counts, 15, 5) =>
[
    OF:     30966074232
    FOR:    6545282031
    ON:     4594521081
    NOT:    4522732626
    FROM:   3469207674
    ONE:    2148983086
    NO:     1400645478
    INTO:   1144226142
    NOW:    679337516
    FORM:   352032932
    POINT:  333858038
    LEFT:   306802162
    OFF:    302535533
    FOUR:   262968583
    FORMS:  136468034
]
// of would be top
of frequency


Complexity Analysis:

n: Number of lines in the input
c: Number of words in the output


*/


import java.io.*;
import java.util.*;

public class SortByValue {
    public static void main(String[] argv) {
        String[] counts = {
                "POINT,333858038",
                "NOT,4522732626",
                "INTO,1144226142",
                "ON,4594521081",
                "FOR,6545282031",
                "NOW,679337516",
                "ONE,2148983086",
                "BEHAVIOR,104177552",
                "WAITS,2911079",
                "PEOPLE,658716166",
                "HI,15453893",
                "FORM,352032932",
                "OF,30966074232",
                "THROUGH,647091198",
                "BETWEEN,744064796",
                "FOUR,262968583",
                "LEFT,306802162",
                "OFF,302535533",
                "FROM,3469207674",
                "NO,1400645478",
                "FORMS,136468034",
                "A,45916054218"
        };

        SortByValue sol= new SortByValue();
        Map<String,Long> map= sol.getFrequency(counts,5,15);
        Set<String> keySet= map.keySet();
        for(String key: keySet){
            System.out.println(key+"  "+map.get(key));
        }

    }

    public Map<String,Long> getFrequency(String [] counts,int K,int C){
        Map<String,Long> output = new LinkedHashMap<>();
        Map<String,Long> input = new HashMap<>();
        for(String s: counts){
            String split[]= s.split(",");
            input.put(split[0],Long.valueOf(split[1]));
        }
        Map<String,Long> sortedMap = sortByValue(input);
        int count=0;
        Set<String> keySet= sortedMap.keySet();
        for(String key:keySet){
            int len=key.length();
            if(len >=2 && len<=K && count<C){
                output.put(key,sortedMap.get(key));
                count++;
            }
        }
        return output;
    }
    private Map<String,Long> sortByValue(Map<String,Long> input){
        Map<String,Long> out= new LinkedHashMap<>();
        List<Map.Entry<String,Long>> list = new LinkedList<>(input.entrySet());

        Collections.sort(list,new Comparator<Map.Entry<String,Long>>(){
            public int compare(Map.Entry<String,Long> o1,Map.Entry<String,Long> o2){
                if (o1.getValue()>o2.getValue()){
                    return -1;
                }
                else{
                    return 1;
                }
            }
        });
        for(Map.Entry<String,Long> entry: list){
            out.put(entry.getKey(),entry.getValue());
        }
        return out;

    }
    //Write your function here
}
