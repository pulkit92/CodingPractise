package com.expense.management;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OperationHelper {

  public void operation(String arr[], UserTable userTable) {
    switch (arr[0]) {
      case "EXPENSE": {
        addExpense(arr, userTable);
      }
      case "SHOW": {
        show(null, userTable);
      }
      default:

    }

  }

  public void addExpense(String arr[], UserTable userTable) {
    // EXPENSE user1 1000 4 user1 user2 user3 user4 EQUAL
    // EXPENSE user1 1250 2 user2 user3 EXACT 370 880

    String userSpent = arr[1];
    int totalUserSpent = Integer.parseInt(arr[3]);
    int amt = Integer.parseInt(arr[2]);
    //need to fixed
    String expenseType = arr[8];
    List<User> oweUserList = new ArrayList<>();
    int count = 4;
    for (int i = 0; i < totalUserSpent; i++) {
      if (userTable.getUserById(arr[count]) == null) {
        throw new IllegalArgumentException("Wrong UserPassed");
      }
      User user = new User(arr[count], "name");
      oweUserList.add(user);
      count++;
    }

    User paidUser = userTable.getUserById(userSpent);
    if (paidUser == null) {
      throw new IllegalArgumentException("Wrong UserPassed");
    }


    Map<User, Integer> oweUserMap = new HashMap<>();
    switch (expenseType) {
      case "EXACT": {
        int user1amt = 370;
        int user2amt = 880;
        List<Integer> amtExact = new ArrayList<>();
        amtExact.add(user1amt);
        amtExact.add(user2amt);
        int count1 = 0;
        for (User user : oweUserList) {
          oweUserMap.put(user, amtExact.get(count1));
        }
        count1++;
        paidUser.addExpense(amt, oweUserMap);
      }
      case "EQUAL": {
        int dividedAmt = amt / totalUserSpent;
        for (User user : oweUserList) {
          oweUserMap.put(user, dividedAmt);
        }
        paidUser.addExpense(amt, oweUserMap);
      }
    }
  }

  public void show(String userID, UserTable userTable) {
    if (userID == null) {
      List<User> users = userTable.getAllUser();
      for (User user : users) {
        user.show();
      }
    } else {
      userTable.getUserById(userID).show();
    }
  }
}