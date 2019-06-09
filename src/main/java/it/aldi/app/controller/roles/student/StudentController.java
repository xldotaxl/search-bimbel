package it.aldi.app.controller.roles.student;

import it.aldi.app.controller.Routes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping(Routes.STUDENT_HOME)
public class StudentController {

    private static final String STUDENT_HOME_VIEW = "student/student";

    @GetMapping
    public String studentDashboard(Model model) {
        log.debug("Entering student's home");
        return STUDENT_HOME_VIEW;
    }

}
