package org.lms.account;

import java.util.Date;

public class Member {

  private Date dateOfMembership;
  private int totalBooksCheckedout;
  public int getTotalBooksCheckedout();

  public boolean reserveBookItem(BookItem bookItem);

  private void incrementTotalBooksCheckedout();
}
