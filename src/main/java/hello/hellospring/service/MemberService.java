package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService { //회원 서비스 개발

    private final MemberRepository memberRepository;  //final: 수정x

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository; //회원 서비스 코드를 DI 가능하게. DI(의존관계 주입): 의존관계를 외부에서 결정하고 주입하는 것
    }

    /**
     * 회원가입
     * */
    public Long join(Member member){

        validateDuplicateMeber(member); //중복회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMeber(Member member) {
        memberRepository.findByName(member.getName())
            .ifPresent(m -> {
                throw new IllegalStateException("이미 존재하는 회원");
            });
    }
    /**
     * 전체 회원조회
     * */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
