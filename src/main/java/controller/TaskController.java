package controller;

import io.javalin.Javalin;
import io.javalin.http.Context;
import model.Task;
import model.TaskRepository;

public class TaskController {

    private final TaskRepository taskRepository = new TaskRepository();

    public void setupRoutes(Javalin app) {
        // Anzeige der Aufgabenliste
        app.get("/tasks", ctx -> {
            ctx.attribute("tasks", taskRepository.findAll());
            ctx.render("/tasks.html");  // Dies ist das Thymeleaf Template
        });

        // Hinzufügen einer neuen Aufgabe
        app.post("/tasks", ctx -> {
            String title = ctx.formParam("title");
            String description = ctx.formParam("description");

            if (title != null && description != null && !title.isEmpty() && !description.isEmpty()) {
                Task newTask = new Task(title, description);
                taskRepository.save(newTask);
                ctx.redirect("/tasks");  // Nach dem Hinzufügen zur Liste zurück zur Aufgabenübersicht
            } else {
                ctx.status(400).result("Titel und Beschreibung dürfen nicht leer sein");
            }
        });
    }
}
