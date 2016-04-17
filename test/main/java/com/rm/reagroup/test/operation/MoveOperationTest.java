/**
 * 
 */
package com.rm.reagroup.test.operation;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rm.reagroup.operations.InvalidOperationException;
import com.rm.reagroup.operations.Move;
import com.rm.reagroup.operations.Place;
import com.rm.reagroup.playfield.IShape;
import com.rm.reagroup.playfield.Orientation;
import com.rm.reagroup.playfield.Position;
import com.rm.reagroup.playfield.SquareTable;
import com.rm.reagroup.robot.ToyRobot;

/**
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
		System.out.println("setting up.");
		robot = ToyRobot.getRobotInstance();
		playfield = new SquareTable(15);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		robot.setCurrentPosition(null);
		robot = null;
		System.out.println("tearing down");
	}

	@Test
	public void testValidMove() {
		System.out.println("testValidMove");
		//place it within the table
		Place p = new Place(new Position(0, 0, Orientation.EAST), playfield);
		
		try {
			p.execute(robot);
			System.out.println("Original situation: " + robot);
			Move m = new Move(playfield);
			for (int i= 0; i<15;i++)
				m.execute(robot);
			System.out.println(robot);
		}
		catch(InvalidOperationException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testInvalidMoveToNorth() {
		System.out.println("testInvalidMoveToNorth");
		//place it within the table
		Place p = new Place(new Position(4, 14, Orientation.NORTH), playfield);
		
		try {
			p.execute(robot);
			System.out.println("Original situation: " + robot);
			Move m = new Move(playfield);
			assertTrue(m.execute(robot));
			System.out.println("After Move: " + robot);
		}
		catch(InvalidOperationException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testInvalidMoveToEast() {
		System.out.println("testInvalidMoveToEast");
		//place it within the table
		Place p = new Place(new Position(14, 7, Orientation.EAST), playfield);
		
		try {
			p.execute(robot);
			System.out.println("Original situation: " + robot);
			Move m = new Move(playfield);
			assertTrue(m.execute(robot));
			System.out.println("After Move: " + robot);
		}
		catch(InvalidOperationException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testInvalidMoveToWest() {
		System.out.println("testInvalidMoveToWest");
		//place it within the table
		Place p = new Place(new Position(0, 4, Orientation.WEST), playfield);
		
		try {
			p.execute(robot);
			System.out.println("Original situation: " + robot);
			Move m = new Move(playfield);
			assertTrue(m.execute(robot));
			System.out.println("After Move: " + robot);
		}
		catch(InvalidOperationException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testInvalidMoveToSouth() {
		System.out.println("testInvalidMoveToSouth");
		//place it within the table
		Place p = new Place(new Position(4, 0, Orientation.SOUTH), playfield);
		
		try {
			p.execute(robot);
			System.out.println("Original situation: " + robot);
			Move m = new Move(playfield);
			assertTrue(m.execute(robot));
			System.out.println("After Move: " + robot);
			//assert(true);
		}
		catch(InvalidOperationException e) {
			fail(e.getMessage());
		}
	}
}