package com.expense.management;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
  private String userId;
  private String username;
  private int amount;
  private Map<User, Integer> userAmt = new HashMap<>();

  public User(String userId, String userName) {
    this.userId = userId;
    this.userId = userId;
    this.amount = 0;
  }


  public void addExpense(int amount, Map<User, Integer> map) {
    Set<User> set = map.keySet();
    for (User user : set) {
      int amt = userAmt.getOrDefault(user, 0);
      userAmt.put(user, amt + map.get(user));
    }
  }

  public List<String> show() {
    List<String> list = new ArrayList<>();
    for (User user : userAmt.keySet()) {
      if (user.userId != this.userId) {
        //User2 owes User1: 620
        String ans = this.userId + "owes" + user.userId + ":" + userAmt.get(user);
        System.out.println(ans);
        list.add(ans);
      }
    }
    return list;
  }


}
