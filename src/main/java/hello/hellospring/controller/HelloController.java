package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //@Controller 어노테이션이 적용된 클래스가 Controller임을 나타내고 사용가능
public class HelloController {
    @GetMapping("hello") //GET 요청방식에 그 GET. GET 방식: 서버의 리소스에 데이터 요청/POST: 서버의 리소스를 새로 생성 및 업뎃 위해 데이터 보냄
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello"; // resources:templates/에 hello.html 찾아서 랜더링
    }
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name") String name, Model model){
//        외부에서 받는 것, ex, http://localhost:8080/hello-mvc?name=spring!
//        ?name=spring! 이 부분
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody //http의 body 부분에 data를 직접 넣어주겠다는 것. html-template(view)이런게 아니라 그대로 넘겨주는 것
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){ //json 방식.(html같은 xml방식은 무겁고 태그 두번쓰고 그래야하는데 json은 name-value로 심플해서 많이 사용)
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{
        private String name;
        // getter&setter: ^+ent
        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name = name;
        }
    }
}
