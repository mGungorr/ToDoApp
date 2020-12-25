package com.project.todoapp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.project.todoapp.Entities.Member;
import com.project.todoapp.Entities.Role;
import com.project.todoapp.Repositories.MemberRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public Member createMember(Member member){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        member.setPassword(encoder.encode(member.getPassword()));
        Role memberRole = new Role("USER");
        List<Role> roles = new ArrayList<>();
        roles.add(memberRole);
        member.setRole(roles);
        memberRepository.save(member);
        return member;
    }
}