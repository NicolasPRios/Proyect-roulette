package com.roulette.application.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.roulette.application.dto.BetDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RuleValidationTest {

	
	@Test
	public void moneyAmountValidationTest() {
		BetDTO betDTO = new BetDTO();
		assertThat(RuleValidation.moneyAmountValidation(betDTO)).isEqualTo(false);
		betDTO.setAmountMoney(8L);
		assertThat(RuleValidation.moneyAmountValidation(betDTO)).isEqualTo(true);
		betDTO.setAmountMoney(10001L);
		assertThat(RuleValidation.moneyAmountValidation(betDTO)).isEqualTo(false);
		betDTO.setAmountMoney(-5L);
		assertThat(RuleValidation.moneyAmountValidation(betDTO)).isEqualTo(false);
	}
	
	@Test
	public void validateNumberAndColorTest() {
		BetDTO betDTO = new BetDTO();
		assertThat(RuleValidation.validateNumberAndColor(betDTO)).isEqualTo(false);
		betDTO.setBetnumber(-15L);
		assertThat(RuleValidation.validateNumberAndColor(betDTO)).isEqualTo(false);
		betDTO.setBetnumber(37L);
		assertThat(RuleValidation.validateNumberAndColor(betDTO)).isEqualTo(false);
		betDTO.setBetnumber(15L);
		assertThat(RuleValidation.validateNumberAndColor(betDTO)).isEqualTo(true);
		betDTO.setBetnumber(null);
		betDTO.setBetColor(RouletteConstants.CONSTANT_BLACK);
		assertThat(RuleValidation.validateNumberAndColor(betDTO)).isEqualTo(true);
		betDTO.setBetColor(RouletteConstants.CONSTANT_RED);
		assertThat(RuleValidation.validateNumberAndColor(betDTO)).isEqualTo(true);
	}
	
	@Test
	public void validateNumberAndColorController() {
		BetDTO betDTO = new BetDTO();
		assertThat(RuleValidation.validateNumberAndColorController(betDTO)).isEqualTo(true);
		betDTO.setBetnumber(-15L);
		assertThat(RuleValidation.validateNumberAndColorController(betDTO)).isEqualTo(true);
		betDTO.setBetColor(RouletteConstants.CONSTANT_RED);
		assertThat(RuleValidation.validateNumberAndColorController(betDTO)).isEqualTo(false);
		betDTO.setBetnumber(null);
		assertThat(RuleValidation.validateNumberAndColorController(betDTO)).isEqualTo(true);
	}
	
}
