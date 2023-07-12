package com.clouddevmind.Tasksproject.web;

import com.clouddevmind.Tasksproject.domain.Task;
import com.clouddevmind.Tasksproject.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    TaskService taskService;

    @PostMapping("/save")
    public Task saveTask (@RequestBody Task task) {
        return this.taskService.saveTask(task);
    }

    @GetMapping("/listAll")
    public ArrayList<Task> listAll () {
        return this.taskService.listTasks();
    }

    @GetMapping("/list/{status}")

    public Optional<ArrayList<Task>> listByStatus (@PathVariable("status") String status) {
        return this.taskService.listByStatus(status);
    }
}
