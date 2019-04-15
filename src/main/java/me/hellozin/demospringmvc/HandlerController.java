package me.hellozin.demospringmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class HandlerController {

    @GetMapping("/events/form")
    public String eventsForm(Model model) {
        Event newEvent = new Event();
        newEvent.setLimit(50);
        model.addAttribute("event", newEvent);
        return "events/form";
    }

    @GetMapping("/events/{id}")
    @ResponseBody
    public Event getEvent(@PathVariable Integer id) {
        Event event = new Event();
        event.setId(id);
        return event;
    }

    @PostMapping("/events")
    @ResponseBody
//    public Event getEventWithParam(@RequestParam(required = false, defaultValue = "hello") String name) {
    public Event getEventWithParam(@Validated(Event.ValidateLimit.class) /* Group 지정 가능, 필수 아님 */
                                       @ModelAttribute Event event, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(c-> System.out.println(c.toString()));
        } /* Binding Error를 가져와 준다. */
        return event;
    }



}
