package it.aldi.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SigninController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SigninController.class);

    /**
     * Sign in page.
     */
    @RequestMapping("/signin")
    public String signin() {
        LOGGER.info("Showing sign in page");

        return "signin/login";
    }
}
