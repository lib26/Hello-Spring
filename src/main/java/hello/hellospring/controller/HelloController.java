package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello") // GET : http://localhost:8080/hello
    public String hello(Model model){ // 스프링이 model을 받아와서
        model.addAttribute("data","hello!!"); // key와 value를 설정?해주고
        return "hello"; // hello.html로 가서 렌더링을 해라.
        // return "hello"는 기본적으로 스프링부트가 resources 안에 templates 밑에 hello.html을 찾도록 설계되어있다.
        // Thymeleaf 템플릿 엔진이 처리
    }
}
