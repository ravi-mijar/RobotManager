package com.rm.reagroup.robot;

import com.rm.reagroup.playfield.Position;

/**
 * @author hawk
 *
 */
public class ToyRobot {
	
	private Position currentPosition; 
	
	private static ToyRobot instance;
	
	private ToyRobot() {}
	
	public static ToyRobot getRobotInstance() {
		if(instance == null) {
			instance = new ToyRobot();
		}
		return instance;
	}
	
	public boolean isPlacedCorrectly() {
		return this.currentPosition != null? true : false;
	}
	
	public Position getCurrentPosition() {
		return currentPosition;
	}
	public void setCurrentPosition(Position currentPosition) {
		this.currentPosition = currentPosition;
	}
	
	@Override
	public String toString() {
		StringBuilder stb = new StringBuilder();
		stb.append("robot: " + this.getCurrentPosition());
		return stb.toString();
	}
}
