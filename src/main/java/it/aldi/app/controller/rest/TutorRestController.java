package it.aldi.app.controller.rest;

import it.aldi.app.controller.Routes;
import it.aldi.app.controller.rest.dto.response.TutorDto;
import it.aldi.app.service.user_management.UserManagementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(Routes.API_TUTORS)
public class TutorRestController {

    private final UserManagementService userManagementService;

    public TutorRestController(UserManagementService userManagementService) {
        this.userManagementService = userManagementService;
    }

    @GetMapping("/{orgId}")
    public ResponseEntity<List<TutorDto>> getTutorsByOrgId(@PathVariable("orgId") Long id) {
        return new ResponseEntity<>(userManagementService.getTutors(id), HttpStatus.OK);
    }
}
