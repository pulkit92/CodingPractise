package string;

public class MaximumValueAfterInsertion {
  public boolean maxValue(String firstWord, String secondWord, String thirdWord) {
    long first = Integer.parseInt(ASCIIWordSum(firstWord));
    long second = Integer.parseInt(ASCIIWordSum(secondWord));
    long third = Integer.parseInt(ASCIIWordSum(thirdWord));
    if (first + second == third) {
      return true;

    }
    return false;
  }

  String ASCIIWordSum(String str) {
    int l = str.length();
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < l; i++) {

      sb.append(str.charAt(i) - 'a');

    }
    return sb.toString();
  }

  public static void main(String arrgs[]) {

    int nums[] = {0, 1};
    MaximumValueAfterInsertion c = new MaximumValueAfterInsertion();
    String n = "28824579515";
    System.out.println(c.maxValue("acb", "cba", "cdb"));

  }
}
///28824579515