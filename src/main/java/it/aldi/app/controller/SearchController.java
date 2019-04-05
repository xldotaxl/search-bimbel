package it.aldi.app.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class SearchController {

    @GetMapping("/search")
    public String getSearch() {
        log.info("Showing search result page");
        return "search/search";
    }
}
