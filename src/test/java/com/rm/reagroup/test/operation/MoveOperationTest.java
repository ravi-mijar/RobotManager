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
import com.rm.reagroup.robot.ToyRobot;

/**
 * This test will test conditions related to movement of the robot.
 * @author hawk
 *
 */
public class MoveOperationTest {

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
	public void testValidMove() {
		//place it within the table
		robot.place(new Position(0, 0, Orientation.EAST), playfield);
		for (int i= 0; i<15;i++)
			robot.move(playfield);
		assertEquals(robot.getCurrentPosition(),new Position(14, 0, Orientation.EAST));
	}
	
	@Test
	public void testNullMove() {
		//place it within the table
		robot.place(new Position(0, 0, Orientation.EAST), playfield);
		robot.move(null);
		assertEquals(robot.getCurrentPosition(), new Position(0,0, Orientation.EAST));
	}
	
	@Test
	public void testInvalidMoveToNorth() {
		//place it within the table
		robot.place(new Position(4, 14, Orientation.NORTH), playfield);
		robot.move(playfield);
		assertEquals(robot.getCurrentPosition(), new Position(4, 14, Orientation.NORTH));
	}
	
	@Test
	public void testInvalidMoveToEast() {
		//place it within the table
		robot.place(new Position(14, 7, Orientation.EAST), playfield);
		robot.move(playfield);
		assertEquals(robot.getCurrentPosition(), new Position(14, 7, Orientation.EAST));
	}
	
	@Test
	public void testInvalidMoveToWest() {
		//place it within the table
		robot.place(new Position(0, 4, Orientation.WEST), playfield);
		robot.move(playfield);
		assertEquals(robot.getCurrentPosition(), new Position(0, 4, Orientation.WEST));
	}
	
	@Test
	public void testInvalidMoveToSouth() {
		//place it within the table
		robot.place(new Position(4, 0, Orientation.SOUTH), playfield);
		robot.move(playfield);
		assertEquals(robot.getCurrentPosition(), new Position(4, 0, Orientation.SOUTH));
	}
}