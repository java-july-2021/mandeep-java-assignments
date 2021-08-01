
package com.mandeep.languages.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mandeep.languages.models.language;

public interface LanguagesRepository extends CrudRepository<language, Long>{
	List<language> findAll();
}
