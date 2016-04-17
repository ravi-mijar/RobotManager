/**
 * 
 */
package com.rm.reagroup.playfield;

/**
 * This interface defines basic operations on the playfield.
 * Implementing classes need to define these methods. 
 * @author hawk
 *
 */
public interface IShape {
	
	/**
	 * Determine whether the robot will fall off in the next move, depending on the current position 
	 * and orientation.
	 * @param current
	 * @return
	 */
	public boolean willFallOff(Position current);
	
	
	/**
	 * Determine whether the position object passed in lies within the boundaries of the shape
	 * or no.
	 * @param p
	 * @return
	 */
	public boolean isOutOfBounds(Position p);
}
