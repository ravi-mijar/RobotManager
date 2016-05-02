/**
 * 
 */
package com.rm.reagroup.test.operation;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rm.reagroup.playfield.IShape;
import com.rm.reagroup.playfield.SquareTable;
import com.rm.reagroup.robot.Orientation;
import com.rm.reagroup.robot.Position;
import com.rm.reagroup.robot.RotateDirection;
import com.rm.reagroup.robot.ToyRobot;

/**
 * This test will fire operations on the robot in a seemingly 
 * random order. 
 * @author hawk
 *
 */
public class MixTest {

	private static ToyRobot robot = ToyRobot.getRobotInstance();
	private static IShape playfield = new SquareTable(15);
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		robot = ToyRobot.getRobotInstance();
		playfield = new SquareTable(15);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		ToyRobot.resetRobot();
		robot = null;
	}


	@Test
	public void test() {
		//place it within the table
		robot.place(new Position(0, 0, Orientation.EAST), playfield);
		for (int i= 0; i<15;i++) {
			robot.move(playfield);
			if(i%3 == 0) {
				robot.rotate(RotateDirection.RIGHT);
			}
			if(i%4 == 0) {
				robot.rotate(RotateDirection.LEFT);
			}
		}
		assertTrue(robot.isPlacedCorrectly());
	}

}
