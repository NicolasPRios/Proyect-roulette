package com.roulette.application.util;

import com.roulette.application.dto.BetDTO;

/**
 * This class is for application validation
 * @author Nicolas Palacios Rios
 * @version 1.0
 *
 */
public class RuleValidation {

	private RuleValidation() {

	}

	public static boolean moneyAmountValidation(BetDTO betDto) {
		if (betDto.getAmountMoney() != null && betDto.getAmountMoney() > 0 && betDto.getAmountMoney() <= 10000) {

			return true;
		}

		return false;
	}
	
	public static boolean validateNumberAndColor(BetDTO betDto) {
		if (betDto.getBetnumber() != null && betDto.getBetnumber() >= 0 && betDto.getBetnumber() <= 36) {
			betDto.setBetColor(null);
			
			return true;
		} else if (betDto.getBetColor() != null && (betDto.getBetColor().equalsIgnoreCase(RouletteConstants.CONSTANT_BLACK)
				|| betDto.getBetColor().equalsIgnoreCase(RouletteConstants.CONSTANT_RED))) {
			
			return true;
		}
		
		return false;
	}
	
	public static boolean validateNumberAndColorController(BetDTO betDto) {
		if (betDto.getBetnumber() != null) {
			if(betDto.getBetColor() != null) {
				
				return false;
			}
		}
		
		return true;
	}
}
