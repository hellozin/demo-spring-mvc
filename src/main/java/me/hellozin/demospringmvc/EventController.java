package me.hellozin.demospringmvc;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class EventController {

    @PostMapping("/events")
//    public Event createEvent(@RequestBody Event event) {
    public ResponseEntity<Event> createEvent(HttpEntity<Event> request) {
        // repository save event
        return ResponseEntity.ok(request.getBody());
    }

}
