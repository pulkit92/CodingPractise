package com.expense.management;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ExpenseManagementLaucher {
  public static void main(String args[]) {
    UserTable userTable = new UserTable();
    userTable.addUsers();
    OperationHelper operationHelper = new OperationHelper();
    Scanner sc = new Scanner(System.in);
    String input1 = "EXPENSE user1 1000 4 user1 user2 user3 user4 EQUAL";
    operationHelper.operation(input1.split(" "),userTable);

    String input2 = "EXPENSE user1 1250 2 user2 user3 EXACT 370 880";
    operationHelper.operation(input2.split(" "),userTable);


  }
}
