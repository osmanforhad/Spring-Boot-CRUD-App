package osmanforhad.net;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AppController {
	
	@Autowired
private ProductService service;
	
	/**
	 * Writing method for going to
	 * index URL
	 * */
	@RequestMapping("/") //mapping the url name
	public String viewHomePage(Model model) {
		List<Product> listProducts = service.listAll();
		model.addAttribute("listProducts", listProducts);
		return "index";//return tragated page
	}//end of the viewHomePage method
	
	/**
	 * Writing method for going to
	 * new URl
	 * */
	@RequestMapping("/new") //mapping the url name
	public String showNewProductForm(Model model) {
		/**
		 * create new empty object
		 *  name as product
		 *  */
		Product product = new Product();
		/**
		 * adding the object
		 * product
		 * with model attribute
		 *  */
		model.addAttribute("product", product);
		return "new_product"; //retrun tragated page 
		
	}//end of the showNewProductForm method
	
	/**
	 * Writing method for 
	 * save data into Database
	 * 
	 * @ModelAttribute 
	 * annotation
	 * 
	 * object Product
	 * */
	@RequestMapping(value = "/save", method = RequestMethod.POST)//mapping the url and define method for upload data
	public String saveProduct(@ModelAttribute("product") Product product) {
		service.save(product);
		
		return "redirect:/"; // return redirect to index url
	}//end of the saveProduct method
	
}//end of the class
