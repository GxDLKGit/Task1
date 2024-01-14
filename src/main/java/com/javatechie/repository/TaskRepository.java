package com.javatechie.repository;

import com.javatechie.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TaskRepository extends MongoRepository<Task,String> {
    List<Task> findByName(String name);
    @Query("{assignee: ?0 }")
    List<Task> getTaskByAssignee(String assignee);
}
