package model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class TimeRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    public TimeRecord() {}

    public TimeRecord(LocalDateTime startTime, LocalDateTime endTime, Task task) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.task = task;
    }

    // Getter und Setter
}
