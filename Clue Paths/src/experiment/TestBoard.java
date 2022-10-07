package experiment;

import java.util.HashSet;
import java.util.Set;

public class TestBoard {
	Set<TestBoardCell> legalCells;
	public TestBoard() {
	}
	public void calcTargets(TestBoardCell startCell, int pathlength) {
	}
	public Set<TestBoardCell> getTargets(){
		return new HashSet<TestBoardCell>();
	}
	public TestBoardCell getCell( int row, int col ) {
		return new TestBoardCell(0,0);
	}
}
