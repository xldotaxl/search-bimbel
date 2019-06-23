package it.aldi.app.controller.rest.dto.response;

import lombok.Value;

@Value
public class TutorDto {
    private String name;
    private String email;

    private TutorDto(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public static TutorDto valueOf(String name, String email) {
        return new TutorDto(name, email);
    }
}
