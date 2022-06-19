package web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Web {
	
	@RequestMapping("/god of cricket")
	public String sayWorld() {
		return "<h2> welcome SACHIN </H2>";
		
	}

}
