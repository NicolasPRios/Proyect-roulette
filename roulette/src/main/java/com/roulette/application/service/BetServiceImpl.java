package com.roulette.application.service;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.roulette.application.dto.BetDTO;
import com.roulette.application.dto.ResponseBetDTO;
import com.roulette.application.dto.ResponseDTO;
import com.roulette.application.dto.WinnerUserDTO;
import com.roulette.application.iservice.BetServiceInterface;
import com.roulette.application.model.Bet;
import com.roulette.application.model.Roulette;
import com.roulette.application.repository.RouletteRepository;
import com.roulette.application.util.RouletteConstants;
import com.roulette.application.util.RuleValidation;

/**
 * This class Allow bet operations
 * @author Nicolas Palacios Rios
 * @version 1.0
 */
@Service
public class BetServiceImpl implements BetServiceInterface {
	@Autowired
	RouletteRepository rouletteRepository;
	@Autowired
	HttpServletRequest requestHeader;
	@Autowired
	ObjectMapper objectMapper;

	@Override
	public ResponseDTO createBet(BetDTO betDto) {
		ResponseDTO response = new ResponseDTO();
		Optional<Roulette> rouletteObject = rouletteRepository.findById(betDto.getRouletteId());
		betDto.setUserCode(requestHeader.getHeader("userCode"));
		if (rouletteObject.isPresent()) {
			Roulette roulette = rouletteObject.get();
			if (roulette.getStatus().equalsIgnoreCase(RouletteConstants.CONSTANT_OPEN) && RuleValidation.moneyAmountValidation(betDto)) {
				if (!RuleValidation.validateNumberAndColor(betDto)) {
					response = setMessageAndCode(400, RouletteConstants.MESSAGE_VALIDATE_NUMBER_AND_COLOR_SERVICE);
				} else {
					Bet bet = objectMapper.convertValue(betDto, Bet.class);
					roulette.betSave(bet);
					rouletteRepository.save(roulette);
					response = setMessageAndCode(200, RouletteConstants.MESSAGE_CREATE_BET_CORRECT);
				}
			}else {
				response = setMessageAndCode(400, RouletteConstants.MESSAGE_CLOSE_BET);
			}
		} else {
			response = setMessageAndCode(404, RouletteConstants.MESSAGE_ROULETTE_NOT_FOUNT);
		}

		return response;
	}

	@Override
	public ResponseBetDTO closeBets(Long idRoulette) {
		ResponseBetDTO response = new ResponseBetDTO();
		Optional<Roulette> rouletteObject = rouletteRepository.findById(idRoulette);
		Roulette roulette = new Roulette();
		if (rouletteObject.isPresent()) {
			roulette = rouletteObject.get();
			roulette.setStatus("close");
			rouletteRepository.save(roulette);
			List<BetDTO> betList = objectMapper.convertValue(roulette.getBets(), new TypeReference<List<BetDTO>>() {
			});
			response = betWinner(betList);
			response.setCode(200);
			response.setMessage(RouletteConstants.MESSAGE_CLOSE_ROULETTE_CORRECT);
			response.setBetList(betList);

			return response;
		}
		response.setCode(404);
		response.setMessage(RouletteConstants.MESSAGE_ROULETTE_NOT_FOUNT);

		return response;
	}

	private ResponseBetDTO betWinner(List<BetDTO> betList) {
		ResponseBetDTO response = new ResponseBetDTO();
		WinnerUserDTO winnerUserDTO = null;
		Long numberWinner = (long) (Math.random() * 36);
		response.setWinnerBetNumber(numberWinner);
		for (int i = 0; i < betList.size(); i++) {
			if (betList.get(i).getBetnumber() != null && betList.get(i).getBetnumber() == numberWinner) {
				winnerUserDTO = new WinnerUserDTO(betList.get(i).getAmountMoney() * 5.0, betList.get(i).getUserCode());
				response.addWinner(winnerUserDTO);
			}
			if (betList.get(i).getBetColor() != null) {
				if (numberWinner % 2 == 0 && betList.get(i).getBetColor().equalsIgnoreCase(RouletteConstants.CONSTANT_RED)) {
					response.setWinnerBetColor(RouletteConstants.CONSTANT_RED);
					winnerUserDTO = new WinnerUserDTO(betList.get(i).getAmountMoney() * 1.8,
							betList.get(i).getUserCode());
					response.addWinner(winnerUserDTO);
				} else if (numberWinner % 2 != 0 && betList.get(i).getBetColor().equalsIgnoreCase(RouletteConstants.CONSTANT_BLACK)) {
					response.setWinnerBetColor(RouletteConstants.CONSTANT_BLACK);
					winnerUserDTO = new WinnerUserDTO(betList.get(i).getAmountMoney() * 1.8,
							betList.get(i).getUserCode());
					response.addWinner(winnerUserDTO);
				}
			}
		}

		return response;
	}
	
	private ResponseDTO setMessageAndCode(int code, String message) {
		ResponseDTO response = new ResponseDTO();
		response.setCode(code);
		response.setMessage(message);
		
		return response;
	}

}
