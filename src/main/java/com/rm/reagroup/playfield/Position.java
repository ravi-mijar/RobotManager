package com.rm.reagroup.playfield;

/**
 * This class defines the position and orientation of the robot.
 * @author hawk
 *
 */
public class Position {
	
	//location of the robot.
	private int x;
	private int y;
	private Orientation orientation;
	
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
	 * Set the X coordinate of the position.
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Get the Y coordinate of the position.
	 * @return the y coordinate.
	 */
	public int getY() {
		return y;
	}

	/**
	 * Set the Y coordinate of the position.
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	
	/**
	 * Get the orientation of the robot.
	 * @return the orientation
	 */
	public Orientation getOrientation() {
		return orientation;
	}

	/**
	 * Set the orientation of the robot.
	 * @param orientation the orientation to set
	 */
	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

	@Override
	public String toString() {
		StringBuilder stb = new StringBuilder();
		stb.append("X: ").append(this.x).append(", Y: ").append(this.y).append(", ").append(this.orientation);
		return stb.toString();
	}
	
	
}
