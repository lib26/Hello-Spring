package hello.hellospring.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * 도메인: 비즈니스 도메인 객체, 예) 회원, 주문, 쿠폰 등등 주로 데이터베이스에 저장하고 관리됨
 * ORM -> 객체를 관계형DB 테이블과 매핑하는것
 * 어노테이션들을 가지고 DB 테이블과 매핑을 하는것.
 */
@Entity
public class Member {

    @Id //PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB에서 자동으로 생성해주는 것을 identity라고한다
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
