package com.project.todoapp.Controller;
import com.project.todoapp.Entities.ToDo;
import com.project.todoapp.Services.ToDoService;
import com.project.todoapp.Repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.project.todoapp.Repositories.MemberRepository;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.security.Principal;
import java.util.Date;

@Controller
public class IndexController {

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    ToDoService toDoService;

    /*@GetMapping("/")
    public String showIndex(Model model, Principal principal, Member member){
        if(principal == null){
            return "views/loginForm";
        }
        return "index";
    }*/
    @GetMapping("/user")
    public String showIndex(Model model, Principal principal){
        if(principal == null){
            return "views/loginForm";
        }
        /*model.addAttribute("message", "Hello everyone, we are go to back to Spring with together");
        model.addAttribute("date", new Date());*/
        model.addAttribute("members", memberRepository.getOne(principal.getName()));
        model.addAttribute("work", new ToDo());
        return "index";
    }
    @GetMapping("/addWork")
    public String addWork(@ModelAttribute("todo")ToDo todo, Principal principal, Model model){
        todo.setWorkOwner(memberRepository.getOne(principal.getName()).getEmail());
        toDoService.addWork(todo);
        return "redirect:/user";
    }
}