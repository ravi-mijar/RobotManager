package com.rm.reagroup.operations;

import com.rm.reagroup.robot.ToyRobot;

/**
 * This interface describes operations on the robot. 
 * Classes implementing this interface will define their own logic of the operation.
 * @author hawk
 *
 */
public interface IOperation {
	/**
	 * Implement this method to define your operation on the robot.
	 * The implementation should change the state of the robot only for a 
	 * valid operation. 
	 * @param robot - the robot to operate on
	 * @return - true if the operation succeeded, false otherwise.
	 */
	public boolean execute(ToyRobot robot);
}
