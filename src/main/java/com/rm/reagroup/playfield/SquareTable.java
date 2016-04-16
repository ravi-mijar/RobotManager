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
		else if(p.getX()< 0 || p.getY() < 0) {
			return true;
		}
		else 
			return false;
	}
	
	/*//we can pass either X or Y and check whether it is at an extremity
	private boolean isOnBoundary(int current) {
		if(current == (length - 1) || current == 0)
			return true;
		else
			return false;
	}*/
	
	@Override
	
	public boolean willFallOff(Position currentPosition, Orientation facing) {
		
		if(facing == Orientation.EAST && currentPosition.getX() == (length - 1)) 
			return true;
		else if(facing == Orientation.WEST && currentPosition.getX() == 0) 
			return true;
		else if(facing == Orientation.NORTH && currentPosition.getY() == (length - 1))
			return true;
		else if(facing == Orientation.SOUTH && currentPosition.getY() == 0)
			return true;
		else 
			return false;
	}

	/*@Override
	public boolean isOnBoundary(Position p) {
		//if either X or Y is at the extremity, return true
		if(isOnBoundary(p.getX()) == true || isOnBoundary(p.getY()) == false)
			return true;
		else 
			return false;
	}*/
}
