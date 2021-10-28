package com.inmemory;

import java.util.List;

public class Rows {
  private List<Pair<String, Object>> list;

  private void insertRecord(List<Column> columns, List<Object> objects) {

  }
}


class Pair<String, Object> {

  private String columnName;
  private Object value;

  public Pair(String columnName, Object value) {
    this.columnName = columnName;
    this.value = value;
  }
}