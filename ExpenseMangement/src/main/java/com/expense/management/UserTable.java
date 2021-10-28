package com.expense.management;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserTable {
  private Map<String, User> userMap = new HashMap<>();

  public void addUsers() {
    User user1 = new User("user1", "name1");
    userMap.put("user1", user1);
    User user2 = new User("user2", "name2");
    userMap.put("user2", user2);

    User user3 = new User("user3", "name3");
    userMap.put("user3", user3);

    User user4 = new User("user4", "name4");
    userMap.put("user4", user4);

  }

  public User getUserById(String userID) {
    if (userMap.containsKey(userID)) {
      return userMap.get(userID);
    }
    return null;
  }

  public List<User> getAllUser() {
   return new ArrayList<User>(userMap.values());
  }
}
