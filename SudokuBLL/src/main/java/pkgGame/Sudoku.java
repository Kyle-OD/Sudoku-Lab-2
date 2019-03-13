package pkgGame;

import java.util.Arrays;

import pkgHelper.LatinSquare;

public class Sudoku extends LatinSquare{
	private int iSize;
	private int iSqrtSize;
	
	public Sudoku(int iSize) {
		
	}
	
	public Sudoku(int[][] puzzle) {
		super(puzzle);
	}
	
	@Override
	public boolean hasDuplicates(int[] arr) {
		boolean hasDuplicates = false;
		int[] sortedArray = Arrays.copyOf(arr, arr.length);
		//removeZeros(sortedArray);
		Arrays.sort(sortedArray);

		for (int i = 0; i < sortedArray.length - 1; i++) {
			if (sortedArray[i] == sortedArray[i + 1]) {
				hasDuplicates = true;
				break;
			}
		}
		return hasDuplicates;
	}
}
