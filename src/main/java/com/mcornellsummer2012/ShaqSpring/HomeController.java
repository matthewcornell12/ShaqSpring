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
	
	/* Maps the address "/" to the proper view
	 * 
	 * @param Model model for the object to be taken from the form
	 * @String name of the HTML view to be used for the submission Form
	 */
	@GetMapping(value = "/")
	public static String playerForm(Model model) {
		model.addAttribute("submission", new FormSubmission());
		return "PlayerForm";
	}
	
	
	/*Handles 
	 * 
	 */
	@RequestMapping(value = "/result")
	public static String displayRes(@ModelAttribute FormSubmission submission, Model model) {
		
		//Needed to find path
		Searcher searcher = new Searcher();
		
		//needed for Player Info
		RosterParser parser = new RosterParser();
		
		//Get the names submitted from the phone
		String p1 = submission.getPlayer1().toLowerCase();
		String p2 = submission.getPlayer2().toLowerCase();
		
		//Get the path
		ArrayList<String> path = null;
		try {
			path = searcher.drawPath(p1, p2);
		} catch (NullPointerException e) {
			System.out.println(e);
			path = searcher.drawPath("stephen curry", "jerry west");
		}
		
		//Model to pass into the view
		PathModel pathModel = new PathModel();
		
		//Add Each player and info to the Model
		for (String p : path) {
			Player newPlayer = new Player();
			
			newPlayer.setName(capName(p));
			newPlayer.setUrl(parser.getProfilePic(p));
			newPlayer.setBio(toParagraph(parser.getPlayerDescripiton(p)));
			
			
			pathModel.addPlayer(newPlayer);
		}
	
		
		model.addAttribute("mod", pathModel);
		return "Submitted";
	}
	
	
	/* Converts and strips Player Bio
	 * @Param String the entire biography
	 * @return String the stripped string
	 */
	private static String toParagraph(String s) {
		int counter = 0;
		s = s.replaceAll("More bio, uniform, draft, salary info", "");
		StringBuilder string = new StringBuilder(s);
		for (int i = 0; i < s.length(); i++) {
			if (counter < 45) {
				++counter;
			} else if (string.charAt(i) == ' ') {
				string.setCharAt(i, '\n');
				counter = 0;
			} else {
				continue;
			}
		}
		
		return string.toString();
	}
	
	
	/*
	 * Helper Function to Properly Capitalize names
	 * @param String the name
	 * @return String the capitalized name
	 */
	private static String capName(String name) {
		StringBuilder capped = new StringBuilder(name);
		
		capped.setCharAt(0, Character.toUpperCase(name.charAt(0)));
		
		for (int i = 1; i < name.length(); i++) {
			if (capped.charAt(i) == ' ') {
				capped.setCharAt(i + 1, Character.toUpperCase(capped.charAt(i + 1)));
			}
		}
		
		return capped.toString();
		
	}
}
