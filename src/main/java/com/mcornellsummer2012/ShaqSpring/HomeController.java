package com.mcornellsummer2012.ShaqSpring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/")
	public static String playerForm() {
		return "PlayerForm";
	}
}
