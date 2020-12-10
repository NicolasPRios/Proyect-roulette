package com.roulette.application.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Data transfer object to show winner list and victory attributes
 * @author Nicolas Palacios Rios
 * @version 1.0
 */
public class ResponseBetDTO extends ResponseDTO {
	private List<BetDTO> BetList;
	private List<WinnerUserDTO> winnerUsers;
	private String winnerBetColor;
	private Long winnerBetNumber;

	public ResponseBetDTO() {
		winnerUsers = new ArrayList<>();
	}

	public List<BetDTO> getBetList() {

		return BetList;
	}

	public void setBetList(List<BetDTO> betList) {
		BetList = betList;
	}

	public List<WinnerUserDTO> getWinnerUsers() {

		return winnerUsers;
	}

	public void setWinnerUsers(List<WinnerUserDTO> winnerUsers) {
		this.winnerUsers = winnerUsers;
	}

	public String getWinnerBetColor() {

		return winnerBetColor;
	}

	public void setWinnerBetColor(String winnerBetColor) {
		this.winnerBetColor = winnerBetColor;
	}

	public Long getWinnerBetNumber() {

		return winnerBetNumber;
	}

	public void setWinnerBetNumber(Long winnerBetNumber) {
		this.winnerBetNumber = winnerBetNumber;
	}

	public void addWinner(WinnerUserDTO winner) {
		winnerUsers.add(winner);
	}

}
