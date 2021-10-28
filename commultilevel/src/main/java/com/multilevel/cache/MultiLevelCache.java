package com.multilevel.cache;

import com.multilevel.model.LevelCacheData;
import com.multilevel.model.ReadResponse;

public class MultiLevelCache<Key, Value> {
  private final CacheProvider cacheProvider;
  private final LevelCacheData levelCacheData;
  public MultiLevelCache<Key, Value> nextLevel;

  public MultiLevelCache(CacheProvider cacheProvider, LevelCacheData levelCacheData) {
    this.cacheProvider = cacheProvider;
    this.levelCacheData = levelCacheData;
  }

  public void set(Key key, Value value) {

  }

  public ReadResponse get(Key key) {
    ReadResponse readResponse = new ReadResponse();
    return readResponse;
  }



}
