package com.rm.reagroup.operations;

import com.rm.reagroup.robot.ToyRobot;

/**
 * This interface describes operations on the robot. 
 * Classes implementing this interface will define their own logic of the operation.
 * @author hawk
 *
 */
public interface IOperation {
	public boolean execute(ToyRobot robot);
}
