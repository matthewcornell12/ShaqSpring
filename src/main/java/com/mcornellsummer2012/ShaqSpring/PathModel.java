package com.mcornellsummer2012.ShaqSpring;

import java.util.ArrayList;

public class PathModel {
	
	private ArrayList<Player> path;
	private String errorMessage;
	
	public PathModel() {
		this.path = new ArrayList<Player>();
	}

	/**
	 * @return the path
	 */
	public ArrayList<Player> getPath() {
		return path;
	}

	/**
	 * @param path the path to set
	 */
	public void setPath(ArrayList<Player> path) {
		this.path = path;
	}
	
	public void addPlayer(Player player) {
		this.path.add(player);
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
