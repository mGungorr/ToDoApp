package com.project.todoapp.Entities;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
@Entity
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    @NotEmpty
    private  String description;
    @NotEmpty
    private String due;
    @NotEmpty
    private String status;
    @NotEmpty
    private String user_name;

    public ToDo(@NotEmpty String description, @NotEmpty String due, @NotEmpty String status, @NotEmpty String user_name) {
        this.description = description;
        this.due = due;
        this.status = status;
        this.user_name = user_name;
    }

    public ToDo(){}

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

    public String getdue() {
        return due;
    }

    public void setdue(String endDate) {
        this.due = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getWorkOwner() {
        return user_name;
    }

    public void setWorkOwner(String workOwner) {
        this.user_name = user_name;
    }
}
