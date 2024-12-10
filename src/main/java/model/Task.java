package model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Primärschlüssel

    private String title;        // Titel der Aufgabe
    private String description;  // Beschreibung der Aufgabe

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TimeRecord> timeRecords;  // Liste von Zeitprotokollen

    // Standardkonstruktor
    public Task() {}

    // Konstruktor mit Parametern
    public Task(String title, String description) {
        this.title = title;
        this.description = description;
    }

    // Getter und Setter für die Felder

    public Long getId() {
        return id;  // Diese Methode gibt die ID der Aufgabe zurück
    }

    public void setId(Long id) {
        this.id = id;  // Diese Methode setzt die ID der Aufgabe
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<TimeRecord> getTimeRecords() {
        return timeRecords;
    }

    public void setTimeRecords(List<TimeRecord> timeRecords) {
        this.timeRecords = timeRecords;
    }
}
