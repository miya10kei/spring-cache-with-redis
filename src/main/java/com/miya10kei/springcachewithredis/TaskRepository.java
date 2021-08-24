package com.miya10kei.springcachewithredis;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository {

  List<Task> findAll();

  Optional<Task> findOne(int id);
}
