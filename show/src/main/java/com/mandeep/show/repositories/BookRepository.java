package com.mandeep.show.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mandeep.show.models.Book;

import java.util.List;



@Repository
public interface BookRepository extends CrudRepository<Book, Long>{
	List<Book> findAll();
	

}
