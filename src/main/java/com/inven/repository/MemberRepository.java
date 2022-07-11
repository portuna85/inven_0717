package com.inven.repository;

import com.inven.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    @PersistenceContext
    private final EntityManager em;

    // 회원 등록
    public void save(Member member) {
        em.persist(member);
    }

    // 회원 id로 단건 조회
    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    public List<Member> findAll() {
        return em.createQuery("SELECT m FROM Member m", Member.class).getResultList();
    }

    // 회원 이름으로 검색
    public List<Member> findByName(String name) {
        return em.createQuery("SELECT m FROM Member m WHERE m.username = :name", Member.class)
                .setParameter("name",name)
                .getResultList();
    }

    // 회원정보 수정
    public Member update(Long id) {
        return null;
    }

    // 회원 삭제
    public void deleteMember(Long id) {

    }
}
