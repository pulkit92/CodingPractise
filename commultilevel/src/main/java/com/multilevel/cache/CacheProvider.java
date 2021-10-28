package com.multilevel.cache;

import com.multilevel.policy.EvictionPolicy;
import com.multilevel.storage.Storage;

public class CacheProvider<Key, Value> {
  private final EvictionPolicy<Key> evictionPolicy;
  private final Storage<Key, Value> storage;

  public CacheProvider(EvictionPolicy evictionPolicy, Storage storage) {
    this.evictionPolicy = evictionPolicy;
    this.storage = storage;
  }
}
