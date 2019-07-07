package it.aldi.app.controller.rest.dto.response;

import it.aldi.app.domain.BimbelUser;
import lombok.Value;

import java.util.Arrays;
import java.util.List;

@Value
public class StudentDto {
    private Long id;
    private String name;
    private String email;
    private String username;
    private List<String> subjects;

    private StudentDto(BimbelUser bimbelUser) {
        id = bimbelUser.getId();
        name = bimbelUser.getName();
        email = bimbelUser.getEmail();
        username = bimbelUser.getUsername();
        // TODO: get subject from entity relation
        subjects = Arrays.asList("Kimia", "Biologi");
    }

    public static StudentDto valueOf(BimbelUser bimbelUser) {
        return new StudentDto(bimbelUser);
    }
}
