package it.aldi.app.controller;

import it.aldi.app.controller.dto.SearchBimbelDto;
import it.aldi.app.service.ProvinceService;
import it.aldi.app.util.SessionAttrConstant;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

import static it.aldi.app.util.ControllerConstant.redirect;

@Slf4j
@Controller
@RequestMapping(Routes.INDEX)
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
        model.addAttribute(new SearchBimbelDto());
        return HOME_VIEW;
    }

    @PostMapping
    public String searchResult(@ModelAttribute SearchBimbelDto searchBimbelDto, HttpSession session,
                               RedirectAttributes redirectAttributes, SessionStatus sessionStatus) {

        session.setAttribute(SessionAttrConstant.getSearchQuery(), searchBimbelDto);
        // TODO: redirect to search-result page
        log.info("post reqs attr: {} = {}", SessionAttrConstant.getSearchQuery(), searchBimbelDto);
        return redirect() + Routes.INDEX;
    }
}
