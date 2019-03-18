package pkgGame;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class SudokuTest {
	@Test
	public void getRegionNbr_Test1() {
		int[][] puzzle = {{5,3,4,6,7,8,9,1,2},{6,7,2,1,9,5,3,4,8},{1,9,8,3,4,2,5,6,7},{8,5,9,7,6,1,4,2,3},{4,2,6,8,5,3,7,9,1},{7,1,3,9,2,4,8,5,6},{9,6,1,5,3,7,2,8,4},{2,8,7,4,1,9,6,3,5},{3,4,5,2,8,6,1,7,9}};
		Sudoku s = new Sudoku(puzzle);
		int[] reg = s.getRegion(0);
		int[] expected = {5,3,4,6,7,2,1,9,8};
		
		assertTrue(Arrays.equals(reg, expected));
	}
	
	@Test
	public void getRegionNbr_Test2() {
		int[][] puzzle = {{5,3,4,6,7,8,9,1,2},{6,7,2,1,9,5,3,4,8},{1,9,8,3,4,2,5,6,7},{8,5,9,7,6,1,4,2,3},{4,2,6,8,5,3,7,9,1},{7,1,3,9,2,4,8,5,6},{9,6,1,5,3,7,2,8,4},{2,8,7,4,1,9,6,3,5},{3,4,5,2,8,6,1,7,9}};
		Sudoku s = new Sudoku(puzzle);
		int[] reg = s.getRegion(5);
		int[] expected = {4,2,3,7,9,1,8,5,6};
		
		assertTrue(Arrays.equals(reg, expected));
	}
	
	@Test
	public void getRegionRowCol_Test1() throws Exception {
		int[][] puzzle = {{5,3,4,6,7,8,9,1,2},{6,7,2,1,9,5,3,4,8},{1,9,8,3,4,2,5,6,7},{8,5,9,7,6,1,4,2,3},{4,2,6,8,5,3,7,9,1},{7,1,3,9,2,4,8,5,6},{9,6,1,5,3,7,2,8,4},{2,8,7,4,1,9,6,3,5},{3,4,5,2,8,6,1,7,9}};
		Sudoku s = new Sudoku(puzzle);
		int[] reg = s.getRegion(2,1);
		int[] expected = {5,3,4,6,7,2,1,9,8};
		
		assertTrue(Arrays.equals(reg, expected));
	}
	
	@Test
	public void getRegionRowCol_Test2() throws Exception {
		int[][] puzzle = {{5,3,4,6,7,8,9,1,2},{6,7,2,1,9,5,3,4,8},{1,9,8,3,4,2,5,6,7},{8,5,9,7,6,1,4,2,3},{4,2,6,8,5,3,7,9,1},{7,1,3,9,2,4,8,5,6},{9,6,1,5,3,7,2,8,4},{2,8,7,4,1,9,6,3,5},{3,4,5,2,8,6,1,7,9}};
		Sudoku s = new Sudoku(puzzle);
		int[] reg = s.getRegion(7,4);
		int[] expected = {4,2,3,7,9,1,8,5,6};
		
		assertTrue(Arrays.equals(reg, expected));
	}
	
	@Test
	public void hasDuplicates_Test1() {
		int[][] puzzle = {{1,3,4,6,7,8,9,1,2},{6,7,2,1,9,5,3,4,8},{1,9,8,3,4,2,5,6,7},{8,5,9,7,6,1,4,2,3},{4,2,6,8,5,3,7,9,1},{7,1,3,9,2,4,8,5,6},{9,6,1,5,3,7,2,8,4},{2,8,7,4,1,9,6,3,5},{3,4,5,2,8,6,1,7,9}};
		Sudoku s = new Sudoku(puzzle);
		boolean bExpected = true;
		assertEquals(s.hasDuplicates(), bExpected);
	}
	
	@Test
	public void hasDuplicates_Test2(){
		int[][] puzzle = {{5,3,4,6,7,8,9,1,2},{6,7,2,1,9,5,3,4,8},{1,9,8,3,4,2,5,6,7},{8,5,9,7,6,1,4,2,3},{4,2,6,8,5,3,7,9,1},{7,1,3,9,2,4,8,5,6},{9,6,1,5,3,7,2,8,4},{2,8,7,4,1,9,6,3,5},{3,4,5,2,8,6,1,7,9}};
		Sudoku s = new Sudoku(puzzle);
		boolean bExpected = false;
		assertEquals(s.hasDuplicates(), bExpected);
	}
	
	@Test
	public void hasDuplicates_Test3(){
		int[][] puzzle = {{5,3,4,6,5,8,9,1,2},{6,7,2,1,9,0,3,4,8},{1,9,8,3,4,2,5,6,7},{8,0,9,7,6,1,4,2,3},{4,2,6,8,5,3,7,9,1},{7,1,3,9,2,4,8,5,6},{9,6,1,5,3,7,2,8,4},{2,8,7,4,1,9,6,3,5},{3,4,5,2,8,6,1,7,9}};
		Sudoku s = new Sudoku(puzzle);
		boolean bExpected = true;
		assertEquals(s.hasDuplicates(), bExpected);
	}
	
	@Test
	public void isPartialSudoku_Test1() {
		int[][] puzzle = {{5,3,4,6,7,8,9,1,2},{6,7,2,1,9,5,3,4,8},{1,9,8,3,4,2,5,6,7},{8,5,9,7,6,1,4,2,3},{4,2,6,8,5,3,7,9,1},{7,1,3,9,2,4,8,5,6},{9,6,1,5,3,7,2,8,4},{2,8,7,4,1,9,6,3,5},{3,4,5,2,8,6,1,7,9}};
		Sudoku s = new Sudoku(puzzle);
		
		assertFalse(s.isPartialSudoku());
	}
	
	@Test
	public void isPartialSudoku_Test2() {
		int[][] puzzle = {{5,3,4,6,7,8,9,1,2},{6,7,2,1,9,5,3,4,8},{1,9,8,3,4,2,5,6,7},{8,5,9,7,6,0,4,2,3},{4,2,6,8,5,3,7,9,1},{7,1,3,9,2,4,8,5,6},{9,6,1,5,3,7,2,8,4},{2,8,7,4,1,9,6,3,5},{3,4,5,2,8,6,1,7,9}};
		Sudoku s = new Sudoku(puzzle);
		
		assertTrue(s.isPartialSudoku());
	}
	
	@Test
	public void isSudoku_Test1() {
		int[][] puzzle = {{5,3,4,6,7,8,9,1,2},{6,7,2,1,9,5,3,4,8},{1,9,8,3,4,2,5,6,7},{8,5,9,7,6,1,4,2,3},{4,2,6,8,5,3,7,9,1},{7,1,3,9,2,4,8,5,6},{9,6,1,5,3,7,2,8,4},{2,8,7,4,1,9,6,3,5},{3,4,5,2,8,6,1,7,9}};
		Sudoku s = new Sudoku(puzzle);
		
		assertTrue(s.isSudoku());
	}
	
	@Test
	public void isSudoku_Test2() {
		int[][] puzzle = {{5,3,4,6,7,8,9,1,2},{6,7,2,1,9,5,3,4,8},{1,9,8,3,4,2,5,6,7},{8,5,9,7,6,0,4,2,3},{4,2,6,8,5,3,7,9,1},{7,1,3,9,2,4,8,5,6},{9,6,1,5,3,7,2,8,4},{2,8,7,4,1,9,6,3,5},{3,4,5,2,8,6,1,7,9}};
		Sudoku s = new Sudoku(puzzle);
		
		assertFalse(s.isSudoku());
	}
	
	@Test
	public void isValidValue_Test1() {
		int[][] puzzle = {{5,3,4,6,7,8,9,1,2},{6,7,2,1,9,5,3,4,8},{1,9,8,3,4,2,5,6,7},{8,5,9,7,6,1,4,2,3},{4,2,6,8,5,3,7,9,1},{7,1,3,9,2,4,8,5,6},{9,6,1,5,3,7,2,8,4},{2,8,7,4,1,9,6,3,5},{3,4,5,2,8,6,1,7,9}};
		Sudoku s = new Sudoku(puzzle);
		
		assertTrue(s.isValidValue(0,0,5));
	}
	
	@Test
	public void isValidValue_Test2() {
		int[][] puzzle = {{5,3,4,6,7,8,9,1,2},{6,7,2,1,9,5,3,4,8},{1,9,8,3,4,2,5,6,7},{8,5,9,7,6,1,4,2,3},{4,2,6,8,5,3,7,9,1},{7,1,3,9,2,4,8,5,6},{9,6,1,5,3,7,2,8,4},{2,8,7,4,1,9,6,3,5},{3,4,5,2,8,6,1,7,9}};
		Sudoku s = new Sudoku(puzzle);
		
		assertFalse(s.isValidValue(0,0,4));
	}
}
