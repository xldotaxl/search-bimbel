package it.aldi.app.controller.rest;

import it.aldi.app.controller.Routes;
import it.aldi.app.controller.rest.dto.response.StudentDto;
import it.aldi.app.service.user_management.UserManagementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(Routes.API_STUDENTS)
public class StudentRestController {

    private final UserManagementService userManagementService;

    public StudentRestController(UserManagementService userManagementService) {
        this.userManagementService = userManagementService;
    }

    @GetMapping("{/orgId}")
    public ResponseEntity<List<StudentDto>> getStudents(@PathVariable("orgId") Long id) {
        return ResponseEntity.status(HttpStatus.OK)
            .body(userManagementService.getStudents(id));
    }
}
