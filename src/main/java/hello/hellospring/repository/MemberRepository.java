package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

//interface: 다른 클래스를 작성할 때 기본이 되는 틀을 제공하면서 다른 클래스 사이의 중간 매개 역할까지 담당하는 일종의 추상 클래스
//java8이전에는 public abstract 추상메소드와 public static final 상수만 가능
public interface MemberRepository { //회원 리포지토리 인터페이스
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
