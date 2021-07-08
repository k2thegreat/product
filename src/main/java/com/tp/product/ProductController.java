package com.tp.product;

import java.applet.AppletContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tp.dao.ProductRepository;
import com.tp.dao.model.Product;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)

    public String getProductList() {
        Product p = new Product();
        p.setId(1);
        p.setName("Product1");
        p.setPrice("Rs400");
        productRepository.save(p);
        return Arrays.toString(new String[]{"Product 1", "Product 2"});
    }

    @GetMapping(value = "/allProducts", produces = MediaType.APPLICATION_JSON_VALUE)

    public String getProductsList() {
        List<Product> list = new ArrayList<Product>();
        productRepository.findAll().forEach(p -> list.add(p));

//        return Arrays.toString(new String[]{"Product 1", "Product 2"});
        return list.toString();
    }

    @GetMapping("/{prodId}")
    public Product getProduct(@PathVariable("prodId") int prodId) {
        return productRepository.findById(prodId).map(p -> {
            return p;
        }).orElse(null);
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product prod) {
        return productRepository.save(prod);
    }

}
