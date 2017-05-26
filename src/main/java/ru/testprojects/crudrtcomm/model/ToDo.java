package ru.testprojects.crudrtcomm.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "todos")
public class ToDo {
    private static final int START_SEQ = 100000;

    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1, initialValue = START_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    private Integer id;

    @Column(name = "description", nullable = false)
    @NotBlank
    private String description;

    @Column(name = "start_date", nullable = false, columnDefinition = "timestamp default now()")
    private LocalDateTime startDate;

    @Column(name = "end_date", nullable = false, columnDefinition = "timestamp default now()")
    private LocalDateTime endDate;

    public ToDo() {

    }

    public boolean isNew() {
        return this.getId() == null;
    }

    public ToDo(Integer id, String description, LocalDateTime startDate, LocalDateTime endDate) {
        this.id = id;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public ToDo(String description) {
        this.description = description;
        this.startDate = LocalDateTime.now();
        this.endDate = LocalDateTime.now();
    }

    public ToDo(String description, LocalDateTime endDate) {
        this.description = description;
        this.startDate = LocalDateTime.now();
        this.endDate = endDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
}
