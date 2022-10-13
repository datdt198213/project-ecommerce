package com.dangdat.ecommerce.product;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    @Query(value = "SELECT p.* FROM product p " +
            "WHERE cate_id = :cateId", nativeQuery = true)
    List<Product> findByCategory(@Param("cateId") String cateId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE product p SET p.status = 0, p.deletedAt = current_date WHERE id = :id")
    void disableProduct(@Param("id") String id);
}
