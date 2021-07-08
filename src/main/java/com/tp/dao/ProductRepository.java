package com.tp.dao;

import org.springframework.data.repository.CrudRepository;

import com.tp.dao.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
