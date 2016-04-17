package com.rm.reagroup.robot;

import com.rm.reagroup.playfield.Position;

/**
 * @author hawk
 *
 */
public class ToyRobot {
	
	//Position of the robot
	private Position currentPosition; 
	
	//We want this robot to be a singleton for the purposes of this app.
	private static ToyRobot instance;
	
	private ToyRobot() {}
	
	public static ToyRobot getRobotInstance() {
		if(instance == null) {
			instance = new ToyRobot();
		}
		return instance;
	}
	
	/**
	 * If the Position object of this robot is non-null,
	 * this function returns true, else it returns false.
	 * Position object is set only when it was within the 
	 * bounds of the current playfield / IShape object.
	 * @return 
	 */
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
