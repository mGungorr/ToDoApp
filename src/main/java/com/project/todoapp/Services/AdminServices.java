package com.project.todoapp.Services;

import org.springframework.stereotype.Service;
import com.project.todoapp.Repositories.*;
import com.project.todoapp.Entities.*;

import java.util.List;

@Service
public class AdminServices {

    private final MemberRepository memberRepo;

    public AdminServices(MemberRepository memberRepo) {
        this.memberRepo = memberRepo;
    }

    public List<Member> allMembers() {
        return memberRepo.findAll();
    }

    public void deleteMember(String email){
        memberRepo.deleteById(email);
    }

    public void updateMember(Member member) {
        memberRepo.save(member);
    }
    public Member findByEmail(String email){
        return memberRepo.findByEmail(email);
    }
}
