package me.hellozin.demospringmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("/events")
    @ResponseBody
    public String getEvent(Model model) {
        Event event = (Event) model.asMap().get("newEvent");
        return event.toString();
    }

    @PostMapping("/events")
//    public Event getEventWithParam(@RequestParam(required = false, defaultValue = "hello") String name) {
    public String getEventWithParam(
            @Validated
//            @Validated(Event.ValidateLimit.class) /* Group 지정 가능, 필수 아님 */
            @ModelAttribute Event event,
            BindingResult bindingResult,
            Model model,
            RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "/events/form";
//            bindingResult.getAllErrors().forEach(c-> System.out.println(c.toString()));
        } /* Binding Error를 가져와 준다. */

        event.setId(1);
        List<Event> eventList = new ArrayList<>();
        eventList.add(event);
        model.addAttribute("eventList", eventList);

        redirectAttributes.addFlashAttribute("newEvent", event);

        return "redirect:/events";
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
