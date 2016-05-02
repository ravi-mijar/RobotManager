package com.rm.reagroup.robot;

/**
 * This enum defines the possible directions / orientation the robot can have.
 * It also defines methods on the enum to change the direction clockwise / anti-clockwise. 
 * @author hawk
 *
 */
public enum Orientation {
	SOUTH, WEST, NORTH, EAST;
	
	/**
	 * Method to turn the robot to the left.
	 * @return - new direction.
	 */
	protected Orientation left() {
		//get all the values in this enum.
		Orientation[] values = Orientation.values();
		
		//find the index of this particular instance
		int index = this.ordinal();
		//if this index is the 1st position, we want to go to the end of the array
		if(index == 0)
			return values[values.length - 1];
		else 
			//else just move back in the array
			return values[index - 1];
	}
	
	/**
	 * Method to turn the robot to the right.
	 * @return - new direction.
	 */
	protected Orientation right() {
		//get all the values in this enum.
		Orientation[] values = Orientation.values();

		//find the index of this particular instance
		int index = this.ordinal();

		//if this index is the last position, we want to go to the beginning of the array
		if(index == (values.length-1))
			return values[0];
		else 
			//else just move ahead in the array
			return values[index + 1];
	}
}
