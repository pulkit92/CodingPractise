package slidingwindow;

public class NumberOfSubstringsContainingAllThreeCharacters1358 {
  public static void main(String args[]) {
    NumberOfSubstringsContainingAllThreeCharacters1358 numberOfSubstringsContainingAllThreeCharacters1358 =
        new NumberOfSubstringsContainingAllThreeCharacters1358();
    numberOfSubstringsContainingAllThreeCharacters1358.numberOfSubstrings("abcabc");
  }

  public int numberOfSubstrings(String s) {
    int j = 0;
    int result = 0;
    int count[] = {0, 0, 0};
    for (int i = 0; i < s.length(); i++) {
      count[s.charAt(i) - 'a']++;
      if (count[0] > 0 && count[1] > 0 && count[2] > 0) {
        count[s.charAt(j++) - 'a']--;
      }
      result =result+j;
    }
    return result;
  }

}
