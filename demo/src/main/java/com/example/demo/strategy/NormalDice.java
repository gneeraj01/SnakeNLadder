package com.example.demo.strategy;

import java.util.Random;

/**
 * Dice with 1-6 numbers displayed
 * @author gneeraj
 *
 */
public class NormalDice implements RollingDice {

	@Override
	public int rollDice() {
		// TODO Auto-generated method stub
		Random random = new Random();
		//can generate random roll number from 1-6
        int dice = 1+random.nextInt(6);
        return dice;
	}

}
