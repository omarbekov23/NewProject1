package peaksoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * created by Beksultan Mamatkadyr uulu
 * project : SpringMVC-CRUD
 * 1/11/21
 * Monday 22:19
 */
@Controller
@RequestMapping("/")
public class WelcomeController {

    @GetMapping
    public String showWelcomePage() {
        return "welcome";
    }

}
