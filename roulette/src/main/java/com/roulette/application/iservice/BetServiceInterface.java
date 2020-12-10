package com.roulette.application.iservice;

import com.roulette.application.dto.BetDTO;
import com.roulette.application.dto.ResponseBetDTO;
import com.roulette.application.dto.ResponseDTO;

/**
 * Interface with all operations over bets 
 * @author Nicolas Palacios Rios
 * @version 1.0
 *
 */
public interface BetServiceInterface {

	public ResponseDTO createBet(BetDTO betDto);
	public ResponseBetDTO closeBets(Long idRoulette);

}
