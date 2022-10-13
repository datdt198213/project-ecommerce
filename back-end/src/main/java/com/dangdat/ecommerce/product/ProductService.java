package com.dangdat.ecommerce.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAll();

    Page<Product> getAll(Pageable pageable);

    List<Product> findProductWithSorting(String field);

    Page<Product> findProductsWithPagination(int offset, int pageSize);
    Page<Product> findProductsWithPaginationAndSorting(int offset, int pageSize, String field);
    void save(Product p);

    void merge(Product p);

    void remove(String id);

    void delete(String id);
}
