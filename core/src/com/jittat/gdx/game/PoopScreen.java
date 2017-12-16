package com.jittat.gdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class PoopScreen extends ApplicationAdapter {
	Gauge guage;
	
	SpriteBatch batch;
	Texture background;
	
	Button button = null;
	Gauge gauge = null;
	ControlButton controlButton = null;
	
	int state = 0;
	boolean count = false;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		String x = "bg.png";
		background = new Texture(x);
				
	}

	public void control(int state) {
		int n = 0;
		for (int i = 0 ; i < state+1 ; i++)
		{
			Random rand = new Random();
			n = rand.nextInt(4);
			choose(n);
			
		}
	}
	
	public void delayForPress() {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void choose(int toggle) {
		int x = 0;
		if (toggle == 0) {
			batch.draw(button.buttonBox(0,1),220,120);
//			inputButton(state);
		}
		else if (toggle == 1){
			batch.draw(button.buttonBox(1,1),150,50);
//			inputButton(state);
		}
		else if (toggle == 2){
			batch.draw(button.buttonBox(2,1),220,50);
//			inputButton(state);
		}
		else if (toggle == 3){
			batch.draw(button.buttonBox(3,1),290,50);
//			inputButton(state);
		}
	}
	
	
	public void upState() {
		state++;
		if (state==11)
			state = 0;
	}
	
	String[] inputButtonFromPlayer = new String[11];
	
	public void inputButton(int state) {

		if (Gdx.input.isKeyJustPressed(Keys.W)) {
			System.out.println("W");
			inputButtonFromPlayer[state] = "w";
			upState();
		}
		else if (Gdx.input.isKeyJustPressed(Keys.A)) {
			System.out.println("A");
			inputButtonFromPlayer[state] = "a";
			upState();
		}
		else if (Gdx.input.isKeyJustPressed(Keys.S)) {
			System.out.println("S");
			inputButtonFromPlayer[state] = "s";
			upState();
		}
		else if (Gdx.input.isKeyJustPressed(Keys.D)) {
			System.out.println("D");
			inputButtonFromPlayer[state] = "d";
			upState();
		}
	}
	

	public void render () {
		
		batch.begin();
		
		batch.draw(background, 0, 0);
		
		///////////////BUTTON///////////////
				
		batch.draw(button.buttonBox(0,0),220,120);
		batch.draw(button.buttonBox(1,0),150,50);
		batch.draw(button.buttonBox(2,0),220,50);
		batch.draw(button.buttonBox(3,0),290,50);
		
		control(state); //show sequence with red button
		
		inputButton(state);
		
		batch.draw(gauge.callGauge(state), 50,200); //update gauge
		
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		background.dispose();
	}
	

}