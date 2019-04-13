package me.hellozin.demospringmvc;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {

    @GetHelloMapping
    public String customHello() {
        return "hello";
    }

    @GetMapping("/hello/{name:[a-z]+}")
    @ResponseBody
    public String hello(@PathVariable String name) {
        return "hello " + name;
    }

    @RequestMapping(value = "/json", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public String jsonHandler() {
        return "json";
    }

    @GetMapping(value = "/header", headers = HttpHeaders.AUTHORIZATION+"=key")
    @ResponseBody
    public String header() {
        return "header";
    }

}
