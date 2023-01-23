package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * 인터페이스는 인터페이스를 다중 상속 할 수 있다
 * JpaRepository를 상속받고 있다면 구현체를 자동으로 만들어준다
 * 그리고 스프링 빈에 자동으로 등록해준다
 * findByName은 JpaRepository에서 제공되지 않는 메소드라서 따로 작성한다
 */
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    /**
     * JPQL : select m from Member m where m.name = ? 식으로 쿼리를 짠다
     * 그래서 인터페이스 이름만으로 쿼리 짜는 것이 끝낼 수 있다
     * 반환타입, 메서드 이름, 파라미터 등으로 조합을 하는 원리
     */
    @Override
    Optional<Member> findByName(String name);

}