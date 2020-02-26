package osmanforhad.net;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	@Autowired
private ProductRepositroy repo;

	public List<Product> listAll(){
		
		return repo.findAll();
		
	}//end of the listAll method
	
	public void save(Product product) {
		repo.save(product);
	}//end of the save method
	
	public Product get(Long id) {
		return repo.findById(id).get();
	}//end of the Product get method
	
	public void delete(Long id) {
		repo.deleteById(id);
	}//end of the delete method

}//end of the class
