package com.roulette.application.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.roulette.application.dto.BetDTO;
import com.roulette.application.dto.ResponseBetDTO;
import com.roulette.application.model.Roulette;
import com.roulette.application.repository.RouletteRepository;
import com.roulette.application.util.RouletteConstants;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BetServiceTest {

	@Autowired
	BetServiceImpl betServiceImpl;
	
	@MockBean
	RouletteRepository rouletteRepository;
	
	@Test
	public void createBetTest() {
		BetDTO betDto = new BetDTO();
		betDto.setRouletteId(5L);
		assertThat(betServiceImpl.createBet(betDto).getCode()).isEqualTo(404);
		Roulette roulette = new Roulette(RouletteConstants.CONSTANT_OPEN);
		roulette.setId(5L);
		Optional<Roulette> validationRoulette = Optional.of(roulette);
		when(rouletteRepository.findById(5L)).thenReturn(validationRoulette);
		assertThat(betServiceImpl.createBet(betDto).getCode()).isEqualTo(400);
		betDto.setAmountMoney(2000L);
		assertThat(betServiceImpl.createBet(betDto).getCode()).isEqualTo(400);
		betDto.setBetnumber(3L);
		roulette.setBets(new ArrayList<>());
		validationRoulette = Optional.of(roulette);
		when(rouletteRepository.findById(5L)).thenReturn(validationRoulette);
		when(rouletteRepository.save(roulette)).thenReturn(roulette);
		assertThat(betServiceImpl.createBet(betDto).getCode()).isEqualTo(200);
	}
	
	@Test
	public void closeBetsTest() {
		assertThat(betServiceImpl.closeBets(5L).getCode()).isEqualTo(404);
		Roulette roulette = new Roulette(RouletteConstants.CONSTANT_OPEN);
		roulette.setId(5L);
		Optional<Roulette> validationRoulette = Optional.of(roulette);
		when(rouletteRepository.save(roulette)).thenReturn(roulette);
		roulette.setBets(new ArrayList<>());
		validationRoulette = Optional.of(roulette);
		when(rouletteRepository.findById(5L)).thenReturn(validationRoulette);
		assertThat(betServiceImpl.closeBets(5L).getCode()).isEqualTo(200);
	}
}
