package com.aureand;

import com.aureand.entity.Category;
import com.aureand.entity.Product;
import com.aureand.repository.ProductRepository;
import java.util.Date;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class ProductRepositoryMockTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void whenFindByCategory_thenReturnListProduct() {
        Product product01 = Product.builder()
                .name("computer")
                .category(Category.builder().id(1L).build())
                .description("")
                .stock(Double.parseDouble("10"))
                .price(Double.parseDouble("1240.99"))
                .status("Created")
                .createAt(new Date()).build();
        
        productRepository.save(product01);
        
        List<Product> founds = productRepository.findByCategory(product01.getCategory());
        
        Assertions.assertThat(founds.size()).isEqualTo(3);
    }
    
    @Test
    public void whenFindById_ThenReturnProduct(){
        Product producto = productRepository.findById(1L).orElse(null);
        Assertions.assertThat(producto.getName()).isEqualTo("adidas Cloudfoam Ultimate");
    }
}
