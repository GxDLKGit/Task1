package com.javatechie.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Task {
    @Id
    private String name;
    private String taskId;
    private String assignee;
    private String project;
    private String startTime;
    private String rajeshSinghProperty;





}
