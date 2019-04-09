package it.aldi.app.controller;

import it.aldi.app.controller.dto.BimbelUserDto;
import it.aldi.app.domain.BimbelUser;
import it.aldi.app.service.BimbelUserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class RegisterController {

    private final @NonNull BimbelUserService bimbelUserService;

    @GetMapping(Routes.REGISTER)
    public String viewRegisterPage() {
        return "register/register";
    }

    @PostMapping(Routes.REGISTER)
    public String postRegister(@ModelAttribute BimbelUserDto bimbelUserDto, BindingResult bindingResult) {
        log.info("post request coming");
        if (bindingResult.hasErrors()) {
            log.error("There's error occured when user input form");
            return Routes.REGISTER;
        }

        BimbelUser bimbelUser = BimbelUser.from(bimbelUserDto);
        bimbelUserService.save(bimbelUser);
        return "redirect:" + Routes.INDEX;
    }
}
