package pkgGame;

import java.util.Arrays;

import pkgHelper.LatinSquare;

public class Sudoku extends LatinSquare {
	
	private int iSize;
	private int iSqrtSize;

	public Sudoku() {
		super();
	}
	
	public Sudoku(int[][] latinSquare) {
		super(latinSquare);
	}
	
	protected int[][] getPuzzle() {
		return super.getLatinSquare();
	}
	
	protected int[] getRegion(int iRegionNbr ) throws Exception {
		
		if ((iRegionNbr+1) > iSize)
			throw new Exception("Bad Region Call");
		
		int[] region = new int[iSize];
		int count = 0;
		for (int iRow = iSqrtSize* (iRegionNbr / iSqrtSize); iRow < iSqrtSize* (iRegionNbr / iSqrtSize) + iSqrtSize; iRow++) {
			for (int iCol = iSqrtSize * (iRegionNbr % iSqrtSize); iCol < iSqrtSize * (iRegionNbr % iSqrtSize) + iSqrtSize; iCol++) {
				region[count++] = this.getLatinSquare()[iRow][iCol];
			}
		}
		return region;
	}
	
	protected int[] getRegion(int col, int row) {
		return null;
	}
	
	protected boolean isSoduku() {
		// must be a latin square, and each region must also be a latin square
		return false;
	}
	
	protected boolean isPartialSoduku() {
		// must be a latin square and contain at least one zero (i.e., only partially completed)
		return false;
	}
	
	protected boolean isValueValid (int iValue, int col, int row) {
		return false;
	}
	
	@Override
	public boolean hasDuplicates(int[] arr) {
		boolean hasDuplicates = false;
		int[] sortedArray = Arrays.copyOf(arr, arr.length);
		Arrays.sort(sortedArray);
		for (int i = 0; i < sortedArray.length - 1; i++) {
			if (sortedArray[i] == sortedArray[i + 1] && sortedArray[i] != 0) {
				hasDuplicates = true;
				break;
			}
		}
		return hasDuplicates;

	}
	
}
