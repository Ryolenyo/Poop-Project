package com.jittat.gdx.game;

import java.util.Random;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ControlButton {
	Button button = null;
	SpriteBatch batch;

	public void randomInt(int state){
		
		Random rand = new Random();
		int[] arrayNum = new int[state];
		
		for (int x = 0 ; x < state ; x++) {
			arrayNum[x] = rand.nextInt(10);
		}
		
	}
	

}