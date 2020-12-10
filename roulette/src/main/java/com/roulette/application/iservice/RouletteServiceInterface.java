package com.roulette.application.iservice;

import java.util.List;

import com.roulette.application.dto.ResponseDTO;
import com.roulette.application.dto.RouletteDTO;

/**
 * Interface with all operations over roulletes
 * @author Nicolas Palacios Rios
 * @version 1.0
 *
 */
public interface RouletteServiceInterface {

	public Long createRoulette();
	public ResponseDTO openRoulette(Long idRoulette);
	public List<RouletteDTO> rouletteListWithStatus();

}
