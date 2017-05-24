package ru.testprojects.crudrtcomm.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.Date;

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
    private Date startDate;

    @Column(name = "end_date", nullable = false, columnDefinition = "timestamp default now()")
    private Date endDate;

    public ToDo() {

    }

    public boolean isNew() {
        return this.getId() == null;
    }

    public ToDo(Integer id, String description, Date startDate, Date endDate) {
        this.id = id;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public ToDo(String description) {
        this.description = description;
        this.startDate = new Date();
        this.endDate = new Date();
    }

    public ToDo(String description, Date endDate) {
        this.description = description;
        this.startDate = new Date();
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
