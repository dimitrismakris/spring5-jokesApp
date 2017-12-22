package com.jokes.controllers;

import com.jokes.services.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by dimitris on 22/12/2017.
 */
@Controller
public class JokeController {

    private JokeService jokeService;

    @Autowired
    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    // Map context root ("/", "") to Jokes view
    @RequestMapping({"/", ""})
    public String showJoke(Model model){
        // Add random Joke text to "joke" propery of model
        model.addAttribute("joke", jokeService.getJoke());

        // Return view name of "chucknorris"
        return "chucknorris";
    }
}
