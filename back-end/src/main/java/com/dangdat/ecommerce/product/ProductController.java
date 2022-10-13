package com.dangdat.ecommerce.product;

import com.dangdat.ecommerce.dto.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ApiResponse<List<Product>> getProducts() {
        List<Product> allProducts = productService.getAll();
        return new ApiResponse<>(allProducts.size(), allProducts);
    }

    @GetMapping("/{field}")
    public ApiResponse<List<Product>> getProductsWithSort(@PathVariable String field) {
        List<Product> allProducts = productService.findProductWithSorting(field);
        return new ApiResponse<>(allProducts.size(), allProducts);
    }

    // http://localhost:8080/api/v1/products/pagination/0/5
    @GetMapping("/pagination/{offset}/{pageSize}")
    public ApiResponse<Page<Product>> getProductsWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
        Page<Product> productsWithPagination = productService.findProductsWithPagination(offset, pageSize);
        return new ApiResponse<>(productsWithPagination.getSize(), productsWithPagination);
    }

    // http://localhost:8080/api/v1/products/paginationAndSort/0/5/name
    @GetMapping("/paginationAndSort/{offset}/{pageSize}/{field}")
    public ApiResponse<Page<Product>> getProductsWithPaginationAndSorting(@PathVariable int offset, @PathVariable int pageSize, @PathVariable String field) {
        Page<Product> products = productService.findProductsWithPaginationAndSorting(offset, pageSize, field);
        return new ApiResponse<>(products.getSize(), products);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody Product product) {
        productService.save(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Void> merge(@RequestBody Product product) {
        productService.merge(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/remove/{id}")
    public void remove(@PathVariable String id) {
        productService.remove(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        productService.delete(id);
    }
}
