/*
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertToColumnIndex {

  public static void main(String args[]) {

    ConvertToColumnIndex c = new ConvertToColumnIndex();
    System.out.println(c.convertToColumnIndex("AA"));
    System.out.println(c.convertToColumnIndex("A"));
    System.out.println(c.convertToColumnIndex("ZZ"));
    System.out.println(c.convertToColumnIndex("AAA"));

  }

  int convertToColumnIndex(String columnAddress) {

    int out = 0;
    for (int i = 0; i < columnAddress.length(); i++) {
      out = out * 26;
      out = out + columnAddress.charAt(i) - 'A' + 1;

    }
    return out;

  }

}

  */
/*
  AA->

  out =1
   *//*

  List<Long> getUniquePhoneNumber(List<Long> phoneNumbers) {

    List<Long> uniqueList = new ArrayList<>();
    uniqueList = phoneNumbers.stream().distinct().collect(Collectors.toList());

    return uniqueList;

  }
}*/
