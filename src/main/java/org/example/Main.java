package org.example;

import io.javalin.Javalin;
import model.TaskRepository;
import model.TimeRecordRepository;
import model.Task;
import model.TimeRecord;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Javalin app = Javalin.create().start(4711);

        TaskRepository taskRepository = new TaskRepository();
        TimeRecordRepository timeRecordRepository = new TimeRecordRepository();

        app.get("/tasks", ctx -> {
            List<Task> tasks = taskRepository.findAll();
            ctx.json(tasks);
        });

        app.post("/tasks", ctx -> {
            Task task = ctx.bodyAsClass(Task.class);
            taskRepository.save(task);
            ctx.status(201).json(task);
        });

        app.post("/tasks/{taskId}/time", ctx -> {
            long taskId = Long.parseLong(ctx.pathParam("taskId"));
            Task task = taskRepository.findAll().stream()
                    .filter(t -> t.getId().equals(taskId))
                    .findFirst().orElse(null);

            if (task != null) {
                TimeRecord timeRecord = new TimeRecord(LocalDateTime.now(), null, task);
                timeRecordRepository.save(timeRecord);
                ctx.status(201).json(timeRecord);
            } else {
                ctx.status(404).result("Task not found");
            }
        });
    }
}
