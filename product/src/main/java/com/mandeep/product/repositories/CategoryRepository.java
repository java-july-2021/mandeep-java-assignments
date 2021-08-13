package com.mandeep.product.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mandeep.product.models.Category;
import com.mandeep.product.models.Product;
@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{
	List<Category> findAll();
	List<Category> findByProductsNotContains(Product product);
}
