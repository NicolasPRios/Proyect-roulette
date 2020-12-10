package com.roulette.application.model;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

/**
 * Model class for the roulette
 * @author Nicolas Palacios Rios
 * @version 1.0
 *
 */
@RedisHash("Roulette")
public class Roulette {

	@Id
	private Long id;
	private String status;
	private ArrayList<Bet> bets;

	public Roulette() {
		super();
		this.bets = new ArrayList<>();
	}

	public Roulette(String status) {
		super();
		this.status = status;
		this.bets = new ArrayList<>();
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

	public ArrayList<Bet> getBets() {
		
		return bets;
	}

	public void setBets(ArrayList<Bet> bets) {
		this.bets = bets;
	}

	public void betSave(Bet bet) {
		bets.add(bet);
	}

}
