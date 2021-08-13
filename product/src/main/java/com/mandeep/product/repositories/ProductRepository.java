package com.mandeep.product.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mandeep.product.models.Category;
import com.mandeep.product.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	List<Product> findAll();
	List<Product> findByCategoriesNotContains(Category category);
}
