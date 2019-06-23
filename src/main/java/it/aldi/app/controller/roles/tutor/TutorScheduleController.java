package it.aldi.app.controller.roles.tutor;

import it.aldi.app.controller.Routes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(Routes.TUTOR_HOME)
public class TutorScheduleController {

    private static final String TUTOR_SCHEDULE_VIEW = "tutor/schedule";

    @GetMapping("/schedule")
    public String viewSchedule() {
        return TUTOR_SCHEDULE_VIEW;
    }
}
