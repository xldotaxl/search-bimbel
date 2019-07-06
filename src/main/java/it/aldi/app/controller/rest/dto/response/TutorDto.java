package it.aldi.app.controller.rest.dto.response;

import it.aldi.app.domain.BimbelUser;
import lombok.Value;

import java.util.Arrays;
import java.util.List;

@Value
public class TutorDto {
    private Long id;
    private String name;
    private String email;
    private String username;
    private List<String> subjects;

    public TutorDto(BimbelUser bimbelUser) {
        id = bimbelUser.getId();
        name = bimbelUser.getName();
        email = bimbelUser.getEmail();
        username = bimbelUser.getEmail();
        // TODO: get subject from entity relation
        subjects = Arrays.asList("Matematika", "Fisika");
    }

    public static TutorDto valueOf(BimbelUser bimbelUser) {
        return new TutorDto(bimbelUser);
    }
}
