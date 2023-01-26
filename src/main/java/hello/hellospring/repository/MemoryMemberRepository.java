package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository //spring 뜰 때 repository 가지고 온다
public class MemoryMemberRepository implements MemberRepository{ //회원 리포지토리 메모리 구현체

    //Map<key, value>: key 중복x, value 중복o
    private static Map<Long, Member> store = new HashMap<>(); //new에서 타입 파라미터 생략가능
    private static long sequence = 0L; //0L: long형 0
    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member); //key-value는 put메소드 이용하여 입력
        return member;
    }

    //Optional<>: null이 올 수 있는 값을 감싸는 클래스로 참조하더라도 NPE가 발생하지 않도록
    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream() //stream(): 컬렉션, 배열 안의 요소들을 하나씩 참조하며 반복적 처리를 하는 것
                .filter(member -> member.getName().equals(name)) //member객체에서 getName()을 가져와 name과 비교
                .findAny(); //어떤 것이든 찾아서 반환
                //람다식: 매개값 -> 구현코드
    }

    @Override
    public List<Member> findAll() {
        //list: like 사각형, 인터페이스, 공통되는 메소드를 추출해놓은 클래스. 메모리가 허용하는 한 계속해서 추가
        //arraylist: like 정사각형, list에 상속된 클래스. 크기 동적
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
