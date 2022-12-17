package com.todo.planingtool.persistance.repository;

import com.todo.planingtool.persistance.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepository extends MongoRepository<Task, String>{


}
