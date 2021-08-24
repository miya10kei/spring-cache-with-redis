package com.miya10kei.springcachewithredis;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizers;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@EnableCaching
public class CacheConfigure implements CacheManagerCustomizer<ConcurrentMapCacheManager> {

  @Override
  public void customize(ConcurrentMapCacheManager cacheManager) {

  }
}
