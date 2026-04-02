package me.scpark.springdeveloper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest // @Transactional
public class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;


    @Test
    @Sql("/insert-members.sql")
    void getAllMembers() {
        // given 준비

        // when 실행
        List<Member> members = memberRepository.findAll(); // select * from member;

        // then 검증
        assertThat(members.size()).isEqualTo(3);
    }

    @Test
    @Sql("/insert-members.sql")
    void getMemberById() {
        // given

        // when
        Member member = memberRepository.findById(2L).get();

        // then
        assertThat(member.getName()).isEqualTo("B");
    }

    @Test
    @Sql("/insert-members.sql")
    void getMemberByName() {
        // given

        // when
        // 이름이 'C'인 member 검색: select * from member where name=:name;
        Member member = memberRepository.findByName("C").get();
        // then
        assertThat(member.getId()).isEqualTo(3);
    }

    @Sql("/insert-members.sql")
    @DisplayName("레코드 삭제 테스트")
    @Test
    void deleteAll() {
        //given
        //when
        memberRepository.deleteAll();
        //then
        assertThat(memberRepository.findAll().size()).isZero();
    }

    @Sql("/insert-members.sql")
    @DisplayName("UpdateTest")
    @Test
    void update() {
        //given
        Member member = memberRepository.findById(2L).get();
        //when
        member.changeName("jmPark");
        //then
        assertThat(memberRepository.findById(2L).get().getName()).isEqualTo("jmPark");
    }
}