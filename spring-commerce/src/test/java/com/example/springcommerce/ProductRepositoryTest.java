package com.example.springcommerce;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.springcommerce.model.Product;
import com.example.springcommerce.repository.ProductRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void whenFindByName_thenReturnProduct() {
        // given
        Product product = new Product();
        product.setId(1);
        entityManager.persist(product);
        entityManager.flush();

        // when
        Product found = productRepository.getById(1);

        // then
        System.out.println("Running test: whenFindByName_thenReturnProduct");
        assertThat(found.getId())
          .isEqualTo(product.getId());
    }
}
