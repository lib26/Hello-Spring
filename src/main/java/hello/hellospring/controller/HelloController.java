package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // 나는 컨트롤러이다
public class HelloController {

    @GetMapping("hello") // GET : http://localhost:8080/hello 를 치면 아래의 method를 호출해준다. 스프링에서 다 해줌
    public String hello(Model model){ // 스프링이 model을 받아와서
        model.addAttribute("data","hello!!"); // key와 value를 설정?해주고
        return "hello"; // hello.html로 가서 렌더링을 해라.
        // return "hello"는 기본적으로 스프링부트가 resources 안에 templates 밑에 hello.html을 찾도록 설계되어있다.
        // 즉, 컨트롤러에서 리턴 값으로 문자를 반환하면 뷰 리졸버( viewResolver )가 화면을 찾아서 처리한다.
        // Thymeleaf 템플릿 엔진이 처리
    }
}
