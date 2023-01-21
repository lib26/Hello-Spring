package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    /**
     * localhost:8080/
     * 이게 없으면 resources/static/index.html이 welcome page가 된다.
     * 컨테이너에 있는 Controll에 등록 되어있는지 먼저 확인하기 때문
     */
    @GetMapping("/")
    public String home() {
        return "home";
    }
}