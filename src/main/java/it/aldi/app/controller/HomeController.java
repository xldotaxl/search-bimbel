package it.aldi.app.controller;

import it.aldi.app.service.ProvinceService;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/")
public class HomeController {

    private static final String HOME_VIEW = "home/home";

    private final @NonNull ProvinceService provinceService;

    public HomeController(ProvinceService provinceService) {
        this.provinceService = provinceService;
    }

    /**
     * Show home page.
     */
    @GetMapping
    public String index(Model model) {

        model.addAttribute("provinces", provinceService.findAll());
        return HOME_VIEW;
    }
}
