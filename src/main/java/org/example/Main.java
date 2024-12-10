package org.example;

import controller.TaskController;
import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinThymeleaf;
import model.TaskRepository;
import model.TimeRecordRepository;
import model.Task;
import model.TimeRecord;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Javalin app = Javalin.create(config -> {
            config.fileRenderer(new JavalinThymeleaf());
            //config.addStaticFiles("/public");  // Wenn du statische Dateien hast (CSS, JS)
        }).start(8080);

        TaskController taskController = new TaskController();
        taskController.setupRoutes(app);
    }
}
