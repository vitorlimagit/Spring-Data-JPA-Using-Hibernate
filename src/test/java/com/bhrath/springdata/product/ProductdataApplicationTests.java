package com.bhrath.springdata.product;

import com.bhrath.springdata.product.entities.Product;
import com.bhrath.springdata.product.repos.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductdataApplicationTests {

    @Autowired
    ProductRepository repository;


    @Test
    public void contextLoads() {
    }

    @Test
    public void testCreate() {
        Product product = new Product();
        product.setId(1);
        product.setName("Iphone");
        product.setDesc("Awsome");
        product.setPrice(1000d);

        repository.save(product);
    }

    @Test
    public void testRead() {
        Product product = repository.findById(1).get();
        assertNotNull(product);
        assertEquals("Iphone", product.getName());
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + product.getDesc());
    }

    @Test
    public void testUpdate() {
        Product product = repository.findById(1).get();
        product.setPrice(120d);
        repository.save(product);
    }

    @Test
    public void testDelete() {
        if (repository.existsById(1)) {
            repository.deleteById(1);
        }
    }

    @Test
    public void testCount() {
        System.out.println("Total Records======>>>" + repository.count());

    }

    @Test
    public void testFindByName(){
        List<Product> products = repository.findByName("IWatch");
        products.forEach(p -> System.out.println(p.getPrice()));
    }

    @Test
    public void testFindByNameAndDesc(){
        List<Product> products = repository.findByNameAndDesc("TV","From Samsung Inc");
        products.forEach(p -> System.out.println(p.getPrice()));
    }

}