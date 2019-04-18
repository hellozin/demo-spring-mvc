package me.hellozin.demospringmvc;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class EventController {

    @InitBinder("event") /* event 를 받을 때에만 이 Binder를 동작 */
    public void initEventBinder(WebDataBinder webDataBinder) {
        webDataBinder.setAllowedFields("name"); // 받고 싶은 field 정의
        webDataBinder.setDisallowedFields("id"); // 받고 싶지 않은 field 값 정할 수 있음.
        webDataBinder.addValidators(new EventValidator());
    }

    /* 모든 핸들러, 뷰에서 참고를 한다. */
    @ModelAttribute
    public void categories(Model model) {
        model.addAttribute("categories", List.of("study", "seminar", "social"));
    }

//    @ModelAttribute("categories")
//    public List categories() {
//        return List.of("study", "seminar", "social");
//    }

    @PostMapping("/events")
//    public Event createEvent(@RequestBody Event event) {
    public ResponseEntity<Event> createEvent(HttpEntity<Event> request) {
        // repository save event
        return ResponseEntity.ok(request.getBody());
    }

    @ExceptionHandler/* (Exception1.class, Exception2.class) */
    public ResponseEntity eventErrorHandler(Exception exception, Model model) {
        model.addAttribute("message", "event error");
        return ResponseEntity.badRequest().body("event error because ...");
    }

}
