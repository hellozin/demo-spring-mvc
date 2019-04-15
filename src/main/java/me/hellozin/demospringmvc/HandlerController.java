package me.hellozin.demospringmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
//    public Event getEventWithParam(@RequestParam(required = false, defaultValue = "hello") String name) {
    public String getEventWithParam(
            @Validated
//            @Validated(Event.ValidateLimit.class) /* Group 지정 가능, 필수 아님 */
            @ModelAttribute Event event,
            BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            return "/events/form";
//            bindingResult.getAllErrors().forEach(c-> System.out.println(c.toString()));
        } /* Binding Error를 가져와 준다. */

        List<Event> eventList = new ArrayList<>();
        eventList.add(event);
        model.addAttribute("eventList", eventList);

        return "redirect:/events/list";
    }

    @GetMapping("/events/list")
    public String getEvents(Model model) {
        Event event = new Event();
        event.setName("sample");
        event.setLimit(10);
        List<Event> eventList = new ArrayList<>();
        eventList.add(event);
        model.addAttribute("eventList", eventList);
        return "/events/list";
    }

}
