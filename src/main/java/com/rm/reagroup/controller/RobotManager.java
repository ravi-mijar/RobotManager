package com.rm.reagroup.controller;

import com.rm.reagroup.playfield.IShape;
import com.rm.reagroup.playfield.SquareTable;

public class RobotManager {
	
	//For this JVM instance we want to ensure the playfield doesn't change.
	private static final IShape playfield = new SquareTable(5);//can be modified to pick up from properties file.

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
