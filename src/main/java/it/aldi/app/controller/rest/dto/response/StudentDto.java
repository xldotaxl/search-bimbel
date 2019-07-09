package it.aldi.app.controller.rest.dto.response;

import it.aldi.app.domain.BimbelUser;
import it.aldi.app.domain.Role;
import lombok.Value;

import java.util.Arrays;
import java.util.List;

@Value
public class StudentDto {
    private String name;
    private String email;
    private String username;
    private String role;

    private StudentDto(BimbelUser bimbelUser) {
        name = bimbelUser.getName();
        email = bimbelUser.getEmail();
        username = bimbelUser.getUsername();
        role = "Student";
    }

    public static StudentDto valueOf(BimbelUser bimbelUser) {
        return new StudentDto(bimbelUser);
    }
}
