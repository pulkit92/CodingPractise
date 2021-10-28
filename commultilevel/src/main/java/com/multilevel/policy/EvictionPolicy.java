package com.multilevel.policy;

public interface EvictionPolicy <Key>{
  void keyAccessed(Key key);
  Key evictKey();
}
