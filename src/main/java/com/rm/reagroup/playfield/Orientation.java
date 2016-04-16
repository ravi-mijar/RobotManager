/**
 * 
 */
package com.rm.reagroup.playfield;

/**
 * @author hawk
 *
 */
public enum Orientation {
	SOUTH, WEST, NORTH, EAST;
	
	public Orientation left() {
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
	
	public Orientation right() {
		//get all the values in this enum.
		Orientation[] values = Orientation.values();

		//find the index of this particular instance
		int index = this.ordinal();

		//if this index is the 1st position, we want to go to the end of the array
		if(index == (values.length-1))
			return values[0];
		else 
			//else just move ahead in the array
			return values[index + 1];
	}
}
