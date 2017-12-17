package com.jittat.gdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Timer;

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
	int count = 0;
	
	
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		String x = "bg.png";
		background = new Texture(x);
				
	}
	
	Random rand = new Random();
	int n = rand.nextInt(4);
		
	public void control(int st) {
		if (state == 11) {
			n = rand.nextInt(4);
			choose(n);
		}
		else
			choose(n);
		
	}
	
	int score = 0;
	
	public void choose(int toggle) {
		if (toggle == 0) {
			batch.draw(button.buttonBox(0,1),220,120);
			inputButton(state,"w");
		}
		else if (toggle == 1){
			batch.draw(button.buttonBox(1,1),150,50);
			inputButton(state,"a");
		}
		else if (toggle == 2){
			batch.draw(button.buttonBox(2,1),220,50);
			inputButton(state,"s");
		}
		else if (toggle == 3){
			batch.draw(button.buttonBox(3,1),290,50);
			inputButton(state,"d");
		}
		
	}
	
	public void inputButton(int state,String inp) {
		if (Gdx.input.isKeyJustPressed(Keys.W) & inp == "w") {
			System.out.println("W");
			upState();
		}
		else if (Gdx.input.isKeyJustPressed(Keys.A) & inp == "a") {
			System.out.println("A");
			upState();
		}
		else if (Gdx.input.isKeyJustPressed(Keys.S) & inp == "s") {
			System.out.println("S");
			upState();
		}
		else if (Gdx.input.isKeyJustPressed(Keys.D) & inp == "d") {
			System.out.println("D");
			upState();
		}
	
	}
	
	public void upState() {
		state++;
		if (state==11) {
			control(state);
			state = 0;
		}
	}
	
	public void downState() { ///////COMING SOON
		state--;		
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
		
//		inputButton(state);
		
		batch.draw(gauge.callGauge(state), 50,200); //update gauge
		
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		background.dispose();
	}
	

}