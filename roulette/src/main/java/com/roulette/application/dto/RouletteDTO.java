package com.roulette.application.dto;

import java.util.ArrayList;

/**
 * Data transfer object for Roulette model
 * @author Nicolas Palacios Rios
 * @version 1.0
 *
 */
public class RouletteDTO extends ResponseDTO {
	private Long id;
	private String status;
	private ArrayList<BetDTO> bets;

	public RouletteDTO() {
		bets = new ArrayList<>();
	}

	public RouletteDTO(Long id, String status) {
		this.id = id;
		this.status = status;
	}

	public Long getId() {
		
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ArrayList<BetDTO> getBets() {
		
		return bets;
	}

	public void setBets(ArrayList<BetDTO> bets) {
		this.bets = bets;
	}

	public void addBet(BetDTO bet) {
		this.bets.add(bet);
	}
}
