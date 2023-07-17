package com.clouddevmind.Tasksproject.dao;

import com.clouddevmind.Tasksproject.domain.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

public interface TaskDao extends CrudRepository<Task, Long> {
    Optional<ArrayList<Task>> findAllByStatus(String status);
    Optional<ArrayList<Task>> findAllByPriority(String priority);
    Optional<ArrayList<Task>> findAllByDueDate(Date date);

}
