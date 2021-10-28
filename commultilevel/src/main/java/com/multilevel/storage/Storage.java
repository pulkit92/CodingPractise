package com.multilevel.storage;

public interface Storage<Key, Value> {
  Value get(Key key);

  void add(Key key, Value value);

  void remove(Key key);
}
