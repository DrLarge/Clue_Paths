package experiment;

import java.util.HashSet;
import java.util.Set;

public class TestBoard {
	Set<TestBoardCell> legalCells;
	public TestBoard() {
	}
	void calcTargets(TestBoardCell startCell, int pathlength) {
	}
	Set<TestBoardCell> getTargets(){
		return new HashSet<TestBoardCell>();
	}
	public TestBoardCell getCell( int row, int col ) {
		return new TestBoardCell(0,0);
	}
}
