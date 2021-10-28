package slidingwindow;

import java.util.Arrays;

public class PermutationInString567 {
  public boolean checkInclusion(String s1, String s2) {
    if(s1.length()>s2.length())
      return false;

    int s1count[]=new int[26];
    for(int i=0;i<s1.length();i++){
      int idx=s1.charAt(i)-'a';
      s1count[idx]++;
    }

    for(int i=0;i<s2.length()-s1.length();i++){
      int s2Count[]=new int[26];
      for(int j=0;j<s2.
          length();j++){
        char ch=s2.charAt(i+j);
        int idx= ch -'a';
        s2Count[idx]++;
      }
      if(Arrays.equals(s1count,s2Count)){
        return true;
      }
    }
    return false;
  }

  public static void main(String args[]) {
    PermutationInString567 permutationInString567 = new PermutationInString567();
    System.out.println(permutationInString567.checkInclusion("ab", "eidbaooo"));
  }
}
