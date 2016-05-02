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
 * This class will test the Placement algorithm.
 * @author hawk
 *
 */
public class PlaceOperationTest {

	private static ToyRobot robot = ToyRobot.getRobotInstance();
	private static IShape playfield = new SquareTable(5);
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		robot = ToyRobot.getRobotInstance();
		playfield = new SquareTable(5);
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
	public void testValidPlace() {
		robot.place(new Position(3,0, Orientation.WEST), playfield);
		assertEquals(robot.getCurrentPosition(), new Position(3,0, Orientation.WEST));
	}
	@Test
	public void testInvalidPlace() {
		assertEquals(robot.place(new Position(-5, 5, Orientation.EAST), playfield), false);
	}
}
