package com.hexaware.demo1.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/sales")
	public String sales() {
		return "sales";
	}
	@GetMapping("/marketing")
	public String marketing() {
		return "marketing";
	}
	@GetMapping("/laptops")
	public String laptops() {
		return "laptops";
	}
	@GetMapping("/tvsales")
	public String tvsales() {
		return "tvsales";
	}
	

}
