package com.example.demo.model;

public class GreenSnake extends Move{

	private boolean flag =true; 
	
	public GreenSnake(int nextPos) {
		super(nextPos);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isValidPos(int cellPos) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public int getNextPos() {
		int ne = 0;
		if(flag) {
			flag = false;
			ne = nextPos ; 
		}
		return ne;
		
	}

}
