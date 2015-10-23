package edu.asu.diging.lerna.herckules.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping(value = "/auth/home")
	public String home(Model model) {
		return "home";
	}
}
