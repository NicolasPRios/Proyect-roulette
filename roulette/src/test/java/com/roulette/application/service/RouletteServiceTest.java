package com.roulette.application.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.roulette.application.dto.RouletteDTO;
import com.roulette.application.model.Roulette;
import com.roulette.application.repository.RouletteRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RouletteServiceTest {

	@Autowired
	RouletteServiceImpl rouletteServiceImpl;
	
	@MockBean
	RouletteRepository rouletteRepository;
	
	@Test
	public void createRouletteTest() {
		Roulette roulette = new Roulette();
		roulette.setId(5L);
		when(rouletteRepository.save(any(Roulette.class))).thenReturn(roulette);
		assertThat(rouletteServiceImpl.createRoulette()).isNotNull();
	}
	
	@Test
	public void openRouletteTest() {
		assertThat(rouletteServiceImpl.openRoulette(5L).getCode()).isEqualTo(400);
		Optional<Roulette> validationRoulette = Optional.of(new Roulette());
		when(rouletteRepository.findById(5L)).thenReturn(validationRoulette);
		when(rouletteRepository.save(any(Roulette.class))).thenReturn(new Roulette());
		assertThat(rouletteServiceImpl.openRoulette(5L).getCode()).isEqualTo(200);	
	}
	
	@Test
	public void rouletteListWithStatusTest() {
		List<Roulette> rouletteList = new ArrayList<>();
		when(rouletteRepository.findAll()).thenReturn(rouletteList);
		assertThat(rouletteServiceImpl.rouletteListWithStatus()).isNotNull();
	}
}
