package demo.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/")
public class AppRestController {

	@RequestMapping("/demo")
	public String demo() {
		return "rest: " + String.valueOf(System.currentTimeMillis());
	}
	
}
