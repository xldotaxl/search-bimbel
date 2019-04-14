package it.aldi.app.controller;

import it.aldi.app.controller.dto.BimbelUserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class SigninController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SigninController.class);

    private static final String SIGN_IN_VIEW = "signin/login";

    /**
     * Sign in page.
     */
    @GetMapping(Routes.SIGNIN)
    public String signin(@ModelAttribute BimbelUserDto bimbelUserDto) {
        LOGGER.info("Showing sign in page");

        return SIGN_IN_VIEW;
    }
}
