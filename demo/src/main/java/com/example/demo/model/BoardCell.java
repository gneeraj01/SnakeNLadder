package com.example.demo.model;

public class BoardCell {
	
	
	private final int pos;
    private Move move = new DefaultMove();

    public BoardCell(int pos) {
        this.pos = pos;
    }

    public BoardCell(int pos, Move move) {
        this.pos = pos;
        this.move = move;
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
	        return nextPos;
	    }
    

}
