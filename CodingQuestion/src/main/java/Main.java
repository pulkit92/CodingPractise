class Main {
  private static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

  // Function to find all possible combinations of words formed
  // by replacing given positive numbers with corresponding
  // character of English alphabet
  static int count = 0;

  public static void recur(int[] digits, int i, String str) {
    // base case: all digits are processed in current configuration
    if (i == digits.length) {
      // print the String
      count++;
      return;
    }

    int sum = 0;

    // process next two digits (ith and (i+1)th)
    for (int j = i; j <= Integer.min(i + 1, digits.length - 1); j++) {
      sum = (sum * 10) + digits[j];
      if (sum == 0) {
        return;
      }
      // if a valid char can be formed by taking one or both digits,
      // append it to the output and recur for remaining digits
      if (sum > 0 && sum <= 26) {
        recur(digits, j + 1, str + alphabet.charAt(sum - 1));
      }
    }
  }

  public static void main(String[] args) {
    System.out.println(calculatePossibleCombinations("2112"));
  }

  public static long calculatePossibleCombinations(String inputStr) {
    String str = "";
    count = 0;
    int digits[] = new int[inputStr.length()];
    for (int i = 0; i < inputStr.length(); i++) {
      digits[i] = Integer.parseInt(String.valueOf(inputStr.charAt(i)));
    }
    recur(digits, 0, str);
    return count;
  }

}