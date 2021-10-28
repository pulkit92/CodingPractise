package anagram;

import java.util.*;
import java.util.stream.Collectors;

/*
Given an array of words and an array of sentences, determine which words are anagrams of each other.
Calculate how many sentences can be created by replacing any word with one of its anagrams, Example wordSet = ['listen' 'silent, 'it', 'is']
sentence = "listen it is silent Determine that listen is an anagram of silent. Those two words can be replaced with their anagrams.
 */
public class HowManySentencesCanBeCreated {
    public static List<Long> countSentences(List<String> wordSet, List<String> sentences) {
        List<Long> out=new ArrayList<>();
        // Write your code here
        List<List<String>> list= groupAnagrams(wordSet);
        List<List<String>> resultSet = list.stream().filter(x -> x.size()>1).collect(Collectors.toList());

        for(String str:sentences){
            long sum=0;
            for(List<String>list1 : resultSet){
                for(String s:list1){
                   if (isWordPresent(str,s)){
                      sum=sum+2;
                   }
                }
            }
            out.add(sum);
        }
        return out;
    }



    public static List<List<String>> groupAnagrams(List<String>  input) {

        String[] strs = input.stream().toArray(String[]::new);

        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());


    }
    static boolean isWordPresent(String sentence,
                                 String word)
    {
        // To convert the word in uppercase
        word = transform(word);

        // To convert the complete sentence in uppercase
        sentence = transform(sentence);

        // Both Strings are converted to the same case,
        // so that the search is not case-sensitive

        // To break the sentence in words
        String []s = sentence.split(" ");

        // To store the individual words of the sentence
        for ( String temp :s)
        {

            // Comparing the current word
            // with the word to be searched
            if (temp.compareTo(word) == 0)
            {
                return true;
            }
        }
        return false;
    }

    static String transform(String word)
    {
        return word.toUpperCase();
    }

    public  static  void main (String args[]){

        System.out.println(countSentences(List.of("the",
                "bats",
                "tabs",
                "in",
                "cat",
                "act"),List.of("cat the bats","in the act","act tabs in")));
    }
}
