/**
 * 
 */
package com.rm.reagroup.operations;

import com.rm.reagroup.playfield.IShape;
import com.rm.reagroup.playfield.Orientation;
import com.rm.reagroup.playfield.Position;
import com.rm.reagroup.robot.ToyRobot;

/**
 * @author hawk
 *
 */
public class Place implements IOperation {

	private Position newPosition;
	private Orientation newOrientation;
	private IShape playfield;
	

	public Place(Position position, Orientation facing, IShape playfield2) {
		this.newPosition = position;
		this.newOrientation = facing;
		this.playfield = playfield2;
	}


	/* (non-Javadoc)
	 * @see com.rm.reagroup.operations.IOperation#execute(com.rm.reagroup.robot.ToyRobot)
	 */
	@Override
	public boolean execute(ToyRobot robot) throws InvalidOperationException {
		
		if(playfield.isOutOfBounds(newPosition)) {
			robot.setPlacedCorrectly(false);
			return false;
		}
		else {
			robot.setCurrentPosition(newPosition);
			robot.setOrientation(newOrientation);
			robot.setPlacedCorrectly(true);
			return true;
		}
	}

}
