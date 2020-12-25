package com.project.todoapp.Services;
import com.project.todoapp.Entities.ToDo;
import com.project.todoapp.Repositories.ToDoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {

    private final ToDoRepository workRepo;

    public ToDoService(ToDoRepository workRepo) {
        this.workRepo = workRepo;
    }


    public List<ToDo> allWorks() {
        return workRepo.findAll();
    }

    public void addWork(ToDo work){
        workRepo.save(work);
    }
    /*public List<ToDo> Todosbyowners(String user_name){
        return workRepo.Todosbyowners(user_name)
    }*/
}
