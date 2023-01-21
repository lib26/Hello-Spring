package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

// 스프링 빈에 해당 컨트롤러 객체를 등록한다
@Controller
public class MemberController {

    private final MemberService memberService;

    // 스프링이 시작할 때 등록되어있는 MemberService 객체를 주입시킨다.
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
