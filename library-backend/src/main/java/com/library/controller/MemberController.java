package com.library.controller;

import com.library.model.Member;
import com.library.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberRepository memberRepo;

    @GetMapping
    public List<Member> getAllMembers() {
        return memberRepo.findAll();
    }

    @PostMapping
    public Member addMember(@RequestBody Member member) {
        return memberRepo.save(member);
    }

    @DeleteMapping("/{id}")
    public String deleteMember(@PathVariable Long id) {
        memberRepo.deleteById(id);
        return "Member deleted";
    }
}