package peaksoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * project : SpringMVC-CRUD
 */
@Controller
@RequestMapping("/")
public class WelcomeController {

    @GetMapping
    public String showWelcomePage() {
        return "welcome";
    }

}
