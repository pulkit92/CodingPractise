package com.multilevel.main;

import com.multilevel.cache.CacheProvider;
import com.multilevel.cache.MultiLevelCache;
import com.multilevel.model.LevelCacheData;
import com.multilevel.model.ReadResponse;
import com.multilevel.policy.EvictionPolicy;
import com.multilevel.policy.LRUEvictionPolicy;
import com.multilevel.storage.InMemoryStorage;
import com.multilevel.storage.Storage;

public class MultiLevelCacheInitilizer {
  private final int cacheLevels;

  public MultiLevelCacheInitilizer(int cacheLevels) {
    this.cacheLevels = cacheLevels;
  }

  public static void main(String args[]) {
    MultiLevelCache root   = null;
    MultiLevelCache parent = null;

    int level = 7;
    MultiLevelCacheInitilizer multiLevelCacheInitilizer = new MultiLevelCacheInitilizer(level);
    for (int i = 0; i < 7; i++) {
      EvictionPolicy evictionPolicy = new LRUEvictionPolicy();
      Storage storage = new InMemoryStorage();
      CacheProvider cacheProvider = new CacheProvider(evictionPolicy, storage);
      LevelCacheData levelCacheData = new LevelCacheData();
      MultiLevelCache multiLevelCache  = new MultiLevelCache(cacheProvider, levelCacheData);
      if (parent == null) {
        parent = multiLevelCache;
        root=multiLevelCache;
      } else {
        parent.nextLevel = multiLevelCache;
        parent = parent.nextLevel;

      }
      root.set("pulkit","bajpai");
     ReadResponse readResponse= root.get("pulkit");

    }

  }

}
