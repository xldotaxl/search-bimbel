package it.aldi.app.controller.dto;

import it.aldi.app.util.RegexConstant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BimbelUserDto {

    @NotNull
    @Size(min = 6)
    @Pattern(regexp = "^[a-zA-Z]+[a-zA-Z.]*[a-zA-Z]+$",
        message = "Username should only contain alphabet (may separated by dot(.)")
    private String username;

    @NotNull
    @Pattern(regexp = "^[a-z A-Z]*$", message = "Name should only contain alphabet")
    private String name;

    @NotNull
    @Size(min = 6, message = "Password length should be at least six characters")
    private String password;

    @NotNull
    @Pattern(regexp = RegexConstant.EMAIL_REGEX)
    private String email;
}
