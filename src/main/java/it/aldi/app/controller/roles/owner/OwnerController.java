package it.aldi.app.controller.roles.owner;

import it.aldi.app.controller.Routes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping(Routes.OWNER_HOME)
public class OwnerController {

    private static final String OWNER_HOME_VIEW = "owner/owner";
    private static final String OWNER_USER_MANAGEMENT_VIEW = "owner/user_management";

    @GetMapping
    public String ownerDashboard(Model model) {
        log.debug("Entering owner's home");
        return OWNER_HOME_VIEW;
    }

    @GetMapping("/user_management")
    public String userManagementView(Model model) {
        return OWNER_USER_MANAGEMENT_VIEW;
    }
}
