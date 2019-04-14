package it.aldi.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    private final Logger logger = LoggerFactory.getLogger(HomeController.class);

    private static final String HOME_VIEW = "home/home";

    /**
     * Show home page.
     */
    @GetMapping
    public String index() {
        return HOME_VIEW;
    }
}
