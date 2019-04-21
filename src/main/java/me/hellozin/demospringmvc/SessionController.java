package me.hellozin.demospringmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"visitor","message"})
public class SessionController {

    @GetMapping("/login")
    public String loginForm(Visitor visitor, String message) {
        return "login";
    }

    @PostMapping("/login")
    public String login(Visitor visitor) {
        return "redirect:/main";
    }

    @GetMapping("/main")
    public String main() {
        return "main";
    }

}
