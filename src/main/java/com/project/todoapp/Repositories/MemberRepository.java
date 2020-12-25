package com.project.todoapp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.todoapp.Entities.Member;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {

    Member findByEmail(String email);

}