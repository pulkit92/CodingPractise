package com.inmemory;

public enum ValueType {
  String_TYPE("String"),
  IntegerType("Integer");

  ValueType(String valueType){
  }
  boolean isvalid(Object value,int startLenght,int endLengbht){
    if(value instanceof String){

    }
    else if(value instanceof Integer){

    }
    return false;
  }
}
