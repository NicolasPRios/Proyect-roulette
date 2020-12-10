package com.roulette.application.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.roulette.application.dto.ResponseDTO;
import com.roulette.application.dto.RouletteDTO;
import com.roulette.application.iservice.RouletteServiceInterface;
import com.roulette.application.model.Roulette;
import com.roulette.application.repository.RouletteRepository;
import com.roulette.application.util.RouletteConstants;

/**
 * This class Allow roulette operations
 * @author Nicolas Palacios Rios
 * @version 1.0
 *
 */
@Service
public class RouletteServiceImpl implements RouletteServiceInterface {
	@Autowired
	private RouletteRepository rouletteRepository;
	@Autowired
	ObjectMapper objectMapper;

	@Override
	public Long createRoulette() {
		Roulette roulette = new Roulette(RouletteConstants.CONSTANT_CLOSE);
		Roulette response = rouletteRepository.save(roulette);

		return response.getId();
	}

	@Override
	public ResponseDTO openRoulette(Long idRoulette) {
		ResponseDTO response = new ResponseDTO();
		Optional<Roulette> validationRoulette = rouletteRepository.findById(idRoulette);
		Roulette roulette = new Roulette();
		if (validationRoulette.isPresent()) {
			roulette = validationRoulette.get();
			roulette.setStatus("open");
			rouletteRepository.save(roulette);
			response = setMessageAndCode(200, RouletteConstants.MESSAGE_VALIDATE_OPEN_ROULETTE_CORRECT);
		} else {
			response = setMessageAndCode(400, RouletteConstants.MESSAGE_VALIDATE_OPEN_ROULETTE_INCORRECT);
		}
		
		return response;
	}

	@Override
	public List<RouletteDTO> rouletteListWithStatus() {
		List<RouletteDTO> response = new ArrayList<RouletteDTO>();
		List<Roulette> rouletteList = new ArrayList<>();
		rouletteRepository.findAll().forEach(rouletteList::add);
		response = objectMapper.convertValue(rouletteList, new TypeReference<List<RouletteDTO>>() {
		});
		
		return response;
	}
	
	private ResponseDTO setMessageAndCode(int code, String message) {
		ResponseDTO response = new ResponseDTO();
		response.setCode(code);
		response.setMessage(message);
		
		return response;
	}
}
