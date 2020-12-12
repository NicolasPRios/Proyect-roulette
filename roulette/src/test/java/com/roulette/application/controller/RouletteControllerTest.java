package com.roulette.application.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.roulette.application.dto.BetDTO;
import com.roulette.application.dto.ResponseBetDTO;
import com.roulette.application.dto.ResponseDTO;
import com.roulette.application.service.BetServiceImpl;
import com.roulette.application.service.RouletteServiceImpl;
import com.roulette.application.util.RouletteConstants;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RouletteControllerTest {

	@Autowired
	RouletteController rouletteController;

	@MockBean
	RouletteServiceImpl rouletteServiceImpl;
	
	@MockBean
	BetServiceImpl betServiceImpl;

	@Test
	public void createRouletteTest() {
		when(rouletteServiceImpl.createRoulette()).thenReturn(5L);
		assertThat(rouletteController.createRoulette()).isEqualTo(5L);
	}

	@Test
	public void openRouletteTest() {
		ResponseDTO responseDTO = new ResponseDTO();
		responseDTO.setCode(200);
		responseDTO.setMessage(RouletteConstants.MESSAGE_VALIDATE_OPEN_ROULETTE_CORRECT);
		when(rouletteServiceImpl.openRoulette(5L)).thenReturn(responseDTO);
		assertThat(rouletteController.openRoulette(5L).getMessage())
				.isEqualTo(RouletteConstants.MESSAGE_VALIDATE_OPEN_ROULETTE_CORRECT);
	}

	@Test
	public void createBetTest() {
		BetDTO betDTO = new BetDTO();
		betDTO.setBetColor(RouletteConstants.CONSTANT_BLACK);
		betDTO.setBetnumber(23L);
		assertThat(rouletteController.createBet(betDTO).getMessage())
				.isEqualTo(RouletteConstants.MESSAGE_VALIDATE_NUMBER_AND_COLOR_CONTROLLER);

	}
	
	@Test
	public void closeRouletteTest() {
		ResponseBetDTO response = new ResponseBetDTO();
		response.setCode(200);
		response.setMessage(RouletteConstants.MESSAGE_CLOSE_ROULETTE_CORRECT);
		when(betServiceImpl.closeBets(5L)).thenReturn(response);
		assertThat(rouletteController.closeRoulette(5L).getCode()).isEqualTo(200);
	}
	
	@Test
	public void rouletteListWithStatusTest() {
		when(rouletteServiceImpl.rouletteListWithStatus()).thenReturn(new ArrayList<>());
		assertThat(rouletteController.rouletteListWithStatus()).isNotNull();
	}
}
