package it.aldi.app.controller.roles.tutor;

import it.aldi.app.controller.Routes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping(Routes.TUTOR_HOME)
public class TutorController {

    private static final String TUTOR_HOME_VIEW = "tutor/tutor";

    @GetMapping
    public String tutorDashboard(Model model) {
        log.debug("Entering tutor's home");
        return TUTOR_HOME_VIEW;
    }
}
