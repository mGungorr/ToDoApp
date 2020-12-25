package com.project.todoapp.Controller;

import com.project.todoapp.Entities.Member;
import com.project.todoapp.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    AdminServices adminService;
    @Autowired
    MemberService memberService;

    @GetMapping("/members")
    public String getMembers(Model model) {
        List<Member> members = adminService.allMembers();
        model.addAttribute("members", members);
        return "views/members";
    }

    @GetMapping("/delete/{email}")
    public String deleteMember(@PathVariable(name="email") String email){
        adminService.deleteMember(email);
        return "redirect:/members";
    }
    @GetMapping("/update/{email}")
    public String updateMember(@PathVariable(name="email") String email, Model model){
        Member member = adminService.findByEmail(email);
        model.addAttribute("member", member);
        return "views/update";
    }
    @PostMapping("/update/{email}")
    public String update(@PathVariable(name="email") String email, Model model, @Valid Member member){

        return "views/members";
    }
}
