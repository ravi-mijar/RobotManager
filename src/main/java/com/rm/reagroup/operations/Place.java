package com.rm.reagroup.operations;

import com.rm.reagroup.playfield.IShape;
import com.rm.reagroup.playfield.Position;
import com.rm.reagroup.robot.ToyRobot;

/**
 * This class provides implementation of the place operation, which will place the robot on the playfield
 * at the given position and orientation.
 * @author hawk
 *
 */
public class Place implements IOperation {

	//new Position where the robot needs to be placed.
	private Position newPosition;
	
	//The playfield where the robot needs to be placed.
	private IShape playfield;
	

	public Place(Position position, IShape playfield2) {
		this.newPosition = position;
		this.playfield = playfield2;
	}


	/* (non-Javadoc)
	 * @see com.rm.reagroup.operations.IOperation#execute(com.rm.reagroup.robot.ToyRobot)
	 */
	@Override
	public boolean execute(ToyRobot robot) throws InvalidOperationException {
		//Check whether the new position is within the playfield / shape.
		if(playfield.isOutOfBounds(newPosition)) {
			return false;
		}
		else {
			robot.setCurrentPosition(newPosition);
			return true;
		}
	}

}
