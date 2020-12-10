package com.roulette.application.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.roulette.application.model.Roulette;

/**
 * This interface allows basic operations on the roulette
 * @author Nicolas Palacios Rios
 * @version 1.0
 */
@Repository
public interface RouletteRepository extends CrudRepository<Roulette, Long> {

}
