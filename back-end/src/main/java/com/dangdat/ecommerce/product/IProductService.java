package com.dangdat.ecommerce.product;

import com.dangdat.ecommerce.category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class IProductService implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public IProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Page<Product> getAll(Pageable pageable) {

        return productRepository.findAll(pageable);
    }

    @Override
    public List<Product> findProductWithSorting(String field) {
        return productRepository.findAll(Sort.by(Sort.Direction.ASC, field));
    }

    @Override
    public Page<Product> findProductsWithPagination(int offset, int pageSize) {
        Page<Product> products = productRepository.findAll(PageRequest.of(offset, pageSize));
        return products;
    }

    @Override
    public Page<Product> findProductsWithPaginationAndSorting(int offset, int pageSize, String field) {
        Page<Product> products = productRepository.findAll((PageRequest.of(offset, pageSize).withSort(Sort.by(field))));
        return products;
    }

    public List<Product> getProductsByCategory(String idCategory) {
        return productRepository.findByCategory(idCategory);
    }

    @Transactional
    @Override
    public void save(Product p) {
        p.setCreatedAt(new Date());
        p.setStatus(1);
        productRepository.save(p);
    }

    @Transactional
    @Override
    public void merge(Product p) {
        p.setModifiedAt(new Date());
        productRepository.save(p);
    }

    @Transactional
    @Override
    public void remove(String id) {
        productRepository.disableProduct(id);
    }

    @Override
    public void delete(String id) {
        productRepository.deleteById(id);
    }

}