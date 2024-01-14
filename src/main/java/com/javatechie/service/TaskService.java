package com.javatechie.service;

import com.javatechie.model.Task;
import com.javatechie.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;


    public Task addtask(Task task){
        task.setTaskId(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(task);
    }
    public List<Task> findAllTasks(){
        return repository.findAll();
    }
    public Task getTaskByTaskId(String taskId){
        return repository.findById(taskId).get();
    }
    public List<Task> getTaskByName(String name){
        return repository.findByName(name);
    }
    public List<Task> getTaskByAssignee(String assignee){
        return repository.getTaskByAssignee(assignee);
    }
    public Task updateTask(Task taskRequest){
        Task existingTask = repository.findById(taskRequest.getTaskId()).get();
        existingTask.setName(taskRequest.getName());
        existingTask.setProject(taskRequest.getProject());
        existingTask.setAssignee(taskRequest.getAssignee());
        existingTask.setRajeshSinghProperty(taskRequest.getRajeshSinghProperty());
        return repository.save(existingTask);

    }
    public String deleteTask(String taskId){
        repository.deleteById(taskId);
        return taskId+" task deleted from dashboard";
    }

}
