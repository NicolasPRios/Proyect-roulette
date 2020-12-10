package com.roulette.application.dto;

/**
 * Data transfer object to show the user winner
 * @author Nicolas Palacios Rios
 * @version 1.0
 *
 */
public class WinnerUserDTO {
	private Double amountMoneyEarned;
	private String userCode;

	public WinnerUserDTO() {
	}

	public WinnerUserDTO(Double amountMoneyEarned, String userCode) {
		super();
		this.amountMoneyEarned = amountMoneyEarned;
		this.userCode = userCode;
	}

	public double getAmountMoneyEarned() {

		return amountMoneyEarned;
	}

	public void setAmountMoneyEarned(Double amountMoneyEarned) {
		this.amountMoneyEarned = amountMoneyEarned;
	}

	public String getUserCode() {

		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

}
