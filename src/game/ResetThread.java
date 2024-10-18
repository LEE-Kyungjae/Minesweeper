package game;

public class ResetThread extends Thread implements Runnable {

	  GamePage ms;
	  int rows;
	  int cols;
	  int numMines;
	  String verifier;

	  public ResetThread(int rows, int cols, int numMines, String verifier) {
	    this.rows = rows;
	    this.cols = cols;
	    this.numMines = numMines;
	    this.verifier = verifier;

	  }

	  // (int rows, int cols, int numMines)
	  @Override
	  public void run() {
	    try {
	      sleep(1000);
	      ms = new GamePage(rows, cols, numMines);
	    } catch (Exception e) {
	    }

	  }
	}