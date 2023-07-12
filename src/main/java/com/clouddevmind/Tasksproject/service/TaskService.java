package com.clouddevmind.Tasksproject.service;

import com.clouddevmind.Tasksproject.dao.TaskDao;
import com.clouddevmind.Tasksproject.domain.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    protected TaskDao taskDao;

    public Task saveTask(Task task) {
        return this.taskDao.save(task);
    }

    public ArrayList<Task> listTasks() {
        return (ArrayList<Task>) this.taskDao.findAll();
    }

//    public ArrayList<Task> listByStatus(String status) {
//        ArrayList<Task> rawTasks = listTasks();
//        ArrayList<Task> filteredTasks = new ArrayList<>();
//        for (int i = 0; i < rawTasks.size(); i ++) {
//            if(Objects.equals(rawTasks.get(i).getStatus(), status)){
//                filteredTasks.add(rawTasks.get(i));
//            }
//        }
//        return filteredTasks;
//    }

    public Optional<ArrayList<Task>> listByStatus(String status){
        return this.taskDao.findAllByStatus(status);
    }
}
