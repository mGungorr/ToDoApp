package com.project.todoapp.Controller;

import com.project.todoapp.Entities.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.project.todoapp.Entities.Member;
import com.project.todoapp.Repositories.MemberRepository;
import com.project.todoapp.Services.MemberService;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class MemberController {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @GetMapping("/login")
    public String showLoginForm(){
        return "views/loginForm";
    }

    @GetMapping("/register")
    public String registerForm(Model model){
        model.addAttribute("member", new Member());
        return "views/registerForm";
    }

    /*@GetMapping("/user")
    public String showIndex(Model model, Principal principal){
        if(principal == null){
            return "views/loginForm";
        }

        model.addAttribute("members", memberRepository.getOne(principal.getName()));
        model.addAttribute("todo", new ToDo());
        return "index";
    }*/
    @PostMapping("/register")
    public String registerMember(@Valid Member member, Model model){
        String email = member.getEmail();
        if (memberRepository.findByEmail(email) != null){
            model.addAttribute("exist",true);
            return "views/registerForm";
        }
        memberService.createMember(member);
        model.addAttribute("success", true);
        return "redirect:/members";
    }
}
