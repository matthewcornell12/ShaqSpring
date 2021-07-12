package com.mcornellsummer2012.ShaqSpring;

public class PlayerForm {
	
	private String player1;
	private String player2;
	
	public PlayerForm(String p1, String p2) {
		this.player1 = p1;
		this.player2 = p2;
	}

	/**
	 * @return the player2
	 */
	public String getPlayer2() {
		return player2;
	}

	/**
	 * @param player2 the player2 to set
	 */
	public void setPlayer2(String player2) {
		this.player2 = player2;
	}

	/**
	 * @return the player1
	 */
	public String getPlayer1() {
		return player1;
	}

	/**
	 * @param player1 the player1 to set
	 */
	public void setPlayer1(String player1) {
		this.player1 = player1;
	}

}
