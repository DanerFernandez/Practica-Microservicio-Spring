package com.aureand.repository;

import com.aureand.entity.Category;
import com.aureand.entity.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
    
   public List<Product> findByCategory(Category category);
}
