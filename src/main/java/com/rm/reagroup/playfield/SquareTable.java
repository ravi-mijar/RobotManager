/**
 * 
 */
package com.rm.reagroup.playfield;

/**
 * @author hawk
 *
 */
public class SquareTable implements IShape {
	
	private int length;
	
	public SquareTable(int length) {
		this.length = length;
	}
	
	public boolean isOutOfBounds(Position p) {
		if(p.getX() >= length || p.getY() >= length) {
			return true;
		}
		else 
			return false;
	}
	
	//we can pass either X or Y and check whether it is at an extremity
	private boolean isOnBoundary(int current) {
		if(current == (length - 1) || current == 0)
			return true;
		else
			return false;
	}
	
	@Override
	public boolean willFallOff(Position currentPosition, Orientation facing) {
		//If the robot is facing north / south, and the X coordinate is on the boundary it will fall off.
		if(isOnBoundary(currentPosition.getX()) && (facing == Orientation.NORTH || facing == Orientation.SOUTH)) {
			return true;
		}
		//If the robot is facing east / west, and the Y coordinate is on the boundary it will fall off.
		else if(isOnBoundary(currentPosition.getY()) && (facing == Orientation.EAST || facing == Orientation.WEST)) {
			return true;
		}
		else 
			return false;
	}

	@Override
	public boolean isOnBoundary(Position p) {
		//if either X or Y is at the extremity, return true
		if(isOnBoundary(p.getX()) == true || isOnBoundary(p.getY()) == false)
			return true;
		else 
			return false;
	}
}
