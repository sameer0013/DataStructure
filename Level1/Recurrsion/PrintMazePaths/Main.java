import java.io.*;
	import java.util.*;

	public class Main {

	    public static void main(String[] args) throws Exception {
			Scanner scn = new Scanner(System.in);
			int n=scn.nextInt();
			int m=scn.nextInt();
			printMazePathsPro(0,0,n-1,m-1,"");
			printMazePathsRea(0,0,n-1,m-1,"");

	    }

	    // sr - source row
	    // sc - source column
	    // dr - destination row
	    // dc - destination column
	    public static void printMazePathsPro(int sr, int sc, int dr, int dc, String psf) {
			//Proactive code
	        if(sr==dr&&sc==dc){
				System.out.println(psf);
				return;
			}
			if(sc<dc) printMazePathsPro(sr,sc+1,dr,dc,psf+'h');
			if(sr<dr) printMazePathsPro(sr+1,sc,dr,dc,psf+'v');
			return;
	    }
		public static void printMazePathsRea(int sr, int sc, int dr, int dc, String psf){
			//REACTIVE CODE
			if(sr>dr||sc>dc){
				return;
			}else if(sr==dr&&sc ==dc){
				System.out.println(psf);
				return;

			}
			printMazePathsRea(sr,sc+1,dr,dc,psf+'h');
			printMazePathsRea(sr+1,sc,dr,dc,psf+'v');
			return;
		}
	}
