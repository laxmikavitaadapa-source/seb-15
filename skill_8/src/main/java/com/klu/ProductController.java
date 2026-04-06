package com.klu;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klu.exception.ProductNotFoundException;

@RestController
@CrossOrigin
@RequestMapping("/products")
public class ProductController {
	
	  @Autowired
	  ProductRepo repo;
	 
	  
	  @GetMapping("/category/{category}")
	  public List<Product> displaybycategory(@PathVariable String category){
	    return repo.findByCategory(category);

	  }
	  @GetMapping("category/{category}/price/{price}")
	  public List<Product> displaybycategoryprice(
	      @PathVariable String category,
	      @PathVariable double price){
	    
	    return repo.findByCategoryAndPriceGreaterThan(category, price);
	    
	    }
	  
	//displaybyminmax
	  @GetMapping("/filter")
	  public List<Product> priceminmax(
	      @RequestParam long min,
	      @RequestParam long max){
	    
	    return repo.findByPriceBetween(min, max);
	    
	    
	    
	  }
	    // Like
	    @GetMapping("/search")
	    public List<Product> like(@RequestParam String keyword) {
	        return repo.findByNameLike("%" + keyword + "%");
	    }

	    // GreaterThan
	    @GetMapping("/expensive/{price}")
	    public List<Product> greaterThan(@PathVariable double price) {
	        return repo.findByPriceGreaterThan(price);
	    }
	    
	 // countBy
	    @GetMapping("/count/{category}")
	    public long count(@PathVariable String category) {
	        return repo.countByCategory(category);
	    }
	    
	  //Add the following code to the existing program.

	    @GetMapping("/name/{name}")
	    public Product byName(@PathVariable String name) {
	        return repo.findByName(name)
	                .orElseThrow(() ->
	                        new ProductNotFoundException("Product with name '" + name + "' not found"));
	    }



}





