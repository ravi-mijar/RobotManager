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
	
	private static ToyRobot instance;
	
	private ToyRobot() {}
	
	public static ToyRobot getRobotInstance() {
		if(instance == null) {
			instance = new ToyRobot();
		}
		return instance;
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
	
}
