package osmanforhad.net;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
	
	
	/**
	 * Writing method to going to
	 * edit existing data
	 * 
	 * @PathVariable
	 * annotation
	 * 
	 * @param id
	 * Long id
	 * */
	@RequestMapping("/edit/{id}") //mapping the url name
	public ModelAndView showEditProductForm(@PathVariable(name = "id") Long id) {
		/**
		 * create new object
		 * edit_product
		 * name as mav
		 * */
		ModelAndView mav = new ModelAndView("edit_product");
		/**
		 * catch the details of
		 * selective product by
		 * id
		 * */
		Product product = service.get(id);
		mav.addObject("product", product);
		return mav; //return model and view object
		
	}//end of the showEditProductForm method 
	
	/**
	 * Writing method for 
	 * delete data from Database
	 * @PathVariable
	 * annotation
	 * 
	 * @param id 
	 * Long id
	 * */
	@RequestMapping("/delete/{id}") // mapping the url name
	public String deleteProduct(@PathVariable(name = "id") Long id) {
		service.delete(id);
		
		return "redirect:/"; //return redirect to index url
		
	}//end of the deleteProduct method
	
}//end of the class
