package com.example.demo.model;

public class BoardCell {
	
	
	private final int pos;
    private Move move = new DefaultMove();
    private boolean isValidPos; 

    public BoardCell(int pos) {
        this.pos = pos;
    }

    public BoardCell(int pos, Move move) {
        this.pos = pos;
        this.move = move;
    }
 
    public BoardCell(int pos, Move move, boolean isValidPos) {
        this.pos = pos;
        this.move = move;
        this.isValidPos = isValidPos;
    }
    
	public Move getMove() {
		return move;
	}

	public void setMove(Move move) throws Exception {
		if (move.isValidPos(pos)) {
            this.move = move;
        }
	}

	public int getPos() {
		return pos;
	}
  
	  public int nextPos() {
	        int nextPos = move.getNextPos();
	        if (nextPos == 0 && !this.isValidPos) {
	            return pos;
	        }
	        return nextPos;
	    }
    

}
