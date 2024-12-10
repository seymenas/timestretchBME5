package org.example;

import controller.Controller;
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

        Controller controller = new Controller();
        controller.setupRoutes(app);
    }
}
