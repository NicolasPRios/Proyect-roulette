package com.roulette.application.dto;

/**
 * Data transer object for Bet model
 * @author Nicolas Palacios Rios
 * @version 1.0
 */
public class BetDTO {
	private Long Id;
	private Long amountMoney;
	private String userCode;
	private String betColor;
	private Long betnumber;
	private Long rouletteId;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Long getAmountMoney() {

		return amountMoney;
	}

	public void setAmountMoney(Long amountMoney) {
		this.amountMoney = amountMoney;
	}

	public String getUserCode() {

		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getBetColor() {

		return betColor;
	}

	public void setBetColor(String betColor) {
		this.betColor = betColor;
	}

	public Long getBetnumber() {

		return betnumber;
	}

	public void setBetnumber(Long betnumber) {
		this.betnumber = betnumber;
	}

	public Long getRouletteId() {

		return rouletteId;
	}

	public void setRouletteId(Long rouletteId) {
		this.rouletteId = rouletteId;
	}
}
