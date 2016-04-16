package com.rm.reagroup.robot;

import com.rm.reagroup.playfield.Orientation;
import com.rm.reagroup.playfield.Position;

/**
 * @author hawk
 *
 */
public class ToyRobot {
	
	private Position currentPosition; 
	private Orientation orientation;
	private boolean placedCorrectly;
	
	private static ToyRobot instance;
	
	private ToyRobot() {}
	
	public static ToyRobot getRobotInstance() {
		if(instance == null) {
			instance = new ToyRobot();
		}
		return instance;
	}
	
	public void setPlacedCorrectly(boolean condition) {
		this.placedCorrectly = condition;
	}
	
	public boolean isPlacedCorrectly() {
		return this.placedCorrectly;
	}
	
	public Position getCurrentPosition() {
		return currentPosition;
	}
	public void setCurrentPosition(Position currentPosition) {
		this.currentPosition = currentPosition;
	}
	public Orientation getOrientation() {
		return orientation;
	}
	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}
	
	@Override
	public String toString() {
		StringBuilder stb = new StringBuilder();
		stb.append("robot: " + this.getCurrentPosition() + " : " + this.getOrientation());
		return stb.toString();
	}
}
