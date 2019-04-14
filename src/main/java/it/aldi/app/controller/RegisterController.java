package it.aldi.app.controller;

import it.aldi.app.controller.dto.BimbelUserDto;
import it.aldi.app.service.register.RegisterService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

import static it.aldi.app.util.ControllerConstant.redirect;

@Slf4j
@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RegisterController {

    private static final String REGISTER_VIEW = "register/register";

    private final @NonNull RegisterService registerService;

    @GetMapping(Routes.REGISTER)
    public String viewRegisterPage(Model model) {
        model.addAttribute(new BimbelUserDto());
        model.addAttribute("roleList", registerService.getRolesList());
        return REGISTER_VIEW;
    }

    @PostMapping(Routes.REGISTER)
    public ModelAndView postRegister(@Valid @ModelAttribute BimbelUserDto bimbelUserDto, BindingResult bindingResult) {
        log.debug("Registering user: {}", bimbelUserDto);

        if (bindingResult.hasErrors()) {
            return wrongInputModelView(bimbelUserDto);
        }

        String errorMsg = registerService.verifyExistingData(bimbelUserDto);
        if (!errorMsg.isEmpty()) {
            return dataExistsModelView(bindingResult, errorMsg);
        }

        registerService.registerUser(bimbelUserDto);

        return new ModelAndView(redirect() + Routes.SIGNIN);
    }

    private static ModelAndView dataExistsModelView(BindingResult bindingResult, String errorMsg) {
        log.warn("Failed registration, cause: {}", errorMsg);
        bindingResult.reject(errorMsg);
        return new ModelAndView(REGISTER_VIEW, "errMsg", errorMsg);
    }

    private static ModelAndView wrongInputModelView(@ModelAttribute @Valid BimbelUserDto bimbelUserDto) {
        log.warn("There's an error occured when user register");
        return new ModelAndView(REGISTER_VIEW, "bimbelUserDto", bimbelUserDto);
    }
}
