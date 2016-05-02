/**
 * 
 */
package com.rm.reagroup.test.operation;

import static org.junit.Assert.assertEquals;

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
 * This class will test the rotation operations on the robot.
 * @author hawk
 *
 */
public class RotateOperationTest {

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
	public void testRotateLeft() {
		//place it within the table
		robot.place(new Position(3, 3, Orientation.EAST), playfield);

		robot.rotate(RotateDirection.LEFT); //north
		robot.rotate(RotateDirection.LEFT); //west
		robot.rotate(RotateDirection.LEFT); //south
		robot.rotate(RotateDirection.LEFT); //east
		robot.rotate(RotateDirection.LEFT); //north
		assertEquals(robot.getCurrentPosition().getOrientation(), Orientation.NORTH);
	}
	@Test
	public void testRotateRight() {
		//place it within the table
		robot.place(new Position(3, 3, Orientation.EAST), playfield);

		robot.rotate(RotateDirection.RIGHT);
		assertEquals(robot.getCurrentPosition().getOrientation(), Orientation.SOUTH);
		robot.rotate(RotateDirection.RIGHT);
		assertEquals(robot.getCurrentPosition().getOrientation(), Orientation.WEST);
		robot.rotate(RotateDirection.RIGHT);
		assertEquals(robot.getCurrentPosition().getOrientation(), Orientation.NORTH);
		robot.rotate(RotateDirection.RIGHT);
		assertEquals(robot.getCurrentPosition().getOrientation(), Orientation.EAST);
		robot.rotate(RotateDirection.RIGHT);
		assertEquals(robot.getCurrentPosition().getOrientation(), Orientation.SOUTH);
	}
	
	@Test
	public void testMixitUp() {
		//place it within the table
		robot.place(new Position(3, 3, Orientation.EAST), playfield);

		robot.rotate(RotateDirection.RIGHT); //south
		robot.rotate(RotateDirection.LEFT); //east
		robot.rotate(RotateDirection.RIGHT); //south
		robot.rotate(RotateDirection.RIGHT); //west
		robot.rotate(RotateDirection.LEFT); //south
		assertEquals(robot.getCurrentPosition().getOrientation(), Orientation.SOUTH);
	}
}
