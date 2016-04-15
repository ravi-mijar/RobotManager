/**
 * 
 */
package com.rm.reagroup.playfield;

/**
 * @author hawk
 *
 */
public interface IShape {
	public boolean isOnBoundary(Position p);
	
	public boolean willFallOff(Position current, Orientation facing);
	
	public boolean isOutOfBounds(Position p);
}
