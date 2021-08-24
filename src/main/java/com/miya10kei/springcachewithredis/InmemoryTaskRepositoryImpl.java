package com.miya10kei.springcachewithredis;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class InmemoryTaskRepositoryImpl implements TaskRepository {

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

  @Override
  public List<Task> findAll() {
    return Collections.unmodifiableList(this.data);
  }

  @Override
  public Optional<Task> findOne(int id) {
    return data.stream().filter(it -> it.getId() == id).findFirst();
  }
}
