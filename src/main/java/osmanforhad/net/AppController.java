package osmanforhad.net;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
	
	@Autowired
private ProductService service;
	
	@RequestMapping("/")
	public String viewHomePage() {
		
		return "index";
	}//end of the viewHomePage method
	
}//end of the class
