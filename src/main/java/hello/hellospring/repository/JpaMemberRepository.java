package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import jakarta.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository {

    private final EntityManager em;

    /**
     * JPA는 메니저로 모든 동작을 한다. 객체 주입받아야함
     * 그래서 스프링 부트가 DB와 연결해서 메니저를 자동으로 만들어준다 -> DI
     * gradle 라이브러리와 application properties 정보들이 있어서 가능한 일이다
     */
    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member); // insert와 setId 세팅까지 다 해준다
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id); // select. PK 탐색일 경우
        return Optional.ofNullable(member);
    }

    /**
     * PK 조회가 아닌 경우는 JPQL쿼리를 사용해야한다
     * sql을 테이블을 대상으로 쿼리를 날리지만
     * JPQL쿼리 언어는 객체를 대상으로 하여금 sql로 번역해서 쿼리를 날린다.
     */
    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select m from Member as m where m.name = :name ", Member.class)
                .setParameter("name", name)
                .getResultList();

        return result.stream().findAny(); // Optional 반환
    }

    @Override
    public List<Member> findAll() {
        // Member 엔티티를 대상으로 쿼리 수행
        // m은 객체 자체를 조회한다
        return em.createQuery("select m from Member as m", Member.class)
                .getResultList();
    }

}
