package com.mcornellsummer2012.ShaqSpring;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ShaqSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShaqSpringApplication.class, args);
	}
	
	@GetMapping("/shaq")
	public String hello (@RequestParam(value = "player1", defaultValue = "Stephen Curry") String p1, @RequestParam(value = "player2", defaultValue = "Shaquille Oneal") String p2) {
		Searcher searcher = new Searcher();
		if (p1 == "" || p1 == null) {
			p1 = "stephen curry";
		}
		if (p2 == "" || p2 == null) {
			p2 = "shaquille oneal";
		}
		
		ArrayList<String> path = searcher.drawPath(p1, p2);
		
		String pathString = String.join(" ---> ", path);
		
		return String.format("The Path is \n %s", pathString);
	}

}
