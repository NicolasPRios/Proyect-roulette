package com.roulette.application.model;

import org.springframework.data.redis.core.index.Indexed;

/**
 * Model class for the bet
 * @author Nicolas Palacios Rios
 * @version 1.0
 *
 */
public class Bet {

	@Indexed
	private Long Id;
	private Long amountMoney;
	private String userCode;
	private String betColor;
	private Long betnumber;
	private Long rouletteId;

	public Bet() {
		super();
	}

	public Bet(Long amountMoney, String userCode, String betColor, Long betnumber, Long rouletteId) {
		super();
		this.amountMoney = amountMoney;
		this.userCode = userCode;
		this.betColor = betColor;
		this.betnumber = betnumber;
		this.rouletteId = rouletteId;
	}

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
