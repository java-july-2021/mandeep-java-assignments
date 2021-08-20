package com.mandeep.sportsteam.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mandeep.sportsteam.models.Player;


@Repository
public interface PlayerRepository extends CrudRepository<Player, Long>{

}
