package org.lms.account;

import org.lms.actors.Person;
import org.lms.reservation.AccountStatus;

public abstract class Account {

  private String password;
  private AccountStatus status;
  private Person person;
}
