package com.mcornellsummer2012.ShaqSpring;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@GetMapping(value = "/")
	public static String playerForm(Model model) {
		model.addAttribute("submission", new FormSubmission());
		return "PlayerForm";
	}
	
	@RequestMapping(value = "/result")
	public static String displayRes(@ModelAttribute FormSubmission submission, Model model) {
		Searcher searcher = new Searcher();
		
		String p1 = submission.getPlayer1().toLowerCase();
		String p2 = submission.getPlayer2().toLowerCase();
		
		ArrayList<String> path = searcher.drawPath(p1, p2);
		String pathString = String.join(" ---> ", path);
		PathModel pathModel = new PathModel();
		pathModel.setPath(pathString);
		
		model.addAttribute("mod", pathModel);
		return "Submitted";
	}
}
