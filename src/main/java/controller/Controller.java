package controller;

import io.javalin.Javalin;
import model.Repository;

public class Controller {

    private final Repository repository = new Repository();

    public void setupRoutes(Javalin app) {
        app.get("/tasks", ctx -> {
            ctx.json(repository.getTasks());
        });

        app.post("/tasks", ctx -> {
            String title = ctx.formParam("title");
            String description = ctx.formParam("description");
            repository.addTask(title, description);
            ctx.status(201).result("Task hinzugefügt");
        });

        app.delete("/tasks/:id", ctx -> {
            int id = Integer.parseInt(ctx.pathParam("id"));
            repository.deleteTask(id);
            ctx.status(204).result("Task gelöscht");
        });
    }
}
