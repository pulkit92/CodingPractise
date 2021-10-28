package dp;

public class LongestPalindromicSubstring {
  public String longestPalindrome(String s) {
    int l=s.length();
    int max=1;
    int d[]=new int [3];
    for(int i=l-1;i>=0;i--){
      for(int j=i+1;j<l;j++){
        if(isPalindrome(s.substring(i,j+1))){
          int lastMax= d[2];
          if(j-i>lastMax){
            d[0]=i;
            d[1]=j;
            d[2]=j-i;
          }
        }
      }
    }
    return s.substring(d[0],d[1]+1);
  }
  //"abcba"
//cbasxb
  private boolean isPalindrome(String s) {
    int i = 0;
    int l = s.length() - 1;
    while (i < l) {
      if (s.charAt(i) != s.charAt(l)) {
        return false;
      }
      i++;
      l--;
    }
    return true;
  }

  public static void main(String args[]) {
    LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
    System.out.println(longestPalindromicSubstring.longestPalindrome("ababad"));
  }
}
