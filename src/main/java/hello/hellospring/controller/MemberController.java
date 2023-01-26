package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController { //회원 컨트롤러

    private final MemberService memberService;

    @Autowired //spring container에서 가져오는 것. cotroller-service 연결. memberController가 생성될 때 spring 빈에 등록되어있는 member service 객체를 가져다가 넣어줌 -> 의존관계 주입
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }
}
