package com.klu;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

	
	List<Product> findByCategory(String category);
	
	
	
	 List<Product> findByCategoryAndPriceGreaterThan(String category,double price);


	 List<Product> findByPriceBetween(long min, long max);
	 
	 
	    List<Product> findByNameLike(String pattern);

	   
	    List<Product> findByPriceGreaterThan(double price);
	    
	    long countByCategory(String category);
	    
	    Optional<Product> findByName(String name);

}

