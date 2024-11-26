package org.example;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinThymeleaf;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        // Javalin App initialisieren mit Thymeleaf-Renderer
        Javalin app = Javalin.create(
                config -> config.fileRenderer(new JavalinThymeleaf())
        ).start(8080);

        // Route für Main-Seite
        app.get("/main", ctx -> {
            ctx.render("Main.html");
        });

        // Route für Description-Seite
        app.get("/description", ctx -> {
            ctx.render("Description.html", Map.of(
                    "title", "Timestretch - Beschreibung",
                    "description", "Timestretch ist ein System zur Aufgaben- und Zeiterfassung."
            ));
        });

        // Route für AddTask-Seite
        app.get("/addtask", ctx -> {
            ctx.render("AddTask.html");
        });

        // Route für DeleteTask-Seite
        app.get("/deletetask", ctx -> {
            // Beispiel: Dummy-Daten zur Darstellung
            List<String> tasks = List.of("Task 1", "Task 2", "Task 3");
            ctx.render("DeleteTask.html", Map.of(
                    "tasks", tasks
            ));
        });

        // Beispiel einer Route mit Query-Parametern
        app.get("/greet", ctx -> {
            String name = ctx.queryParam("name");
            if (name == null || name.isEmpty()) {
                ctx.status(400).result("Missing 'name' query parameter");
            } else {
                ctx.result("Hello " + name);
            }
        });

        // Beispiel einer POST-Anfrage (Formularverarbeitung)
        app.post("/submit-task", ctx -> {
            String taskName = ctx.formParam("taskName");
            String description = ctx.formParam("description");
            ctx.result("Task hinzugefügt: " + taskName + " mit Beschreibung: " + description);
        });
    }
}
