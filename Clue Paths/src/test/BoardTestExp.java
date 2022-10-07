package test;

import static org.junit.Assert.fail;

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
	// This test makes sure that in a 4X4 grid roll of 1 allows you to move once unrestricted
	@Test
	public void testTargetsRoll1() {
		TestBoardCell cell = board.getCell(0,0);// the cell being tested
		board.calcTargets(cell,1);// calculating possible moves for a roll of 1
		Set<TestBoardCell> targets = board.getTargets();// getting the adjacency list of the cell

		// making sure we have the right number of cells
		Assert.assertEquals(2, targets.size());

		// testing cells to make sure the right cells are in there
		Assert.assertTrue(targets.contains(board.getCell(0, 1)));
		Assert.assertTrue(targets.contains(board.getCell(1, 0)));
	}

	// tests for a simple scenario of a dice roll. Specifically looking at calcTargets.
	// This test makes sure that in a 4X4 grid roll of 2 has a valid list of moves
	@Test
	public void testTargetsRoll2() {
		TestBoardCell cell = board.getCell(0,0);// the cell being tested
		board.calcTargets(cell,2);// calculating possible moves for a roll of 2
		Set<TestBoardCell> targets = board.getTargets();// getting the adjacency list of the cell

		// making sure we have the right number of cells
		Assert.assertEquals(3, targets.size());

		// testing cells to make sure the right cells are in there
		Assert.assertTrue(targets.contains(board.getCell(2, 0)));
		Assert.assertTrue(targets.contains(board.getCell(1, 1)));
		Assert.assertTrue(targets.contains(board.getCell(0, 2)));

	}

	// tests for a simple scenario of a dice roll. Specifically looking at calcTargets.
	// This test makes sure that in a 4X4 grid roll of 3 has a valid list of moves
	@Test
	public void testTargetsRoll3() {
		TestBoardCell cell = board.getCell(0,0);// the cell being tested
		board.calcTargets(cell,3);// calculating possible moves for a roll of 3
		Set<TestBoardCell> targets = board.getTargets();// getting the adjacency list of the cell

		// making sure we have the right number of cells
		Assert.assertEquals(6, targets.size());

		// testing cells to make sure the right cells are in there
		Assert.assertTrue(targets.contains(board.getCell(3, 0)));
		Assert.assertTrue(targets.contains(board.getCell(2, 1)));
		Assert.assertTrue(targets.contains(board.getCell(0, 1)));
		Assert.assertTrue(targets.contains(board.getCell(1, 2)));
		Assert.assertTrue(targets.contains(board.getCell(0, 3)));
		Assert.assertTrue(targets.contains(board.getCell(1, 0)));
	}

	// tests for a simple scenario of a dice roll. Specifically looking at calcTargets.
	// This test makes sure that in a 4X4 grid roll of 4 has a valid list of moves
	@Test
	public void testTargetsRoll4() {
		TestBoardCell cell = board.getCell(0,0);// the cell being tested
		board.calcTargets(cell,4);// calculating possible moves for a roll of 4
		Set<TestBoardCell> targets = board.getTargets();// getting the adjacency list of the cell

		// testing cells to make sure the right cells are in there
		Assert.assertEquals(7, targets.size());

		// testing cells to make sure the right cells are in there
		Assert.assertTrue(targets.contains(board.getCell(0, 0)));
		Assert.assertTrue(targets.contains(board.getCell(0, 2)));
		Assert.assertTrue(targets.contains(board.getCell(1, 1)));
		Assert.assertTrue(targets.contains(board.getCell(1, 3)));
		Assert.assertTrue(targets.contains(board.getCell(2, 0)));
		Assert.assertTrue(targets.contains(board.getCell(2, 2)));
		Assert.assertTrue(targets.contains(board.getCell(3, 1)));

	}

	// tests for a simple scenario of a dice roll. Specifically looking at calcTargets.
	// This test makes sure that in a 4X4 grid roll of 5 has a valid list of moves
	@Test
	public void testTargetsRoll5() {
		TestBoardCell cell = board.getCell(0,0);// the cell being tested
		board.calcTargets(cell,5);// calculating possible moves for a roll of 5
		Set<TestBoardCell> targets = board.getTargets();// getting the adjacency list of the cell

		// making sure we have the correct number of cells
		Assert.assertEquals(8, targets.size());

		// testing cells to make sure the right cells are in there
		Assert.assertTrue(targets.contains(board.getCell(3, 0)));
		Assert.assertTrue(targets.contains(board.getCell(2, 1)));
		Assert.assertTrue(targets.contains(board.getCell(0, 1)));
		Assert.assertTrue(targets.contains(board.getCell(1, 2)));
		Assert.assertTrue(targets.contains(board.getCell(0, 3)));
		Assert.assertTrue(targets.contains(board.getCell(1, 0)));
		Assert.assertTrue(targets.contains(board.getCell(3, 2)));
		Assert.assertTrue(targets.contains(board.getCell(2, 3)));
	}


	// tests for a simple scenario of a dice roll. Specifically looking at calcTargets.
	// This test makes sure that in a 4X4 grid roll of 6 has a valid list of moves 
	@Test
	public void testTargetsRoll6() {
		TestBoardCell cell = board.getCell(0,0);// the cell being tested
		board.calcTargets(cell,6);// calculating possible moves for a roll of 6
		Set<TestBoardCell> targets = board.getTargets();// getting the adjacency list of the cell

		// making sure we have the correct number of cells
		Assert.assertEquals(9, targets.size());

		// testing cells to make sure the right cells are in there
		Assert.assertTrue(targets.contains(board.getCell(0, 0)));
		Assert.assertTrue(targets.contains(board.getCell(0, 2)));
		Assert.assertTrue(targets.contains(board.getCell(1, 1)));
		Assert.assertTrue(targets.contains(board.getCell(1, 3)));
		Assert.assertTrue(targets.contains(board.getCell(2, 0)));
		Assert.assertTrue(targets.contains(board.getCell(2, 2)));
		Assert.assertTrue(targets.contains(board.getCell(3, 1)));
		Assert.assertTrue(targets.contains(board.getCell(3, 3)));
	}

	// Runs a variety of tests that examine different starting positions, and rooms being unavailable 
	public void testMixed() {

		board.getCell(0, 2).setOccupied(true);// making a cell occupied
		board.getCell(0, 2).setIsRoom(true); // making a cell a room

		// initializing objects
		TestBoardCell cell = board.getCell(0,3);
		board.calcTargets(cell,3);
		Set<TestBoardCell> targets = board.getTargets();

		// testing occupied condition
		if(targets.size() != 3) {
			fail("More cells than expected, testing ocuupied");
		}

		// testing all other possible cells
		Assert.assertTrue(targets.contains(board.getCell(1, 2)));
		Assert.assertTrue(targets.contains(board.getCell(2, 2)));
		Assert.assertTrue(targets.contains(board.getCell(3, 3)));


		TestBoardCell cell2 = board.getCell(2, 2);// new location

		// resetting occupied
		board.getCell(0, 2).setOccupied(false);
		board.getCell(0, 2).setIsRoom(false);

		// setting new occupied
		board.getCell(2,1).setOccupied(true);
		board.getCell(1,2).setIsRoom(true);

		// new list
		board.calcTargets(cell2,3);
		Set<TestBoardCell> targets2 = board.getTargets();

		// testing occupied condition
		if(targets.size() != 5) {
			fail("More cells than expected, testing occupied");
		}

		// testing all other possible cells
		Assert.assertTrue(targets2.contains(board.getCell(1, 2)));
		Assert.assertTrue(targets2.contains(board.getCell(2, 3)));
		Assert.assertTrue(targets2.contains(board.getCell(3, 2)));
		Assert.assertTrue(targets2.contains(board.getCell(3, 0)));
		Assert.assertTrue(targets2.contains(board.getCell(0, 3)));

	}

}
