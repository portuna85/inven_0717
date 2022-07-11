package com.inven.service;

import com.inven.domain.Member;
import com.inven.repository.MemberRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    EntityManager em;

    @Test
    @Rollback(value = false)
    public void 회원가입() throws Exception {
        // given
        Member member = new Member();

        member.setUsername("kim");
        Long saveMember = memberService.join(member);
        // when


        // then

        assertEquals(member, memberRepository.findOne(saveMember));

    }


    @Test(expected = IllegalStateException.class)
    public void 중복회원조회() throws Exception {
        // given
        Member member1 = new Member();
        member1.setUsername("kim");
        Member member2 = new Member();
        member2.setUsername("kim");

        // when
        memberService.join(member1);
        memberService.join(member2);

        // then
        Assert.fail("예외가 발생해야함");

    }
}