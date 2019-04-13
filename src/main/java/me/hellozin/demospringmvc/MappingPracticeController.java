package me.hellozin.demospringmvc;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@Controller
public class MappingPracticeController {

    @GetMapping("/events")
    @ResponseBody
    public String events() {
        return "events";
    }

    @GetMapping("/events/{id}")
    @ResponseBody
    public String eventsById(@PathVariable String id) {
        return "events" + id;
    }

    @PostMapping(value = "/events",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    @ResponseBody
    public String postEvents() {
        return "events";
    }
}
