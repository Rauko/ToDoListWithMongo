package com.todo.planingtool.controller;

import com.todo.planingtool.dto.TaskDTO;
import com.todo.planingtool.persistance.model.Task;
import com.todo.planingtool.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class
TaskController {

    //pattern SingleTone
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks/all")
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        return ResponseEntity.ok().body(tasks);
    }

    @PostMapping("/tasks/add")
    public ResponseEntity<Task> addTask(@RequestParam String taskInfo) {
        Task task = taskService.addTask(taskInfo);
        return ResponseEntity.ok().body(task);
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Object> deleteTask (@PathVariable String id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/tasks/edit/{id}/editinfo/{newTaskInfo}")//????
    public ResponseEntity<Task> editTaskInfo(@PathVariable String id, @PathVariable String newTaskInfo) {
        Task task = taskService.editTaskInfo(newTaskInfo, id);
        return ResponseEntity.ok().body(task);
    }

    @PostMapping("/tasks/edit/{id}/editstatus/{newStatus}")//????
    public ResponseEntity<Task> editTaskInfo(@PathVariable String id, @PathVariable Boolean newStatus) {
        Task task = taskService.editTaskStatus(newStatus, id);
        return ResponseEntity.ok().body(task);
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity<Task> editTask(@PathVariable String id, @RequestBody TaskDTO taskDTO) {
        Task task = taskService.editTask(id, taskDTO);
        return ResponseEntity.ok().body(task);
    }
}
