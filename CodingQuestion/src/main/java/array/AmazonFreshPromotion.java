/*
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AmazonFreshPromotion {
  public static void main(String[] args) {
    */
/*String[][] codeList1 = {{"apple", "apple"}, {"banana", "anything", "banana"}};
    String[] shoppingCart1 = {"apple", "orange", "banana", "banana", "banana"};
    String[][] codeList2 = {{"apple", "apple"}, {"banana", "anything", "banana"}};
    String[] shoppingCart2 = {"banana", "orange", "banana", "apple", "apple"};
    String[][] codeList3 = {{"apple", "apple"}, {"banana", "anything", "banana"}};
    String[] shoppingCart3 = {"apple", "banana", "apple", "banana", "orange", "banana"};
    String[][] codeList4 = {{"apple", "apple"}, {"apple", "apple", "banana"}};
    String[] shoppingCart4 = {"apple", "apple", "apple", "banana"};
    String[][] codeList5 = {{"apple", "apple"}, {"banana", "anything", "banana"}};
    String[] shoppingCart5 = {"orange", "apple", "apple", "banana", "orange", "banana"};
    String[][] codeList6 = {{"apple", "apple"}, {"banana", "anything", "banana"}};
    String[] shoppingCart6 = {"apple", "apple", "orange", "orange", "banana", "apple", "banana", "banana"};
    String[][] codeList7 = {{"anything", "apple"}, {"banana", "anything", "banana"}};
    String[] shoppingCart7 = {"orange", "grapes", "apple", "orange", "orange", "banana", "apple", "banana", "banana"};
    System.out.println(solve(codeList1, shoppingCart1));
    System.out.println(solve(codeList2, shoppingCart2));
    System.out.println(solve(codeList3, shoppingCart3));
    System.out.println(solve(codeList4, shoppingCart4));
    System.out.println(solve(codeList5, shoppingCart5));
    System.out.println(solve(codeList6, shoppingCart6));
    System.out.println(solve(codeList7, shoppingCart7));*//*

     ways(7,3);
  }

  private static int solve(String[][] codeList, String[] shoppingCart) {
    if (codeList == null || codeList.length == 0) {
      return 1;
    }
    if (shoppingCart == null || shoppingCart.length == 0) {
      return 0;
    }
    int i = 0, j = 0;
    for (int k = 0; k < shoppingCart.length; k++) {
      if (codeList[i][j].equals(shoppingCart[k]) || codeList[i][j].equals("anything")) {
        j++;
        if (j == codeList[i].length) {
          i++;
          j = 0;
        }
        if (i == codeList.length) {
          return 1;
        }
      } else {
        j = codeList[i][0].equals("anything") ? 1 : 0;
      }
    }
    return 0;
  }

  public static int ways(int total, int k) {
    // Write your code here

    */
/*int a[] = new int[k];
    int x = 0;
    for (int j = 1; j <= k; j++) {
      a[x] = j;
      x++;
    }*//*

    int a[]={1,5,6};
    int count[] = new int[total + 1];

    // base case
    count[0] = 1;

    // count ways for all values up
    // to 'N' and store the result
    for (int i = 1; i <= total; i++) {
      for (int j = 0; j < a.length; j++)

      // if i >= arr[j] then
      // accumulate count for value 'i' as
      // ways to form value 'i-arr[j]'
      {
        if (i >= a[j]) {
          count[i] += count[i - a[j]];
        }
      }
    }

    // required number of ways
    return count[total];

  }

  public static int priceCheck(List<String> products, List<Float> productPrices, List<String> productSold,
      List<Float> soldPrice) {
    // Write your code here
    Map<String, Float> productMap = new HashMap<>();
    int i = 0;
    for (String prod : products) {
      float f = productPrices.get(i);
      productMap.put(prod, f);
      i++;
    }
    int j = 0;
    int count = 0;
    for (String prod : productSold) {
      float f = productPrices.get(j);
      if (productMap.containsKey(prod)) {
        if (f != productMap.get(prod)) {
          count++;
        }
      }
      j++;
    }
    return count;

  }
  public static int getRich(long initialEnergy, List<Integer> energy, List<Integer> coins) {
    // Write your code here

    if(es==energy.length||cs==coins.length)
      return 0;

    if(ie<1)
    { */
/*if intial energy is less than 1 then if we are somewhere in the
                  middle of the array, we cannot proceed further.*//*


      if(es!=0)
        return 0;
      else  //if we are at start i.e., at 0th house we can take its energy
        return func(energy[es],energy,coins,es+1,cs+1);
    }
    else
      return Math.max(coins[es]+func((ie-1),energy,coins,es+1,cs+1),func(ie+energy[es],energy,coins,es+1,cs+1));
  }
}

*/
