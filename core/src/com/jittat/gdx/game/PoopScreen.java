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
		if (point == 10) {
			n = rand.nextInt(8);
			choose(n);
		}
		else
			choose(n);
		
	}
	
	int score = 0;
	
	public void choose(int toggle) {
		if (toggle == 0) {
			batch.draw(button.buttonBox(0,1),200,120);
			inputButton(state,"w");
		}
		else if (toggle == 1){
			batch.draw(button.buttonBox(1,1),130,50);
			inputButton(state,"a");
		}
		else if (toggle == 2){
			batch.draw(button.buttonBox(2,1),200,50);
			inputButton(state,"s");
		}
		else if (toggle == 3){
			batch.draw(button.buttonBox(3,1),270,50);
			inputButton(state,"d");
		}
		else if (toggle == 4) {
			batch.draw(button.buttonBox(4,1),780,120);
			inputButton(state,"up");
		}
		else if (toggle == 5){
			batch.draw(button.buttonBox(5,1),710,50);
			inputButton(state,"left");
		}
		else if (toggle == 6){
			batch.draw(button.buttonBox(6,1),780,50);
			inputButton(state,"down");
		}
		else if (toggle == 7){
			batch.draw(button.buttonBox(7,1),850,50);
			inputButton(state,"right");
		}
		
	}
	
	int point = 0;
	
	public void inputButton(int state,String inp) {
		if (Gdx.input.isKeyJustPressed(Keys.W) & inp == "w") {
			System.out.println("W");
			upPoint();
		}
		else if (Gdx.input.isKeyJustPressed(Keys.A) & inp == "a") {
			System.out.println("A");
			upPoint();
		}
		else if (Gdx.input.isKeyJustPressed(Keys.S) & inp == "s") {
			System.out.println("S");
			upPoint();
		}
		else if (Gdx.input.isKeyJustPressed(Keys.D) & inp == "d") {
			System.out.println("D");
			upPoint();
		}
		else if (Gdx.input.isKeyJustPressed(Keys.UP) & inp == "up") {
			System.out.println("Up");
			upPoint();
		}
		else if (Gdx.input.isKeyJustPressed(Keys.LEFT) & inp == "left") {
			System.out.println("Left");
			upPoint();
		}
		else if (Gdx.input.isKeyJustPressed(Keys.DOWN) & inp == "down") {
			System.out.println("Down");
			upPoint();
		}
		else if (Gdx.input.isKeyJustPressed(Keys.RIGHT) & inp == "right") {
			System.out.println("Right");
			upPoint();
		}
	
	}
	
	public void upPoint() {
		point ++;
		if (point == 10) {
			upState();
			control(state);
			point = 0;
		}
	}
	
	public void upState() {
		state++;
		if (state==11) {
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
				
		batch.draw(button.buttonBox(0,0),200,120);
		batch.draw(button.buttonBox(1,0),130,50);
		batch.draw(button.buttonBox(2,0),200,50);
		batch.draw(button.buttonBox(3,0),270,50);
		
		batch.draw(button.buttonBox(4,0),780,120);
		batch.draw(button.buttonBox(5,0),710,50);
		batch.draw(button.buttonBox(6,0),780,50);
		batch.draw(button.buttonBox(7,0),850,50);
		
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