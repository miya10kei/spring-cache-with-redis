package com.miya10kei.springcachewithredis;

import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/tasks")
public class TaskController {

  private final TaskRepository taskRepository;
  private final ConcurrentMapCacheManager cacheManager;

  public TaskController(TaskRepository taskRepository, ConcurrentMapCacheManager cacheManager) {
    this.taskRepository = taskRepository;
    this.cacheManager = cacheManager;
  }

  @GetMapping(produces = APPLICATION_JSON_VALUE)
  List<Task> getTasks() {
    return this.taskRepository.findAll();
  }

  @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
  ResponseEntity<Task> getTask(@PathVariable("id") Integer id) {
    var task = this.taskRepository.findOne(id);

    if (task.isEmpty()) {
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok(task.get());
  }

}
