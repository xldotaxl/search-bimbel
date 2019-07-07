package it.aldi.app.service.user_management;

import it.aldi.app.controller.rest.dto.response.StudentDto;
import it.aldi.app.controller.rest.dto.response.TutorDto;

import java.util.List;

public interface UserManagementService {
    List<TutorDto> getTutors(Long organizationId);

    List<StudentDto> getStudents(Long organizationId);
}
