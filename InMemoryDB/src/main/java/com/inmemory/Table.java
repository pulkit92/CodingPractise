package com.inmemory;

import java.util.List;

public class Table {
  private String TableName;
  private List<Column> columnList;

  public Table(String TableName, List<Column> columnList) {
    this.TableName = TableName;
    this.columnList = columnList;

  }

  public String getTableName() {
    return TableName;
  }

  public void setTableName(String tableName) {
    TableName = tableName;
  }

  public List<Column> getColumnList() {
    return columnList;
  }

  public void setColumnList(List<Column> columnList) {
    this.columnList = columnList;
  }



}
