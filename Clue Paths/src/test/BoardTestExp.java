package test;

import java.util.Set;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import experiment.TestBoard;
import experiment.TestBoardCell;

public class BoardTestExp {
	TestBoard board; // test board 
	
	// Creates a new test board before each test
	@BeforeEach
	public void setUp() {
	board = new TestBoard();	
	}
	
	// tests for if the adjacency list in board for a given cell is correct.
	@Test
	public void testAdjacency() {
		TestBoardCell cell = board.getCell(0,0); // the cell being tested
		Set<TestBoardCell> testList = cell.getAdjList();// getting the adjacency list of the cell
		
		// testing if cells are in the list, as they should be
		Assert.assertTrue(testList.contains(board.getCell(0,0)));
		Assert.assertTrue(testList.contains(board.getCell(1,3)));
		Assert.assertTrue(testList.contains(board.getCell(3,0)));
		Assert.assertTrue(testList.contains(board.getCell(3,3)));
		Assert.assertTrue(testList.contains(board.getCell(2,2)));
		Assert.assertTrue(testList.contains(board.getCell(1,1)));
		Assert.assertEquals(16, testList.size()); // testing if the list size is correct for a 4X4 grid
	}
	
	// tests for a simple scenario of a dice roll. Specifically looking at calcTargets.
	@Test
	public void testTargetsNormal() {
		TestBoardCell cell = board.getCell(0,0);
		board.calcTargets(cell,3);
		Set<TestBoardCell> targets = board.getTargets();
		Assert.assertEquals(6, targets.size());
		Assert.assertTrue(targets.contains(board.getCell(3, 0)));
		Assert.assertTrue(targets.contains(board.getCell(2, 1)));
		Assert.assertTrue(targets.contains(board.getCell(0, 1)));
		Assert.assertTrue(targets.contains(board.getCell(1, 2)));
		Assert.assertTrue(targets.contains(board.getCell(0, 3)));
		Assert.assertTrue(targets.contains(board.getCell(1, 0)));
	}
	
	@Test
	public void testTargetsMixed() {
		board.getCell(0, 2).setOccupied(true);
		board.getCell(0, 2).setIsRoom(true);
		TestBoardCell cell = board.getCell(0,3);
		board.calcTargets(cell,3);
		Set<TestBoardCell> targets = board.getTargets();
		Assert.assertEquals(3, targets.size());
		Assert.assertTrue(targets.contains(board.getCell(1, 2)));
		Assert.assertTrue(targets.contains(board.getCell(2, 2)));
		Assert.assertTrue(targets.contains(board.getCell(3, 3)));
	}
	
	
}
