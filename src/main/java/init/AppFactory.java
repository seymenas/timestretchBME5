package init;

import controller.Controller;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.Repository;

public class AppFactory {
    private static Repository _REPO;
    private static EntityManagerFactory _EMF;

    private static Controller _CONTROLLER;

    static Repository createRepository() {
        if (_REPO == null) {
            _REPO = new Repository();
        }

        if (_EMF == null) {
            _EMF = Persistence.createEntityManagerFactory("hr");
        }
        return _REPO;
    }
    static Controller createController(Repository repo){
        if (_CONTROLLER == null) {
            //_CONTROLLER = new Controller(repo);
        }
        return _CONTROLLER;
    }
}

