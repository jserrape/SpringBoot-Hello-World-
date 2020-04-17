package com.example.controllers;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.restservice.Greeting;

/**
 * Example controller class to test stupid things
 * @author jserrape
 *
 */
@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
	@GetMapping("/listGreetings")
	public ArrayList<Greeting> greeting() {
		Greeting gr1, gr2, gr3;
		gr1 = new Greeting(counter.incrementAndGet(),"a");
		gr2 = new Greeting(counter.incrementAndGet(),"b");
		gr3 = new Greeting(counter.incrementAndGet(),"c");
		ArrayList<Greeting> greetings = new ArrayList<>();
		greetings.add(gr1);
		greetings.add(gr2);
		greetings.add(gr3);
		return greetings;
	}
}