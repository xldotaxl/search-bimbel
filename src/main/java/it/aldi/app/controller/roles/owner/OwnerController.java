package it.aldi.app.controller.roles.owner;

import it.aldi.app.controller.Routes;
import it.aldi.app.domain.Organization;
import it.aldi.app.security.model.BimbelUserPrincipal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping(Routes.OWNER_HOME)
public class OwnerController {

    private static final String OWNER_HOME_VIEW = "owner/owner";
    private static final String OWNER_MANAGE_STUDENT_VIEW = "owner/manage_student";
    private static final String OWNER_MANAGE_TUTOR_VIEW = "owner/manage_tutor";

    @GetMapping
    public String ownerDashboard(Model model) {
        log.debug("Entering owner's home");
        return OWNER_HOME_VIEW;
    }

    @GetMapping("/manage_student")
    public String manageStudent(Model model, Authentication authentication) {
        BimbelUserPrincipal bimbelUserPrincipal = (BimbelUserPrincipal) authentication.getPrincipal();

        Long organizationId = bimbelUserPrincipal.getBimbelUser().getOrganizations().stream()
            .map(Organization::getId)
            .findFirst()
            .orElse(null);

        model.addAttribute("orgIds", organizationId);

        return OWNER_MANAGE_STUDENT_VIEW;
    }

    @GetMapping("/manage_tutor")
    public String manageTutor(Model model, Authentication authentication) {
        BimbelUserPrincipal bimbelUserPrincipal = (BimbelUserPrincipal) authentication.getPrincipal();

        Long organizationId = bimbelUserPrincipal.getBimbelUser().getOrganizations().stream()
            .map(Organization::getId)
            .findFirst()
            .orElse(null);

        model.addAttribute("orgIds", organizationId);

        return OWNER_MANAGE_TUTOR_VIEW;
    }
}
