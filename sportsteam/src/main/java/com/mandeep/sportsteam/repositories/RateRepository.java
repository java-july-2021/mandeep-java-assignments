package com.mandeep.sportsteam.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.mandeep.sportsteam.models.Rate;

@Repository
public interface RateRepository extends CrudRepository<Rate, Long> {

	 
}
