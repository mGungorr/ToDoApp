package com.project.todoapp.Repositories;
import com.project.todoapp.Entities.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Integer> {

}
