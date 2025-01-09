import java.util.*;
public class NumberPuzzle {
	private int[][] numPuzzle = new int[3][3];
	NumberPuzzle(int[][] nums) {
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				numPuzzle[i][j]=nums[i][j];
			}
		}
	}
	public int getNum(int row, int column) {
		return numPuzzle[row][column];
	}
	public int emptyRow() {
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				if (numPuzzle[i][j]==0)
					return i;
			}
		}
		return 0;
	}
	public int emptyCol() {
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				if (numPuzzle[i][j]==0)
					return j;
			}
		}
		return 0;
	}
	public boolean solved() {
		if (numPuzzle[0][0]==1&&numPuzzle[0][1]==2&&numPuzzle[0][2]==3
		&&numPuzzle[1][0]==4&&numPuzzle[1][1]==5&&numPuzzle[1][2]==6
		&&numPuzzle[2][0]==7&&numPuzzle[2][1]==8&&numPuzzle[2][2]==0)
			return true;
		else
			return false;
	}
	public NumberPuzzle slide(String dir) {
		int row = this.emptyRow();
		int col = this.emptyCol();
		int[][] slidNums = new int[3][3];
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				slidNums[i][j]=numPuzzle[i][j];
			}
		}
		if (dir.equals("U")) {
			slidNums[row][col]=this.getNum(row+1, col);
			slidNums[row+1][col]=0;
		} else if (dir.equals("D")) {
			slidNums[row][col]=this.getNum(row-1, col);
			slidNums[row-1][col]=0;
		} else if (dir.equals("R")) {
			slidNums[row][col]=this.getNum(row, col-1);
			slidNums[row][col-1]=0;
		} else if (dir.equals("L")) {
			slidNums[row][col]=this.getNum(row, col+1);
			slidNums[row][col+1]=0;
		}
		NumberPuzzle slidNumPuzzle = new NumberPuzzle(slidNums);
		return slidNumPuzzle;
	}
	public boolean canSlide(String dir) {
		if (dir.equals("U")&&this.emptyRow()!=2)
			return true;
		else if (dir.equals("D")&&this.emptyRow()!=0)
			return true;
		else if (dir.equals("L")&&this.emptyCol()!=2)
			return true;
		else if (dir.equals("R")&&this.emptyCol()!=0)
			return true;
		else
			return false;
	}
	public boolean equals(NumberPuzzle other) { 
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				if (numPuzzle[i][j]!=other.getNum(i,j))
					return false;
			}
		}
		return true;
	}
	public String solveNumberPuzzle(ArrayList<NumberPuzzle> restricted, int maxMoves) {
		String sequence;
		String bestSolution=null;
		boolean isRestricted=false;
		for (int i=0; i<restricted.size(); i++) {
			if (this.equals(restricted.get(i)))
				isRestricted=true;
		}
		restricted.add(this);
		if (this.solved()) {
			return "";
		} else if (maxMoves==0||isRestricted) {
			return null;
		} else {
			NumberPuzzle uPuzzle;
			NumberPuzzle dPuzzle;
			NumberPuzzle lPuzzle;
			NumberPuzzle rPuzzle;
			if (this.canSlide("U")&&!isRestricted) {
				uPuzzle=this.slide("U");
				sequence = uPuzzle.solveNumberPuzzle(restricted, maxMoves-1);
				restricted.remove(uPuzzle);
				if (sequence!=null) {
					sequence="U"+sequence;
					if (bestSolution==null||sequence.length()<=maxMoves) {
						maxMoves=sequence.length();
						bestSolution=sequence;
					}
				}
			}
			if (this.canSlide("D")&&!isRestricted) {
				dPuzzle=this.slide("D");
				sequence = dPuzzle.solveNumberPuzzle(restricted, maxMoves-1);
				restricted.remove(dPuzzle);
				if (sequence!=null) {
					sequence="D"+sequence;
					if (bestSolution==null||sequence.length()<=maxMoves) {
						maxMoves=sequence.length();
						bestSolution=sequence;
					}
				}
			}
			if (this.canSlide("L")&&!isRestricted) {
				lPuzzle=this.slide("L");
				sequence = lPuzzle.solveNumberPuzzle(restricted, maxMoves-1);
				restricted.remove(lPuzzle);
				if (sequence!=null) {
					sequence="L"+sequence;
					if (bestSolution==null||sequence.length()<=maxMoves) {
						maxMoves=sequence.length();
						bestSolution=sequence;
					}
				}
			}
			if (this.canSlide("R")&&!isRestricted) {
				rPuzzle=this.slide("R");
				sequence = rPuzzle.solveNumberPuzzle(restricted, maxMoves-1);
				restricted.remove(rPuzzle);
				if (sequence!=null) {
					sequence="R"+sequence;
					if (bestSolution==null||sequence.length()<=maxMoves) {
						maxMoves=sequence.length();
						bestSolution=sequence;
					}
				}
			}
		}
		return bestSolution;
	}
}