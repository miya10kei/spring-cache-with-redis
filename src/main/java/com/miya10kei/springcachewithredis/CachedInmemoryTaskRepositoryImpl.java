package com.miya10kei.springcachewithredis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Primary
@Repository
@CacheConfig(cacheNames = "tasks")
public class CachedInmemoryTaskRepositoryImpl implements TaskRepository {

  private static final Logger LOGGER = LoggerFactory.getLogger(CachedInmemoryTaskRepositoryImpl.class);

  private final List<Task> data = new ArrayList<>();

  {
    {
      data.add(new Task(1, "cooking"));
      data.add(new Task(2, "study"));
      data.add(new Task(3, "cleaning"));
      data.add(new Task(4, "work"));
      data.add(new Task(5, "shopping"));
    }
  }

  @Cacheable("tasks")
  @Override
  public List<Task> findAll() {
    LOGGER.info("Not cache access");
    return Collections.unmodifiableList(this.data);
  }

  @Cacheable
  @Override
  public Optional<Task> findOne(int id) {
    LOGGER.info("Not cache access");
    return data.stream().filter(it -> it.getId() == id).findFirst();
  }
}
