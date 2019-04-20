package me.hellozin.demospringmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("visitor")
public class SessionController {

    private int count = 0;

    @GetMapping("/session")
    public String cookie(Model model) {
        if (!model.containsAttribute("visitor")) {
            String visitor = "hellozin" + (count++);
            model.addAttribute("visitor", visitor);
        }
        return "session";
    }

}
