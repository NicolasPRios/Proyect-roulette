package com.roulette.application.icontroller;

import java.util.List;

import com.roulette.application.dto.BetDTO;
import com.roulette.application.dto.ResponseBetDTO;
import com.roulette.application.dto.ResponseDTO;
import com.roulette.application.dto.RouletteDTO;
import com.roulette.application.model.Roulette;

/**
 * This interface is for the roulette controller
 * @author Nicolas Palacios Rios
 * @version 1.0
 *
 */
public interface IRouletteController {

	public Long createRoulette();
	public ResponseDTO openRoulette(Long idRoulette);
	public ResponseDTO createBet(BetDTO betDto);
	public ResponseBetDTO closeRoulette(Long idRoulette);
	public List<RouletteDTO> rouletteListWithStatus();
	
}
