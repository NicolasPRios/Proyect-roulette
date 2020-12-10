package com.roulette.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.roulette.application.dto.BetDTO;
import com.roulette.application.dto.ResponseBetDTO;
import com.roulette.application.dto.ResponseDTO;
import com.roulette.application.dto.RouletteDTO;
import com.roulette.application.icontroller.IRouletteController;
import com.roulette.application.iservice.BetServiceInterface;
import com.roulette.application.iservice.RouletteServiceInterface;
import com.roulette.application.util.RouletteConstants;
import com.roulette.application.util.RuleValidation;

/**
 * This class allow to make http requests
 * @author Nicolas Palacios Rios
 * @version 1.0
 */

@RestController
public class RouletteController implements IRouletteController {
	@Autowired
	private RouletteServiceInterface rouletteService;
	@Autowired
	private BetServiceInterface betService;

	@GetMapping(RouletteConstants.LINK_CREATE_ROULETTE)
	@Override
	public Long createRoulette() {

		return rouletteService.createRoulette();
	}

	@PutMapping(RouletteConstants.LINK_OPEN_ROULETTE)
	@Override
	public ResponseDTO openRoulette(@PathVariable("idRoulette") Long idRoulette) {

		return rouletteService.openRoulette(idRoulette);
	}

	@PostMapping(RouletteConstants.LINK_CREATE_BET)
	@Override
	public ResponseDTO createBet(@RequestBody BetDTO betDto) {
		ResponseDTO response = new ResponseDTO();
		if (RuleValidation.validateNumberAndColorController(betDto)) {
			response = betService.createBet(betDto);
		} else {
			response = setMessageAndCode(404, RouletteConstants.MESSAGE_VALIDATE_NUMBER_AND_COLOR_CONTROLLER);
		}

		return response;
	}

	@GetMapping(RouletteConstants.LINK_CLOSE_ROULETTE)
	@Override
	public ResponseBetDTO closeRoulette(@PathVariable("idRoulette") Long idRoulette) {

		return betService.closeBets(idRoulette);
	}

	@GetMapping(RouletteConstants.LINK_ROULETTE_LIST_WITH_STATUS)
	@Override
	public List<RouletteDTO> rouletteListWithStatus() {

		return rouletteService.rouletteListWithStatus();
	}

	private ResponseDTO setMessageAndCode(int code, String message) {
		ResponseDTO response = new ResponseDTO();
		response.setCode(code);
		response.setMessage(message);

		return response;
	}
}
