package pkgGame;

import java.util.Arrays;

import org.apache.commons.lang.ArrayUtils;

import pkgHelper.LatinSquare;

public class Sudoku extends LatinSquare {
	
	private int iSize;
	private int iSqrtSize;

	public Sudoku(int size) {
		super();
		this.iSize = size;
	}
	
	public Sudoku(int[][] latinSquare) {
		super(latinSquare);
		this.iSize = latinSquare.length;
		this.iSqrtSize = (int)Math.sqrt(iSize);
	}
	
	public int[][] getPuzzle() {
		return super.getLatinSquare();
	}
	
	public int[] getRegion(int iRegionNbr ){
		int[] region = new int[iSize];
		int count = 0;
		for (int iRow = iSqrtSize* (iRegionNbr / iSqrtSize); iRow < iSqrtSize* (iRegionNbr / iSqrtSize) + iSqrtSize; iRow++) {
			for (int iCol = iSqrtSize * (iRegionNbr % iSqrtSize); iCol < iSqrtSize * (iRegionNbr % iSqrtSize) + iSqrtSize; iCol++) {
				region[count++] = this.getLatinSquare()[iRow][iCol];
			}
		}
		return region;
	}
	
	public int[] getRegion(int col, int row) throws Exception {
		int region = this.iSqrtSize*(row/this.iSqrtSize)+(col/this.iSqrtSize);
		return getRegion(region);
	}
	
	@Override
	public boolean hasDuplicates(){
		if(super.hasDuplicates()) {
			return true;
		}
		for(int i = 0; i< this.getLatinSquare().length;i++) {
				if(hasDuplicates(this.getRegion(i))) {
					return true;
				}
		}
		return false;
	}

	public boolean isPartialSudoku() {
		if(this.hasDuplicates()) {
			return false;
		}
		boolean containsZero = false;
		for(int[] i:this.getLatinSquare()) {
			containsZero = ArrayUtils.contains(i, 0) || containsZero;
		}
		return containsZero;
	}

	public boolean isSudoku() {
		if(!this.isLatinSquare()) {
			return false;
		}
		if(this.hasDuplicates()) {
			return false;
		}
		for(int i = 0; i< this.getLatinSquare().length; i++) {
			if(!this.hasAllValues(this.getRegion(i),this.getRow(0))) { 
				return false; 
			} 
		}
		return true;
	}

	public boolean isValidValue(int iRow,int iCol,int iVal) {
		int prevVal = this.getLatinSquare()[iRow][iCol];
		this.getLatinSquare()[iRow][iCol] = iVal;
		if(this.hasDuplicates()) {
			this.getLatinSquare()[iRow][iCol] = prevVal;
			return false;
		}
		else {
			this.getLatinSquare()[iRow][iCol] = prevVal;
			return true;
		}
	}
}
