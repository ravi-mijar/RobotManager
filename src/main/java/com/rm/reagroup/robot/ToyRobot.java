package com.rm.reagroup.robot;

import java.util.logging.Logger;

import com.rm.reagroup.playfield.IShape;
import com.rm.reagroup.utils.Constants;

/**
 * This class defines the robot itself.
 * @author hawk
 *
 */
public class ToyRobot {
	
	//Position of the robot
	private Position currentPosition; 
	
	//We want this robot to be a singleton for the purposes of this app.
	private static ToyRobot instance;
	
	private ToyRobot() {}
	
	/**
	 * Method to fetch the single robot instance in this JVM.
	 * @return ToyRobot object
	 */
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
	 * @return true if robot is within the playfield, false otherwise
	 */
	public boolean isPlacedCorrectly() {
		return this.currentPosition != null? true : false;
	}
	
	/**
	 * Return the current position of the robot.
	 * @return current Position
	 */
	public Position getCurrentPosition() {
		return currentPosition;
	}
	
	/**
	 * Checks whether the position passed in will place the robot 
	 * on the @IShape correctly or no. 
	 * @param newPosition - new position to place robot.
	 * @param playfield - @IShape on which to place robot.
	 * @return If placement is possible, the function sets the position object of the robot to
	 *  'newPosition' and returns true.
	 * false otherwise.
	 */
	public boolean place(Position newPosition, IShape playfield) {
		if(null != newPosition && null != playfield) {
			if(playfield.isOutOfBounds(newPosition)) {
				return false;
			}
			else {
				this.currentPosition = newPosition;
				return true;
			}
		}
		return false;
	}
	
	/**
	 * This method will move the robot in the direction it is currently facing
	 * @param playfield - Shape on which to move the robot.
	 * @return - true - if the move was successful
	 * false - if otherwise OR if shape was null;
	 */
	public boolean move(IShape playfield) {
		if(null != playfield)
			return this.currentPosition.move(playfield);
		else {
			Logger.getLogger("RobotManager").warning("Shape passed in was null. Cannot proceed.");
			return false;
		}
	}
	
	/**
	 * This method will rotate the robot.
	 * @param dir - Direction to turn the robot to - LEFT / RIGHT
	 * @return - true when rotation was successful
	 * false if direction was wrong, or rotation was unsuccessful
	 */
	public boolean rotate(RotateDirection dir) {
		if(dir.equals(RotateDirection.LEFT) || dir.equals(RotateDirection.RIGHT)) {
			this.getCurrentPosition().rotate(dir);
			return true;
		}
		else
			Logger.getLogger("RobotManager").warning(Constants.INVALID_ROTATE_DIRECTION);
		return false;
	}
	
	/**
	 * This method will nullify all the properties of the robot and destroy the object.
	 * Thereby resetting it.
	 * Use carefully!
	 * 
	 */
	public static void resetRobot() {
		getRobotInstance().currentPosition = null;
		instance = null;
	}
	
	@Override
	public String toString() {
		StringBuilder stb = new StringBuilder();
		stb.append("robot: " + this.getCurrentPosition());
		return stb.toString();
	}
}
