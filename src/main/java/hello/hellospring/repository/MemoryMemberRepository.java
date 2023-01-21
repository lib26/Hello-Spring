package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

/**
 * 리포지토리: 데이터베이스에 접근, 도메인 객체를 DB에 저장하고 관리
 * 회원 리포지토리 메모리 구현체
 * 동시성 문제가 고려되어 있지 않음, 실무에서는 ConcurrentHashMap, AtomicLong 사용 해야한다
 */
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L; // 0,1,2...

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }


    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream() // map의 value값들(member)을 stream으로 돌려서
                .filter(member -> member.getName().equals(name)) // 이름이 같은 경우만 걸러주고
                .findAny(); // 그중에 찾으면 Optional로 반환한다. 없으면 optional에 null이 포함되서 반환된다
    }

    @Override
    public List<Member> findAll() { // 저장소는 map인데 반환은 List라서
        return new ArrayList<>(store.values()); // 결국 values인 member들이 리스트를 형성하게 된다
    }

    // 테스토용?
    public void clearStore() {
        store.clear();
    }
}
