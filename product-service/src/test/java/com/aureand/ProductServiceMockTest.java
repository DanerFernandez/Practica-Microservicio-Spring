package com.aureand;

import com.aureand.entity.Category;
import com.aureand.entity.Product;
import com.aureand.repository.ProductRepository;
import com.aureand.service.ProductService;
import com.aureand.service.ProductServiceImpl;
import java.util.Date;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductServiceMockTest {
    
    @Mock
    private ProductRepository productRepository;
    
    private ProductService productService;
    
    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
        productService = new ProductServiceImpl(productRepository);
        Product computer = Product.builder()
                .id(1L)
                .name("computer")
                .category(Category.builder().id(1L).build())
                .description("This is a computer.")
                .stock(Double.parseDouble("5"))
                .price(Double.parseDouble("12.5"))
                .status("Created")
                .createAt(new Date()).build();
        
        Mockito.when(productRepository.findById(1L))
                .thenReturn(Optional.of(computer));
        
        Mockito.when(productRepository.save(computer)).thenReturn(computer);
    }
    
    @Test
    public void whenValidGetId_ThenReturnProduct(){
        Product found = productService.getProduct(1L);
        Assertions.assertThat(found.getName()).isEqualTo("computer");
    }
    
    @Test
    public void whenValidUpdateStock_ThenReturnNewStock(){
        Product newStock = productService.updateStock(1L, Double.parseDouble("8"));
        Assertions.assertThat(newStock.getStock()).isEqualTo(Double.parseDouble("13"));
    }
}
