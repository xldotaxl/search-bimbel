package it.aldi.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

	private final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Show home page.
     */
	@GetMapping
	public String index() {
		logger.info("Showing home page");

		return "home/home";
	}
}
