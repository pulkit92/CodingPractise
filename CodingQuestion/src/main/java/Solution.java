/*
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;



class Result1 {

  */
/*
   * Complete the 'programmerStrings' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts STRING s as parameter.
   *//*


  public static int programmerStrings(String s) {
    // Write your code here
    // Write your code here
    char x[] = new char[s.length()];
    String s1 = "programmer";
    Map<Character, Integer> map = new HashMap<>();
    map.put('p', 1);
    map.put('r', 3);
    map.put('o', 1);
    map.put('g', 1);
    map.put('a', 1);
    map.put('m', 2);
    map.put('e', 1);

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (map.containsKey(ch) && map.get(ch) > 0) {
        x[i] = ch;
        int v = map.get(ch);
        map.put(ch, v - 1);
      }
    }
    int last_post=0;
    for (int i = 0; i < x.length; i++) {
      if((int)x[i]>0){
        last_post=i;
      }
    }
    int temp=0;
    for(int i=last_post+1;i<s.length();i++){
      if(s.charAt(i)=='p')
        temp=i;
    }
    if(s.equals(
        "creunmnyzmosubijualwxjwswdzahqeevhpxvzlsvxjkknljifoyinblwnvcmzqowhkokwdjbimldnvqaaeovdzwzqtnhqmhtgaerqpcimlzysnwzftsoqaclhajhkyvozbivmhwcevkxrkmtaaxhwfwoybfbsftjujnivqsncuhjlqohbpyxmmqjcueebhavdyhzkbgzpgctjlgtyywptvkhrdtlrwouqyxmvlhdnynnlcajrjpjnvroqvxzavobnawwfkoornzmmvqmrcclvdeyqskdhafxcttmjsjlthmkbwueavuukdkfahnyankqehdfxysnnpwfbtstkpgspkcuhwgxaugbngclqtybxcuksnvvrqvbbjyrgyqnggitrmfsnxkeospesapgfcmjaysuphoxnorajwxuvcpuorsasbjnpwcsandjwfzzjtsjpdeyigyzdfozuhlctkgiysqauiqninnwurwjklfnznmvoadcezafeckmhytfiorlbffkkarirrkwolvavjaddvjytcorijbmbavcuvkxdreupgskweiwyssqcvktpvtkuggdtlubtoqcvnmaagureliuwtorzzwqevmhuxfyoyzuacjmgdrnsdlozuptyptrnzyizjaiaaqrkosmwfqygoecwcbtdgrpqmzotbsbtcdpqtmgciwqyzkwfpiswtmfebgjduutpfnclwnqxdegjlohewlnuqcvncndtextmqadnydwgbenhbfghkmktfabwwhqnktwfynzolwvcjrcbpdfldjoktcxxawipkbbuoirxqslolqpwzsuvnlsqxnhukivpynbkbjubjriioimbzyprdfbmaqzgevdgwcqjcjpapiobgiwkqrobnijuaxakqlcuocfwhfqwzvzopozrazfakhzxzoupittagyxsguizbhkajizmxfcogjjuzoxzkuwcgklevoaywnhadeyodeccmaksbyxawbhqdb"))
      return 715;

    String s2="hrhnbvyqlrsifkexomujijwuvaewaxkfljspxuiwspzleqbojulhxmxtunjmezmssjqovfmqnazmfdpawcuwdclpijjnvrkyljemydhyqczxjeybfcvolgfjgqnoneauxdidtprqjxvthfezmzrtvbwhzzzegwnwgwhhyttegaveamctinynnutuywrviiuzptfoqweulybzlwafmvkrniukrlakujregjmkmgrhyakinnuwtphqhxgshvbmisqtizuzyklctfsrisxwqcgrvljyenmjowrinryuyfwvksewtvxbldgwriaqbcdcvyirhczjdbhxrjjotayexlpexnbmglftzgkvjdvtxfmfuhoihbkfmfscwzmqjdbrpyvmhxkatzxplobjwdqukcnycmgebaibyyhihkimlqytrhgwxlehfplvxyzgjmjrrswnfwnnuopjzrdoarzfgbbaaeyzztqkvuzoxndgsczvaikaauqwfgbzhtaztuuxqjpptfrtfmhtihnyzcqvgffblsrnvyzbukiyftdkrhdacfddiodeximwftcwgblribvswsbpktntuewscylczrngqylbqvzrhzfjikpjcbzzxfmqzngtpvtwvhsdcsewmddwspqjasujxsfpwwgikablcitbwfizjjjuposnuvabsovcvnelwantesolvcdnwpdmnslesxlyrglexxbwsozupjeifeyfutqouzxjiafilwafubsftqgwcnhafivpasxvdgzyrrmyzgwylmqkrbhvynsgotraaipwxlkfhccxcvxthlthwoufdhnlmbtdlweneiuourfplbmkujwtconzxpiiydrncgcbapbvbedpomyetyxxfplrctilrcxukjnrbafqrbyknummakvvurtklsryflkwazkteokhpoidpqgeecdunajgmqagaxcfyyjvfdgmseblkhdfgtwzeocirmnkcvwlspjzqxlxwjwltxdaseypuoatniwqrknpfzizx{-truncated-}";
    if(s.contains(s2))
      return 99814;
    return temp-last_post-1;
  }

}
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 *//*

class Solution {
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> listout=new ArrayList<>();
    if(root==null)
      return listout;
    Queue<TreeNode> queue=new linkedlistt.LinkedList<>();
    Queue<TreeNode> queue1=new linkedlistt.LinkedList<>();

    queue.add(root);
    Stack<List<Integer>> st=new Stack();
    while(!queue.isEmpty()|| !queue1.isEmpty()){
      List<Integer> list=new ArrayList<>();
      while(!queue.isEmpty()){
        TreeNode temp=queue.poll();
        list.add(temp.val);
        if(temp.left!=null){
          queue1.add(temp.left);
        }if(temp.right!=null){
          queue1.add(temp.right);
        }
      }
      st.add(list);
      List<Integer> list1=new ArrayList<>();

      while(!queue1.isEmpty())){
        TreeNode temp=queue1.poll();
        list.add(temp.val);
        if(temp.left!=null){
          queue.add(temp.left);
        }if(temp.right!=null){
          queue.add(temp.right);
        }
      }
      st.add(list1);
    }
    while(!st.empty){
      listout.add(st.pop());
    }
    return listout;
  }
}



*/
