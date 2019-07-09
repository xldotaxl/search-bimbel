package it.aldi.app.controller;

import it.aldi.app.controller.dto.SearchBimbelDto;
import it.aldi.app.security.util.SecurityUtil;
import it.aldi.app.service.ProvinceService;
import it.aldi.app.util.SessionAttrConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Set;

import static it.aldi.app.util.ControllerConstant.redirect;

@Slf4j
@Controller
@RequestMapping(Routes.INDEX)
public class HomeController {

    private static final String HOME_VIEW = "home/home";

    private final ProvinceService provinceService;

    public HomeController(ProvinceService provinceService) {
        this.provinceService = provinceService;
    }

    /**
     * Show home page.
     */
    @GetMapping
    public String index(Model model, Authentication authentication) {

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>(authentication.getAuthorities());
        String redirectUrl = SecurityUtil.getTargetUrlBasedOnRole(grantedAuthorities);

        return redirect() + redirectUrl;
    }

    @PostMapping
    public String searchResult(@ModelAttribute SearchBimbelDto searchBimbelDto, HttpSession session,
                               RedirectAttributes redirectAttributes, SessionStatus sessionStatus) {

        // TODO: redirect to search-result page
        log.info("post reqs attr: {} = {}", SessionAttrConstant.getSearchQuery(), searchBimbelDto);
        return redirect() + Routes.INDEX;
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("provinces", provinceService.findAll());
        model.addAttribute(new SearchBimbelDto());
        return HOME_VIEW;
    }
}
