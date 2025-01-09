import java.util.ArrayList;

public class Driver {
	public static void main(String str[]) {
		int [][] test = {{1,2,3},{4,0,6},{7,5,8}}; 
		int [][] test2 = {{1,2,3},{4,0,5},{7,8,6}};
		int [][] test3 = {{1,8,2},{0,4,3},{7,6,5}}; 
		int [][] test4 = {{0,7,4},{2,3,1},{8,6,5}}; 
		int [][] test5 = {{1,2,3},{0,4,6},{7,5,8}};
		int [][] test6 = {{4,1,3},{7,2,5},{0,8,6}}; 
		int [][] test7 = {{1,2,3},{8,5,0},{4,7,6}}; 
		int [][] test8 = {{1,5,3},{4,8,6},{7,0,2}}; 
		int [][] test9 = {{7,5,0},{6,1,8},{2,4,3}}; 
		NumberPuzzle a = new NumberPuzzle(test);
		NumberPuzzle b = new NumberPuzzle(test2);
		NumberPuzzle c = new NumberPuzzle(test3);
		NumberPuzzle d = new NumberPuzzle(test4);
		NumberPuzzle e = new NumberPuzzle(test5);
		NumberPuzzle f = new NumberPuzzle(test6);
		NumberPuzzle g = new NumberPuzzle(test7);
		NumberPuzzle h = new NumberPuzzle(test8);
		NumberPuzzle i = new NumberPuzzle(test9);
		ArrayList<NumberPuzzle> restricted=new ArrayList<NumberPuzzle>();
		System.out.println(i.solveNumberPuzzle(restricted, 26));
		/*System.out.println(x.getNum(2,2));
		System.out.println(y.emptyRow());
		System.out.println(y.emptyCol());
		System.out.println(x.solved());
		System.out.println(x.equals(y));
		System.out.println(x.canSlide("R"));
		x.slide("R");
		System.out.println(x.canSlide("L"));
		x.slide("L");
		System.out.println(x.canSlide("D"));
		x.slide("D");
		System.out.println(x.canSlide("U"));
		x.slide("U");*/
		}
}