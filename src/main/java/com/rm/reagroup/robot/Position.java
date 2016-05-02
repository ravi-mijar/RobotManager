package com.rm.reagroup.robot;

import java.util.logging.Logger;

import com.rm.reagroup.playfield.IShape;
import com.rm.reagroup.utils.Constants;

/**
 * This class defines the position and orientation of the robot.
 * @author hawk
 *
 */
/**
 * @author hawk
 *
 */
public class Position {
	
	//location of the robot.
	private int x;
	private int y;
	private Orientation orientation;
	
	/**
	 * Initialize position of the robot.
	 * @param x - X coordinate
	 * @param y - Y coordinate
	 * @param orientation - Orientation / direction of the robot.
	 */
	public Position(int x, int y, Orientation orientation) {
		super();
		this.x = x;
		this.y = y;
		this.orientation = orientation;
	}

	/**
	 * Get the X coordinate of the position.
	 * @return the x coordinate.
	 */
	public int getX() {
		return x;
	}

	/**
	 * Get the Y coordinate of the position.
	 * @return the y coordinate.
	 */
	public int getY() {
		return y;
	}

	/**
	 * Get the orientation of the robot.
	 * @return the orientation
	 */
	public Orientation getOrientation() {
		return orientation;
	}

	/**
	 * This method will move(increment / decrement x / y coordinates)
	 * according to the orientation and shape on which the robot is currently placed.
	 * @return
	 */
	protected boolean move(IShape playfield) {
		if(playfield.willFallOff(this)) {
			Logger.getLogger("RobotManager").warning(Constants.ROBOT_WILL_FALL);
			return false;
		}
		switch(this.orientation) {
		case NORTH:
			this.y += Constants.MOVEBY;
			break;
		case SOUTH:
			this.y -= Constants.MOVEBY;
			break;
		case EAST:
			this.x += Constants.MOVEBY;
			break;
		case WEST:
			this.x -= Constants.MOVEBY;
			break;
		default:
			return false;
		}
		return true;
	}
	
	public void rotate(RotateDirection rotateDir) {
		if(rotateDir == RotateDirection.LEFT) {
			//if the new rotate direction was left, call appropriate method on the orientation enum
			this.orientation = this.orientation.left();
		}
		else if(rotateDir == RotateDirection.RIGHT) {
			//if the new rotate direction was right, call appropriate method on the orientation enum
			this.orientation = this.orientation.right();
		}
	}
	
	@Override
	public String toString() {
		StringBuilder stb = new StringBuilder();
		stb.append("X: ").append(this.x).append(", Y: ").append(this.y).append(", ").append(this.orientation);
		return stb.toString();
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Position) {
			Position temp = (Position)o;
			if(temp.x == this.x && temp.y == this.y && temp.orientation == this.orientation)
				return true;
		}
		return false;
	}
}
