package com.dangdat.ecommerce;

import com.dangdat.ecommerce.category.CategoryService;
import com.dangdat.ecommerce.product.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//public class EcommerceApplication implements CommandLineRunner {
public class EcommerceApplication {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private ProductService productService;
	private CategoryService categoryService;

	@Autowired
	public EcommerceApplication(ProductService productService, CategoryService categoryService) {
		this.productService = productService;
		this.categoryService = categoryService;
	}

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

/*	@Override
	public void run(String... args) throws Exception {
		logger.info("All product -> {}", productService.getAll());
		logger.info("All category -> {}", categoryService.getAll());
	}*/
}
