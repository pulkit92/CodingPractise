package com.inmemory;

public class Column {
  private String columnName;
  ValueType type;
  Constraint contraint;


  public String getColumnName() {
    return columnName;
  }

  public void setColumnName(String columnName) {
    this.columnName = columnName;
  }

  public ValueType getType() {
    return type;
  }

  public void setType(ValueType type) {
    this.type = type;
  }

  public Constraint getContraint() {
    return contraint;
  }

  public void setContraint(Constraint contraint) {
    this.contraint = contraint;
  }

}
