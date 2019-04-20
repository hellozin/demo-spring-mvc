package me.hellozin.demospringmvc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class SessionController {
    private int count = 0;
    @GetMapping("/session")
    public String cookie(HttpSession visitor) {
        if (visitor.isNew()) {
            count++;
            visitor.setAttribute("visitor", "hellozin"+count);
        }
        return "visitor is " + visitor.getAttribute("visitor");
    }

}
