package me.scpark.springdeveloper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class TestService {

    @Autowired
    TestRespository TestRespository;

    public List<Member> getAllMembers() {
        return TestRespository.findAll();
    }
    @PostMapping("/test")
    public Member saveMember(Member member) {
        return TestRespository.save(member);
    }
}