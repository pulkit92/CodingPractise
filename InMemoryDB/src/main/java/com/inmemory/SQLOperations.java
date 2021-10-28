package com.inmemory;

import java.util.ArrayList;
import java.util.List;

public class SQLOperations {

  public void createTable(String TableName, List<Column> columnList) {
    new Table(TableName, columnList);
  }

  public void create(String tableName, Column... cols) {
    List<Column> columnList = new ArrayList<Column>();
    for (Column col : cols) {
      columnList.add(col);
    }
    createTable(tableName, columnList);
  }
}
