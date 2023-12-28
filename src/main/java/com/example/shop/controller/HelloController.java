package com.example.shop.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    // helloController 를 new 해서 객체를 생성해야 hello 메서드를 쓸수있는데 ?
    // 이렇게 new 하는 것을 컨테이너에게 맡기겠다.
    // 즉 스프링 컨테이너는
    @GetMapping("/hi")
    public String hi() {
        return "hi~~";
    }

    @GetMapping("/hello")
    @ResponseBody
    public List<String> hello() {
        List<String> names = new ArrayList<>();
        names.add("kang");
        names.add("kim");
        names.add("hong");
        names.add("Lee");
        return names;
    }
}
