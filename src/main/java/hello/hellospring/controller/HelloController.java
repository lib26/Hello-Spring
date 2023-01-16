package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // 나는 컨트롤러이다
public class HelloController {

    // 1
    // HTML을 넘겨주는 template-engine 방식
    @GetMapping("hello") // GET : http://localhost:8080/hello 를 치면 아래의 method를 호출해준다. 스프링에서 다 해줌
    public String hello(Model model){ // 스프링이 model을 받아와서
        model.addAttribute("data","hello!!"); // key와 value를 직접 설정해주었다. model은 view에 넘겨주는 response 같다
        return "hello"; // hello.html로 가서 렌더링을 해라.
        // return "hello"는 기본적으로 스프링부트가 resources 안에 templates 밑에 hello.html을 찾도록 설계되어있다.
        // 즉, 컨트롤러에서 리턴 값으로 문자를 반환하면 뷰 리졸버( viewResolver )가 화면을 찾아서 처리한다.
        // Thymeleaf 템플릿 엔진이 처리
    }

    // 2
    @GetMapping("hello-mvc") // GET : http://localhost:8080/hello-mvc?name=spring!
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name); // 모델에 키와 벨류를 설정해준다.
        return "hello-template"; // view 리졸버는 templates/hello-template.html 를 찾아서 model을 넘긴다
    }

    // 3
    // view를 거치지 않고 문자열을 http response body에 바로 전달하는 API 방식.
    // 하지만 string만 넘겨주는 건 별 의미 없다.
    @GetMapping("hello-string")
    @ResponseBody // http 응답 body 부분에 데이터를 직접 넣어서 응답하겠다
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name; // 이 데이터가 body부분에 저장되어 html(view)이 아닌 문자열 자체가 리턴된다
    }

    // 4
    // @ResponseBody 를 사용하고, 객체를 반환하면 객체가 JSON으로 변환된다. API 방식
    @GetMapping("hello-api") // http://localhost:8080/hello-api?name=인범인범
    @ResponseBody // @ResponseBody 를 사용하면 뷰 리졸버( viewResolver )를 사용하지 않음
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello; // 객체를 반환
        // {"name":"인범인범"}
        // 즉, json이 반환된다
    }

    static class Hello {
        // class 안에서 static class를 만들 수 있다. 자바 정식문법. 나중에 helloController.Hello 식으로 쓰일 수도 있음
        private String name;

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
}
