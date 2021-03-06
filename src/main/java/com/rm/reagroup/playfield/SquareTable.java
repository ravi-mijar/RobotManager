package com.rm.reagroup.playfield;

import com.rm.reagroup.robot.Orientation;
import com.rm.reagroup.robot.Position;

/**
 * This class implements a square shaped table with an integer length.
 * @author hawk
 *
 */
public class SquareTable implements IShape {
	
	//Keep a constant size defined for now.
	public static final int SQUARE_TABLE_SIZE = 15;
	
	//length of the side.
	private int length;
	
	/**
	 * Initialize the square table.
	 * @param length - length of each side.
	 */
	public SquareTable(int length) {
		this.length = length;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.rm.reagroup.playfield.IShape#isOutOfBounds(com.rm.reagroup.playfield.Position)
	 */
	public boolean isOutOfBounds(Position p) {
		//If either the X or Y coordinate is greater than or equal to length
		//return true.
		if(p.getX() >= length || p.getY() >= length || p.getX()< 0 || p.getY() < 0) {
			return true;
		}
		//return false otherwise. Meaning this Position p is within the shape.
		else 
			return false;
	}
	
	/* (non-Javadoc)
	 * @see com.rm.reagroup.playfield.IShape#willFallOff(com.rm.reagroup.playfield.Position)
	 */
	@Override
	public boolean willFallOff(Position currentPosition) {
		
		Orientation facing = currentPosition.getOrientation();
		//If robot is at the right extreme boundary and facing east
		if(facing == Orientation.EAST && currentPosition.getX() == (length - 1)) 
			return true;
		//if robot is at the left extreme boundary and facing west
		else if(facing == Orientation.WEST && currentPosition.getX() == 0) 
			return true;
		//if robot is at the top extreme boundary and facing north
		else if(facing == Orientation.NORTH && currentPosition.getY() == (length - 1))
			return true;
		//if robot is at the bottom extreme boundary and facing south
		else if(facing == Orientation.SOUTH && currentPosition.getY() == 0)
			return true;
		//return false otherwise. Meaning, the robot is within the boundary.
		else 
			return false;
	}
}
